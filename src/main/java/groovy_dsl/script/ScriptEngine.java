package groovy_dsl.script;


import groovy.util.GroovyScriptEngine;

public class ScriptEngine {
	public static void main(String[] args) throws Exception {
		GroovyScriptEngine engine = new GroovyScriptEngine("");
		
		Object obj = engine.run("src/main/java/groovy_dsl/script/script_test.groovy", "iamzhongyong");
		
		System.out.println(obj);
	}

}
