//��һ���򵥵ķ�ʽ��ʵ��spring bean�����ļ�������
beans('default-autowire':'byName'){
	bean('id':'itemSerivce','class':'org.iamzhongyong.itemService')
}
def invokeMethod(name, args){
	print 'iamzhongyong spring groovy dsl'
}