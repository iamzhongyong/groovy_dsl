//调用html方法，参数是一个闭包
html {  
	//调用head方法，参数为一个闭包
    head {  
		//调用meta方法，参数是一个闭包，闭包内部没有内容
        meta {  
           "iamzhongyong.iteye.com"
        }  
    }  
	//调用bod方法，参数是一个闭包
    body {  
		//调用table方法，第一个参数是一个Map，第二个参数是一个闭包
        table (style:'margin:5px;') {  
			//调用tr方法，第一个参数是一个Map，第二个是闭包，调用三个td方法，参数是闭包，直接返回一段文本
            tr ('class':'trClass', style:'padding:5px;') {  
                td {'Cell1'}  
                td {'Cell2'}  
                td {'Cell3'}  
            }  
        }  
    }  
} 
//重写Script中的invokeMethod的方法，调用上述脚本中的方法
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