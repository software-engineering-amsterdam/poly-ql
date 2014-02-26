package ql.parser.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import ql.ast.form.Form;
import ql.ast.form.FormItems;
import ql.ast.form.Question;
import ql.parser.antlr.FormParser;


public class TestForms {

	FormParser parser = new FormParser();
	
	@Test 
	public void testFormParser() throws ParseError, IOException {
		assertEquals(parser.parseForm("/home/lulu/workspace/poly-ql/lulu/QL/src/ql/parser/antlr/form.ql").getClass(),Form.class);
		assertEquals(parser.parseForm("/home/lulu/workspace/poly-ql/lulu/QL/src/ql/parser/antlr/form.ql").getFormItems().size(),3);
		assertEquals(parser.parseForm("/home/lulu/workspace/poly-ql/lulu/QL/src/ql/parser/antlr/form.ql").getFormItems().get(0).getClass(),Question.class);
		Question q1 = (Question) parser.parseForm("/home/lulu/workspace/poly-ql/lulu/QL/src/ql/parser/antlr/form.ql").getFormItems().get(0);
		Question q2 = (Question) parser.parseForm("/home/lulu/workspace/poly-ql/lulu/QL/src/ql/parser/antlr/form.ql").getFormItems().get(1);
		assertEquals(q1.getType(),q2.getType());
		
	}
}