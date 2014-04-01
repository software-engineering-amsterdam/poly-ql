package org.uva.sea.ql.parser.antlr.Tests.equalityTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.BoolType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.CurrencyType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.DateType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NullType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NumberType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;

/**
 * Performs tests on equality functionality of QL4 types
 * @author Sammie Katt
 * 
 * TODO
 */
/**
 * Performs tests on equality functionality of QL4 types
 * @author Sammie Katt
 * 
 */
public class TypeEqualityTest {

	Type type1;
	Type type2;
	Type typeSame;
	
	@Before
	public void setUp() {
		type2 = new NullType();
	}
	
	public void testEquality() {
		assertEquals(type1, typeSame);
		assertFalse(type1.equals(type2));
	}
	
	@Test
	public void testBoolType() {
		type1 = new BoolType();
		typeSame = new BoolType();
		
		testEquality();
	}
	
	@Test
	public void testCurrencyType() {
		type1 = new CurrencyType();
		typeSame = new CurrencyType();
		
		testEquality();
	}
	
	@Test
	public void testDateType() {
		type1 = new DateType();
		typeSame = new DateType();
		
		testEquality();
	}
	
	@Test
	public void testNullType() {
		type1 = new NullType();
		typeSame = new NullType();
		type2 = new BoolType();
		
		testEquality();
	}
	
	@Test
	public void testNumberType() {
		type1 = new NumberType();
		typeSame = new NumberType();
		
		testEquality();
	}
	
	@Test
	public void testStringType() {
		type1 = new CurrencyType();
		typeSame = new CurrencyType();
		
		testEquality();
	}
}
