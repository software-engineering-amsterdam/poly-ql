package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.uva.sea.ql.ast.statement.*;

public class TestForm extends TestParser {
	
	@Test
	public void testForms(){
		
		 
		assertEquals(parser.parser("form fName { "
				+ "hasName : \"label\" money }").getClass(),Form.class);
		//assertEquals(parser.parser("form fName { hasName : \"label\" money\n"
		//		+ "hasName2 : \"lalala\" boolean }").getClass(),Form.class);
		assertEquals(parser.parser("form fName { hasName : \"label\" money\n"
				+ "if (hasName) {"
				+ "hasVar : \"label2\" boolean } }").getClass(), Form.class);
		assertEquals(parser.parser("form fName { hasName : \"label\" money\n"
				+ "if (hasName) {"
				+ "hasVar : \"label2\" boolean }"
				+ "else {"
				+ "hasVar2 :\"label3\" integer } }").getClass(), Form.class);
	}

}
