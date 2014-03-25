package antlr4;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;
public class test3 {
	
	public static void main(String[] args) throws Exception {
		
		String inputFile = "C:\\Users\\nisha\\Documents\\poly-ql\\Nisha\\QLJava\\src\\test1.ql";
		if ( args.length>0 ) inputFile = args[0];
		
			InputStream is = System.in;
			
		if ( inputFile!=null ) is = new FileInputStream(inputFile);
		
			ANTLRInputStream input = new ANTLRInputStream(is);
			
		QLLexer lexer = new QLLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		QLParser parser = new QLParser(tokens);
		
		ParseTree tree = parser.forms(); 
		
		System.out.println(tree.toStringTree(parser)); 
		
		System.out.println("done");
		
	}
}