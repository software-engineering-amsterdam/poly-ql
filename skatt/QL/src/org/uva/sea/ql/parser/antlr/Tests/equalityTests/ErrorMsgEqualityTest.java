package org.uva.sea.ql.parser.antlr.Tests.equalityTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.Messages.ConditionError;
import org.uva.sea.ql.parser.antlr.QL4.Messages.CyclicDependencyError;
import org.uva.sea.ql.parser.antlr.QL4.Messages.DuplicateLabelError;
import org.uva.sea.ql.parser.antlr.QL4.Messages.DuplicateQuestionError;
import org.uva.sea.ql.parser.antlr.QL4.Messages.InvalidTypeError;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Messages.UndefinedQuestionError;


/**
 * Performs equality checks of several elements in the QL4 software
 * @author Sammie Katt
 *
 */
public class ErrorMsgEqualityTest {
	
	private Identifier id1, id2, idsame;
	private QLErrorMsg msg1, msg2, msg3, msgsame;
	private Label label1, label2, labelsame;
	
	@Before 
	public void setUp() {
		id1 = new Identifier("ID1");
		idsame = new Identifier("ID1");
		id2 = new Identifier("ID2");
		label1 = new Label("question label1");
		labelsame = new Label("question label1");
		label2 = new Label("question label2");
	}
	
	@Test
	public void testErrorMsgEquality() {
		msg1 = new ConditionError(id1);
		msgsame = new ConditionError(id1);
		msg2 = new ConditionError(id2);
		
		assertEquals(msg1, msgsame);
		assertFalse(msg1.equals(msg2));
		
		msg1 = new UndefinedQuestionError(id1);
		msgsame = new UndefinedQuestionError(idsame);
		msg2 = new UndefinedQuestionError(id2);
		
		assertEquals(msg1, msgsame);
		assertFalse(msg1.equals(msg2));
		
		msg1 = new DuplicateLabelError(label1);
		msgsame = new DuplicateLabelError(labelsame);
		msg2 = new DuplicateLabelError(label2);
		
		assertEquals(msg1, msgsame);
		assertFalse(msg1.equals(msg2));
		
		msg1 = new DuplicateQuestionError(id1);
		msgsame = new DuplicateQuestionError(idsame);
		msg2 = new DuplicateQuestionError(id2);
		
		assertEquals(msg1, msgsame);
		assertFalse(msg1.equals(msg2));
	}
	
	@Test
	public void testCyclicDependencyError() {
		Identifier id3 = new Identifier("ID3");
		
		msg1 = new CyclicDependencyError(id1, id2);
		msgsame = new CyclicDependencyError(id1, id2);
		msg2 = new CyclicDependencyError(id1, id3);
		msg3 = new CyclicDependencyError(id3, id1);
		
		assertEquals(msg1, msgsame);
		assertEquals(msg2, msg3);
		assertFalse(msg1.equals(msg2));
		assertFalse(msg1.equals(msg3));
	}
	
	@Test
	public void testInvalidTypeError() {
		
		msg1 = new InvalidTypeError(id1);
		msgsame = new InvalidTypeError(id1);
		msg2 = new InvalidTypeError(id2);
		
		assertEquals(msg1, msgsame);
		assertFalse(msg1.equals(msg2));
	}
	@Test
	public void testIdentifierEquality() {
		assertEquals(id1, idsame);
		assertFalse(id1.equals(id2));
	}
	
	@Test
	public void testLabelEquality() {
		assertEquals(label1, labelsame);
		assertFalse(label1.equals(label2));
	}
	
}
