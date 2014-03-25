package antlr4;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileInputStream;
import java.io.InputStream;

public class expmain {
public static void main(String[] args) throws Exception {

	String inputFile = null;
	 if ( args.length>0 ) inputFile = args[0];
	 InputStream is = System.in;
	 if ( inputFile!=null ) is = new FileInputStream(inputFile);
	 ANTLRInputStream input = new ANTLRInputStream(is);
	
QLLexer lexer = new QLLexer(input);
CommonTokenStream tokens = new CommonTokenStream(lexer);
QLParser parser = new QLParser(tokens);
ParseTree tree = parser.forms(); // parse; start at prog
System.out.println(tree.toStringTree(parser)); // print tree as text\
}
}