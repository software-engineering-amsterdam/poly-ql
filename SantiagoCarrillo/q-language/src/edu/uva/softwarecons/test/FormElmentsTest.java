package edu.uva.softwarecons.test;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/6/14
 */
public class FormElmentsTest {

    @Test
    public void isFormIdProperlySetTest(){
        String formId = "testId";
        Form form = new Form(formId, null);
        assertTrue(form.getId().equals(formId));
    }

    @Test
    public void isFormQuestionSetProperlyTest(){
        List<Question> questionList = new ArrayList<Question>();
        Question question = new BasicQuestion("", "", new IntegerType(0));
        questionList.add(question);
        Form form = new Form(null, questionList);
        assertTrue(form.getQuestions().size() == questionList.size());
        assertTrue(form.getQuestions().get(0).equals(question));
    }

    @Test
    public void basicQuestionEqualsTest(){
        BasicQuestion question = new BasicQuestion(null, null, null);
        BasicQuestion question2 = new BasicQuestion(null, null, null);
        assertTrue(question.equals(question2));
    }

    @Test
    public void computedQuestionEqualsTest(){
        ComputedQuestion question = new ComputedQuestion(null, null, null, null);
        ComputedQuestion question2 = new ComputedQuestion(null, null, null, null);
        assertTrue(question.equals(question2));
    }

    @Test
    public void ifQuestionEqualsTest(){
        IfQuestion question = new IfQuestion(null, null, null);
        IfQuestion question2 = new IfQuestion(null, null, null);
        assertTrue(question.equals(question2));
    }

    @Test
    public void numericTypeEqualsTest(){
        DecimalType decimalType = new DecimalType(0);
        IntegerType integerType = new IntegerType(0);
        MoneyType moneyType = new MoneyType(new BigDecimal(0));
        assertTrue(decimalType.equals(integerType));
        assertTrue(decimalType.equals(moneyType));
        assertTrue(integerType.equals(moneyType));
    }

    @Test
    public void stringTypeEqualsTest(){
        StringType stringType = new StringType(null);
        StringType stringType2 = new StringType(null);
        assertTrue(stringType.equals(stringType2));
    }

    @Test
    public void booleanTypeEqualsTest(){
        BooleanType booleanType = new BooleanType(false);
        BooleanType booleanType2 = new BooleanType(false);
        assertTrue(booleanType.equals(booleanType2));
    }

    @Test
    public void DateTypeEqualsTest(){
        DateType dateType = new DateType(null);
        DateType dateType2 = new DateType(null);
        assertTrue(dateType.equals(dateType2));
    }
}
