package org.uva.sea.ql.checker;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class FormCheckerTest {
	private IParse parser = new ANTLRParser();

	@Test
	public void testFormChecker() throws ParseError, IOException
	{
		final String formString = FileUtils.readFileToString(new File("HouseOwning.ql"));
		
		Form form = parser.parseForm(formString);
		
		TypeEnvironment typeEnv = new TypeEnvironment();
		ArrayList<String> errors = new ArrayList<String>();
		
		assertTrue(FormChecker.check(form, typeEnv, errors));
	}
}
