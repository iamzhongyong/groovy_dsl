package groovy_dsl.script;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.Script;


public class GroovyClassLoaderScript {

	public static void main(String[] args) throws Exception {
		
		StringBuffer groovyText = new StringBuffer();
		groovyText.append("def var1;n");

		groovyText.append("if(isIPCrediable) var1 = true;n");

		groovyText.append("else var1 = false;n");

		GroovyClassLoader groovyLoader = new GroovyClassLoader();

		Class<?> groovyClass = groovyLoader.parseClass(groovyText.toString());

		Script groovyScript = (Script)groovyClass.newInstance();

		Binding binding = new Binding();

		binding.setVariable("isIPCrediable", true);

		groovyScript.setBinding(binding);

		Object groovyResult = groovyScript.run();

		System.out.println(groovyResult);
	}
}
