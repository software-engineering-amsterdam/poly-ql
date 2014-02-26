package nl.uva.polyql.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import nl.uva.polyql.Log;
import nl.uva.polyql.ParserHelper;
import nl.uva.polyql.model.Form;
import nl.uva.polyql.model.IfStatement;
import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.expressions.operators.UnsupportedOperandTypeException;
import nl.uva.polyql.model.types.Type;

import org.junit.Before;
import org.junit.Test;

public class ParserTest {

    @Before
    public void beforeTests() {
        Log.disable();
    }

    @Test
    public void testIfStatement() {
        final Form form = ParserHelper.parseResourceForm("ifstatement");
        final Question question = form.getQuestion("num");
        final IfStatement ifStatement = (IfStatement) form.getRules().get(1);

        assertFalse(ifStatement.isSatisfied());

        question.setValueFromInput("10");

        assertTrue(ifStatement.isSatisfied());
    }

    @Test
    public void testPrecedence() {
        final Form form = ParserHelper.parseResourceForm("precedence");
        assertEquals(7.0, form.getQuestion("qSumMult").getValue().getValue());
        assertEquals(3.0, form.getQuestion("qSubDiv").getValue().getValue());
        assertEquals(true, form.getQuestion("qAndOrAnd").getValue().getValue());
        assertEquals(true, form.getQuestion("qSumGt").getValue().getValue());
        assertEquals(1.0, form.getQuestion("qBracket").getValue().getValue());
        assertEquals(1.0, form.getQuestion("qSubMod").getValue().getValue());
    }

    @Test
    public void testWarnings() {
        final Form formWarnings = ParserHelper.parseResourceForm("warnings");
        assertEquals(1, formWarnings.getWarnings().size());

        final Form formNoWarnings = ParserHelper.parseResourceForm("nowarnings");
        assertEquals(0, formNoWarnings.getWarnings().size());
    }

    @Test
    public void testTypes() {

        try {
            ParserHelper.parseResourceForm("ex_bool_plus_num");
            fail("No exception throw");
        } catch (final UnsupportedOperandTypeException ex) {
            assertEquals(Type.BOOLEAN, ex.getLeft());
            assertEquals(Type.NUMBER, ex.getRight());
            assertEquals("+", ex.getOperatorSyntax());
        }

        try {
            ParserHelper.parseResourceForm("ex_string_min_num");
            fail("No exception throw");
        } catch (final UnsupportedOperandTypeException ex) {
            assertEquals(Type.STRING, ex.getLeft());
            assertEquals(Type.NUMBER, ex.getRight());
            assertEquals("-", ex.getOperatorSyntax());
        }
    }

    // @Test
    // public void testDuplicateId() {
    // try {
    // ParserHelper.parseResourceForm("duplicateid");
    // fail("No exception throw");
    // } catch (final UnsupportedOperandTypeException ex) {
    // assertEquals(Type.STRING, ex.getLeft());
    // assertEquals(Type.NUMBER, ex.getRight());
    // assertEquals("-", ex.getOperatorSyntax());
    // }
    // }
}
