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