package nl.uva.polyql.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import nl.uva.polyql.Log;
import nl.uva.polyql.ParserHelper;
import nl.uva.polyql.ast.Form;
import nl.uva.polyql.ast.IfStatement;
import nl.uva.polyql.ast.Question;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.validation.DuplicateIdError;
import nl.uva.polyql.validation.DuplicateLabelWarning;
import nl.uva.polyql.validation.InvalidIfStatementError;
import nl.uva.polyql.validation.InvalidOperandError;
import nl.uva.polyql.validation.UnknownIdError;
import nl.uva.polyql.validation.ValidationError;
import nl.uva.polyql.validation.Validator;

import org.junit.Before;
import org.junit.Test;

public class ParserTest {

    @Before
    public void beforeTests() {
        Log.setLogging(false);
    }

    @Test
    public void testIfStatement() {
        final Form form = ParserHelper.parseResourceForm("ifstatement");
        Validator.validate(form);

        final Question question = form.getQuestion("num");
        final IfStatement ifStatement = (IfStatement) form.getChildRules().get(1);

        assertFalse(ifStatement.isVisible());

        question.setValue(new NumberValue(10.0));

        assertTrue(ifStatement.isVisible());
    }

    @Test
    public void testIfStatementType() {
        final Form form = ParserHelper.parseResourceForm("ex_ifstatement");
        final Validator validator = Validator.validate(form);
        final List<ValidationError> errors = validator.getErrors();

        assertEquals(1, errors.size());
        assertTrue(errors.get(0) instanceof InvalidIfStatementError);
    }

    @Test
    public void testPrecedence() {
        final Form form = ParserHelper.parseResourceForm("precedence");
        Validator.validate(form);

        assertEquals(7.0, form.getQuestion("qSumMult").getValue().getValue());
        assertEquals(3.0, form.getQuestion("qSubDiv").getValue().getValue());
        assertEquals(true, form.getQuestion("qAndOrAnd").getValue().getValue());
        assertEquals(true, form.getQuestion("qSumGt").getValue().getValue());
        assertEquals(1.0, form.getQuestion("qBracket").getValue().getValue());
        assertEquals(1.0, form.getQuestion("qSubMod").getValue().getValue());
    }

    @Test
    public void testWarnings() {
        Form form = ParserHelper.parseResourceForm("warnings");
        Validator validator = Validator.validate(form);
        List<ValidationError> errors = validator.getErrors();

        assertEquals(1, errors.size());
        assertTrue(errors.get(0) instanceof DuplicateLabelWarning);

        form = ParserHelper.parseResourceForm("nowarnings");
        validator = Validator.validate(form);
        errors = validator.getErrors();

        assertEquals(0, errors.size());
    }

    @Test
    public void testTypes() {
        Form form = ParserHelper.parseResourceForm("ex_bool_plus_num");
        Validator validator = Validator.validate(form);
        List<ValidationError> errors = validator.getErrors();

        assertEquals(4, errors.size());
        assertTrue(errors.get(0) instanceof DuplicateLabelWarning);
        assertTrue(errors.get(1) instanceof DuplicateLabelWarning);
        assertTrue(errors.get(2) instanceof DuplicateLabelWarning);
        assertTrue(errors.get(3) instanceof InvalidOperandError);

        form = ParserHelper.parseResourceForm("ex_string_min_num");
        validator = Validator.validate(form);
        errors = validator.getErrors();

        assertEquals(4, errors.size());
        assertTrue(errors.get(0) instanceof DuplicateLabelWarning);
        assertTrue(errors.get(1) instanceof DuplicateLabelWarning);
        assertTrue(errors.get(2) instanceof DuplicateLabelWarning);
        assertTrue(errors.get(3) instanceof InvalidOperandError);
    }

    @Test
    public void testDuplicateId() {
        final Form form = ParserHelper.parseResourceForm("ex_duplicateid");
        final Validator validator = Validator.validate(form);
        final List<ValidationError> errors = validator.getErrors();

        assertEquals(1, errors.size());
        assertTrue(errors.get(0) instanceof DuplicateIdError);
    }

    @Test
    public void testInvalidId() {
        final Form form = ParserHelper.parseResourceForm("ex_invalidid");
        final Validator validator = Validator.validate(form);
        final List<ValidationError> errors = validator.getErrors();

        assertEquals(1, errors.size());
        assertTrue(errors.get(0) instanceof UnknownIdError);
    }

}
