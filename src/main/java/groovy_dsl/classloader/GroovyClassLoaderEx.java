package groovy_dsl.classloader;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;


public class GroovyClassLoaderEx {

	public static void main(String[] args) throws Exception, IOException {
		GroovyClassLoader loader = new GroovyClassLoader();
		
		for(int i=0;i<100;i++){
			Class<?> clazz = loader.parseClass(new File("src/main/java/groovy_dsl/classloader/UserDO.groovy"));
			
			GroovyObject clazzObj = (GroovyObject)clazz.newInstance();
			
			clazzObj.invokeMethod("setName", "iamzhongyong");
			clazzObj.invokeMethod("setSex", "Boy");
			clazzObj.invokeMethod("setAge", "26");
			
			System.out.println(clazzObj.invokeMethod("getAllInfo", null));
		}
		
	}
}
