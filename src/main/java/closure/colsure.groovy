//��һ������
def shout = {src->
		return src.toUpperCase()
	}
 println shout("Hello World")
 
 //ģ��һ��forѭ��������,��List��ѭ�������Closure
 def names = ["alibaba-inc.com","bixiao.zy","hello world","iamzhongyong"]
 printInfo = {
	 println "hello,${it},welcome"
 }
 names.each printInfo
 
 //Colsure��Ϊ���������
 def closureMethod(Closure c) {
	 c.call("iamzhongyong")
}
closureMethod { name->
	 println "Closure called "+name
}

//Ϊ�����ṩĬ��ֵ
greetString = { greet,name = "iamzhongyong" ->
	return "${greet},${name}"
}
assert greetString("welcome") == "welcome,iamzhongyong"
assert greetString("hello","bixiao.zy") == "hello,bixiao.zy"

//ʹ�ñհ�ʵ�ֵ������ӿ� 
interface Test {
	def one()
}
def test = {println 'one'} as Test 
test.one()

//ʹ�ñհ�ʵ�ֶ෽���ӿ� 
interface Test {
	def one()
	def two()
}
def test = [
	one: {println 'one'},
	two: {println 'two'}
	] as Test
test.one()
test.two()