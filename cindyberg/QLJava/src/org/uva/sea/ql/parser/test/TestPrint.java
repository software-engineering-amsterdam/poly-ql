package org.uva.sea.ql.parser.test;


import org.junit.Test;
import org.uva.sea.ql.ast.ASTNode;
import org.uva.sea.ql.ast.IVisitor;
import org.uva.sea.ql.ast.PrintVisitor;
import org.uva.sea.ql.ast.statement.Form;

public class TestPrint extends TestParser {

	@Test
	public void parseTree(){
	ASTNode e = parser.parser( "form fName { hasName : \"label\" money\n"
				+ "if (hasName) {"
				+ "hasVar : \"label2\" boolean "
				+ "hasVar : \"label\" boolean (a + b)"
				+ "hasVar2 : \"label\" boolean }"
				+ "else {"
				+ "hasVar2 :\"label3\" integer } "
				+ "}");
	
	//System.out.print(((Expression) e).show());
	
	IVisitor visitor = new PrintVisitor();
	visitor.visit((Form) e);
	
	}
}
