package org.uva.sea.ql.ast.form;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class FormTest {

	private IParse parser = new ANTLRParser();

	@Test
	public void testForms() throws ParseError, IOException {
		final String form = FileUtils.readFileToString(new File("HouseOwning.ql"));
		assertEquals(Form.class, parser.parseForm(form).getClass());
	}
}
