//第一个例子
def shout = {src->
		return src.toUpperCase()
	}
 println shout("Hello World")
 
 //模拟一个for循环的例子,在List的循环中添加Closure
 def names = ["alibaba-inc.com","bixiao.zy","hello world","iamzhongyong"]
 printInfo = {
	 println "hello,${it},welcome"
 }
 names.each printInfo
 
 //Colsure作为方法的入参
 def closureMethod(Closure c) {
	 c.call("iamzhongyong")
}
closureMethod { name->
	 println "Closure called "+name
}

//为参数提供默认值
greetString = { greet,name = "iamzhongyong" ->
	return "${greet},${name}"
}
assert greetString("welcome") == "welcome,iamzhongyong"
assert greetString("hello","bixiao.zy") == "hello,bixiao.zy"

//使用闭包实现单方法接口 
interface Test {
	def one()
}
def test = {println 'one'} as Test 
test.one()

//使用闭包实现多方法接口 
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