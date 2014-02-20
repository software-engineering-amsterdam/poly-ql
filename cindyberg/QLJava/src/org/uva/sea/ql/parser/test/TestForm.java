package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.Form;

public class TestForm extends TestParser {
	
	@Test
	public void testForms(){
		
		 
		assertEquals(parser.parser("form fName { "
				+ "hasName : \"label\" money }").getClass(),Form.class);
		//assertEquals(parser.parser("form fName { "
		//		+ "hasName : \"label\" boolean (true && false)}").getClass(),Form.class);
		assertEquals(parser.parser("form fName { "
				+ "hasName : \"label\" money "
				+ "if(BLA){hasName : \"label\" money} }").getClass(),Form.class);
		assertEquals(parser.parser("form fName { hasName : \"label\" money ( a + b )\n"
				+ "hasName2 : \"lalala\" boolean }").getClass(),Form.class);
		assertEquals(parser.parser("form F { NieuwVar : \"lala\" boolean "
		      + "if (NieuwVar) "
		      + "{ Hasiets : \"mones\" integer } }").getClass(),Form.class);
		
		assertEquals(parser.parser("form fName { hasName : \"label\" money\n"
				+ "if (hasName) {"
				+ "hasVar : \"label2\" boolean } }").getClass(), Form.class);
		assertEquals(parser.parser("form fName { hasName : \"label\" money\n"
				+ "if (hasName) {"
				+ "hasVar : \"label2\" boolean "
				+ "hasVar : \"label\" boolean (a + b)"
				+ "hasVar2 : \"label\" boolean }"
				+ "else {"
				+ "hasVar2 :\"label3\" integer } }").getClass(), Form.class);
		//with comments
		assertEquals(parser.parser("form fName { hasName : \"label\" money\n"
				+ "if (hasName) {"
				+ "/*hasVar : \"label2\" boolean "
				+ "hasVar : \"label\" boolean (a + b)*/"
				+ "hasVar2 : \"label\" boolean }"
				+ "else {"
				+ "hasVar2 :\"label3\" integer } }").getClass(), Form.class);
		assertEquals(parser.parser("form fName { hasName : \"label\" money\n"
				+ "if (hasName) {"
				+ "// hasVar : \"label2\" boolean \n"
				+ "hasVar : \"label\" boolean (a + b)"
				+ "hasVar2 : \"label\" boolean }"
				+ "else {"
				+ "hasVar2 :\"label3\" integer } }").getClass(), Form.class);
	}
	

}
