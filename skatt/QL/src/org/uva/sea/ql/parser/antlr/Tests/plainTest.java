package org.uva.sea.ql.parser.antlr.Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;

public class plainTest extends QL4Test {

	
	@BeforeClass 
	public static void initialize() {
		setFile("test/plainTest");
	}
	
	@Test
	public void testPlainQuestionary() {
		assertEquals(new ArrayList<QLErrorMsg> (), errors);
	}
}
