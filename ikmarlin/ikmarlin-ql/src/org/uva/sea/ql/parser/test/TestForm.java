package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;
import org.uva.sea.ql.ast.form.Form;

public class TestForm {

	private FormParser parser;

	public TestForm() {
		this.parser = new FormParser();
	}
	
	@Test
	public void testForm() throws ParseError, FileNotFoundException {
		assertEquals(parser.parse(new File("C:\\server\\nginx\\WempServer\\www\\SW4\\poly-ql\\ikmarlin\\ikmarlin-ql\\src\\org\\uva\\sea\\ql\\parser\\test\\testForm")).getClass(), Form.class);
	}

}
