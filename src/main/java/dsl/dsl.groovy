//����html������������һ���հ�
html {  
	//����head����������Ϊһ���հ�
    head {  
		//����meta������������һ���հ����հ��ڲ�û������
        meta {  
           "iamzhongyong.iteye.com"
        }  
    }  
	//����bod������������һ���հ�
    body {  
		//����table��������һ��������һ��Map���ڶ���������һ���հ�
        table (style:'margin:5px;') {  
			//����tr��������һ��������һ��Map���ڶ����Ǳհ�����������td�����������Ǳհ���ֱ�ӷ���һ���ı�
            tr ('class':'trClass', style:'padding:5px;') {  
                td {'Cell1'}  
                td {'Cell2'}  
                td {'Cell3'}  
            }  
        }  
    }  
} 
//��дScript�е�invokeMethod�ķ��������������ű��еķ���
def invokeMethod(String name, args) {
	print "<${name}"
	args.each { arg ->
		if (arg instanceof Map) {
			arg.each {
				print " ${it.key} = '${it.value}' "
			}
		} else if (arg instanceof Closure) {
			print '>'
			arg.delegate = this
			def value = arg.call()
			if (value) {
				print "${value}"
			}
		}
	}
	println "</${name}>"
}