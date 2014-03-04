import ParseDsl;
class DslExample extends GroovyTestCase {
	
		void testDslUsage_outputXml() {
			ParseDsl.make {
				to "Nirav Assar"
				from "Barack Obama"
				body "How are things? We are doing well. Take care"
				idea "The economy is key"
				request "Please vote for me"
				xml
			}
		}
	
		void testDslUsage_outputHtml() {
			ParseDsl.make {
				to "Nirav Assar"
				from "Barack Obama"
				body "How are things? We are doing well. Take care"
				idea "The economy is key"
				request "Please vote for me"
				html
			}
		}
	
		void testDslUsage_outputText() {
			ParseDsl.make {
				to "Nirav Assar"
				from "Barack Obama"
				body "How are things? We are doing well. Take care"
				idea "The economy is key"
				request "Please vote for me"
				text
			}
		}
	}