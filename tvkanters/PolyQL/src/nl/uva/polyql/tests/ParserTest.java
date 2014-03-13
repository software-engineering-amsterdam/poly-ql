package nl.uva.polyql.tests;


public class ParserTest {
    /*
     * @Before public void beforeTests() { Log.setLogging(false); }
     * 
     * @Test public void testIfStatement() { final Form form =
     * ParserHelper.parseResourceForm("ifstatement"); final Question question =
     * form.getQuestion("num"); final IfStatement ifStatement = (IfStatement)
     * form.getChildRules().get(1);
     * 
     * assertFalse(ifStatement.isVisible());
     * 
     * question.setValue(new NumberValue(10.0));
     * 
     * assertTrue(ifStatement.isVisible()); }
     * 
     * @Test public void testIfStatementType() { try {
     * ParserHelper.parseResourceForm("ex_ifstatement");
     * fail("No exception throw for non-boolean if-statement expression"); } catch (final
     * InvalidIfStatementTypeException ex) { // Test passed } }
     * 
     * @Test public void testPrecedence() { final Form form =
     * ParserHelper.parseResourceForm("precedence"); assertEquals(7.0,
     * form.getQuestion("qSumMult").getValue().getValue()); assertEquals(3.0,
     * form.getQuestion("qSubDiv").getValue().getValue()); assertEquals(true,
     * form.getQuestion("qAndOrAnd").getValue().getValue()); assertEquals(true,
     * form.getQuestion("qSumGt").getValue().getValue()); assertEquals(1.0,
     * form.getQuestion("qBracket").getValue().getValue()); assertEquals(1.0,
     * form.getQuestion("qSubMod").getValue().getValue()); }
     * 
     * @Test public void testWarnings() { final Form formWarnings =
     * ParserHelper.parseResourceForm("warnings"); assertEquals(1,
     * formWarnings.getWarnings().size());
     * 
     * final Form formNoWarnings = ParserHelper.parseResourceForm("nowarnings"); assertEquals(0,
     * formNoWarnings.getWarnings().size()); }
     * 
     * @Test public void testTypes() { // // try { //
     * ParserHelper.parseResourceForm("ex_bool_plus_num"); // fail("No exception thrown"); // }
     * catch (final UnsupportedOperandTypeException ex) { // assertEquals(Type.BOOLEAN,
     * ex.getLeft()); // assertEquals(Type.NUMBER, ex.getRight()); // assertEquals("+",
     * ex.getOperatorSyntax()); // } // // try { //
     * ParserHelper.parseResourceForm("ex_string_min_num"); // fail("No exception thrown"); // }
     * catch (final UnsupportedOperandTypeException ex) { // assertEquals(Type.STRING,
     * ex.getLeft()); // assertEquals(Type.NUMBER, ex.getRight()); // assertEquals("-",
     * ex.getOperatorSyntax()); // } }
     * 
     * @Test public void testDuplicateId() { try { ParserHelper.parseResourceForm("ex_duplicateid");
     * fail("No exception throw for duplicate IDs"); } catch (final DuplicateQuestionIdException ex)
     * { // Test passed } }
     * 
     * @Test public void testInvalidId() { try { ParserHelper.parseResourceForm("ex_invalidid");
     * fail("No exception throw for invalid IDs"); } catch (final InvalidQuestionIdException ex) {
     * // Test passed } }
     * 
     * @Test public void testModifier() { try { ParserHelper.parseResourceForm("ex_modifier");
     * fail("No exception throw for invalid IDs"); } catch (final InvalidModifierException ex) {
     * assertEquals(ModifierHelper.getBySyntax("!"), ex.getModifier()); } }
     */
}
