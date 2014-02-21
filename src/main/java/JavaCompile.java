import java.io.IOException; 
import java.lang.reflect.Method; 
import java.net.URI; 
import java.util.Arrays;
import javax.tools.JavaCompiler; 
import javax.tools.JavaFileObject; 
import javax.tools.SimpleJavaFileObject; 
import javax.tools.StandardJavaFileManager; 
import javax.tools.ToolProvider;
public class JavaCompile { 
    public static void main(String[] args) throws Exception { 
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler(); 
        System.out.println(""+ToolProvider.getSystemJavaCompiler()); 
        StandardJavaFileManager fileManager = compiler.getStandardFileManager( 
                null, null, null);
        StringObject so = new StringObject( 
                "CalculatorTest", 
                "class CalculatorTest {" 
                        + " public int multiply(int multiplicand, int multiplier) {" 
                        + " System.out.println(multiplicand);" 
                        + " System.out.println(multiplier);" 
                        + " return multiplicand * multiplier;" + " }" + "}");
        JavaFileObject file = so;
        Iterable files = Arrays.asList(file); 
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, 
                null, null, null, files);
        Boolean result = task.call(); 
        System.out.println(result); 
        if (result) { 
            Class clazz = Class.forName("CalculatorTest");
            Object instance = clazz.newInstance();
            Method m = clazz.getMethod("multiply", new Class[] { int.class, 
                    int.class });
            Object[] o = new Object[] { 3, 2 }; 
            System.out.println(m.invoke(instance, o)); 
        } 
    } 
}
class StringObject extends SimpleJavaFileObject { 
    private String contents = null;
    public StringObject(String className, String contents) throws Exception { 
        super(URI.create("string:///" + className.replace('.', '/') 
                + Kind.SOURCE.extension), Kind.SOURCE); 
        this.contents = contents; 
    }
    public CharSequence getCharContent(boolean ignoreEncodingErrors) 
            throws IOException { 
        return contents; 
    } 
}
