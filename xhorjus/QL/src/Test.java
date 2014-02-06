import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

/**
 * Test class to instantiate Test expression and do stuff.
 */
public class Test {
	public static void main(String[] args) throws IOException {
	    ANTLRInputStream input = new ANTLRInputStream(System.in);
	    
	    TestLexer lexer = new TestLexer(input);
	    
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    
	    TestParser parser = new TestParser(tokens);
	   
	    ParseTree tree = parser.init();
	    
	    System.out.println(tree.toStringTree(parser));
	    
	}

}
