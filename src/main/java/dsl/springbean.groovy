//用一个简单的方式，实现spring bean配置文件的配置
beans('default-autowire':'byName'){
	bean('id':'itemSerivce','class':'org.iamzhongyong.itemService')
}
def invokeMethod(name, args){
	print 'iamzhongyong spring groovy dsl'
}