package groovy_dsl.shell;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

public class GroovyShellEx {

	public static void main(String[] args) {
		Binding bind = new Binding();
		bind.setVariable("name", "iamzhongyong");
		bind.setVariable("age", "25");
		
		GroovyShell shell = new GroovyShell(bind);
		
		Object obj = shell.evaluate("str = name+age;return str");
		
		System.out.println(obj);
	}
}
