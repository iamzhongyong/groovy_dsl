import groovy.xml.MarkupBuilder;
/**
* ����һ���Զ����DSL�ı����࣬���ƽ�������
*/
class ParseDsl {

    String toText
    String fromText
    String body
    def sections = []

    
    def static make(closure) {
        ParseDsl memoDsl = new ParseDsl()
        closure.delegate = memoDsl
        closure()
    }

    def to(String toText) {
        this.toText = toText
    }

    def from(String fromText) {
        this.fromText = fromText
    }

    def body(String bodyText) {
        this.body = bodyText
    }

	//groovy methodMissing����Ҳ����������ͻ�����������
    def methodMissing(String methodName, args) {
        def section = new Section(title: methodName, body: args[0])
        sections << section
    }

    def getXml() {
        doXml(this)
    }

    def getHtml() {
        doHtml(this)
    }

    def getText() {
        doText(this)
    }

    private static doXml(ParseDsl memoDsl) {
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.memo() {
            to(memoDsl.toText)
            from(memoDsl.fromText)
            body(memoDsl.body)
            for (s in memoDsl.sections) {
                "$s.title"(s.body)
            }
        }
        println writer
    }

    private static doHtml(ParseDsl memoDsl) {
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.html() {
            head {
                title("Memo")
            }
            body {
                h1("Memo")
                h3("To: ${memoDsl.toText}")
                h3("From: ${memoDsl.fromText}")
                p(memoDsl.body)
                for (s in memoDsl.sections) {
                    p {
                        b(s.title.toUpperCase())
                    }
                    p(s.body)
                }
            }
        }
        println writer
    }

    private static doText(ParseDsl memoDsl) {
        String template = "Memo\nTo: ${memoDsl.toText}\nFrom: ${memoDsl.fromText}\n${memoDsl.body}\n"
        def sectionStrings =""
        for (s in memoDsl.sections) {
            sectionStrings += s.title.toUpperCase() + "\n" + s.body + "\n"
        }
        template += sectionStrings
        println template
    }
}