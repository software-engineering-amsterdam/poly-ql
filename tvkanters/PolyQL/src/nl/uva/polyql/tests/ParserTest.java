package nl.uva.polyql.tests;

import static org.junit.Assert.*;
import nl.uva.polyql.ParserHelper;
import nl.uva.polyql.model.Form;
import nl.uva.polyql.model.IfStatement;
import nl.uva.polyql.model.Question;

import org.junit.Test;

public class ParserTest {

    @Test
    public void testIfStatement() {
        final Form form = ParserHelper.parseResourceForm("ifstatement");
        final Question question = form.getQuestion("num");
        final IfStatement ifStatement = (IfStatement) form.getRules().get(1);

        assertFalse(ifStatement.isSatisfied());

        question.setValueFromInput("10");

        assertTrue(ifStatement.isSatisfied());
    }

}
