package edu.uva.softwarecons.test;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.DateType;
import edu.uva.softwarecons.model.type.DecimalType;
import edu.uva.softwarecons.model.type.IntegerType;
import edu.uva.softwarecons.model.type.MoneyType;
import edu.uva.softwarecons.model.type.StringType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Falconlabs
 * @author Santiago Carrillo
 * Date: 3/6/14
 */
public class FormElmentsTest
{

    @Test
    public void isFormIdProperlySetTest()
    {
        String formId = "testId";
        Form form = new Form( formId, null );
        assertTrue( form.getId().equals( formId ) );
    }

    @Test
    public void isFormQuestionSetProperlyTest()
    {
        List<Question> questionList = new ArrayList<Question>();
        Question question = new BasicQuestion( "", "", new IntegerType() );
        questionList.add( question );
        Form form = new Form( null, questionList );
        assertTrue( form.getQuestions().size() == questionList.size() );
        assertTrue( form.getQuestions().get( 0 ).equals( question ) );
    }

    @Test
    public void basicQuestionEqualsTest()
    {
        BasicQuestion question = new BasicQuestion( null, null, null );
        BasicQuestion question2 = new BasicQuestion( null, null, null );
        assertTrue( question.equals( question2 ) );
    }

    @Test
    public void computedQuestionEqualsTest()
    {
        ComputedQuestion question = new ComputedQuestion( null, null, null, null );
        ComputedQuestion question2 = new ComputedQuestion( null, null, null, null );
        assertTrue( question.equals( question2 ) );
    }

    @Test
    public void ifQuestionEqualsTest()
    {
        IfQuestion question = new IfQuestion( null, null, null, null );
        IfQuestion question2 = new IfQuestion( null, null, null, null );
        assertTrue( question.equals( question2 ) );
    }

    @Test
    public void numericTypeEqualsTest()
    {
        DecimalType decimalType = new DecimalType();
        IntegerType integerType = new IntegerType();
        MoneyType moneyType = new MoneyType();
        assertTrue( decimalType.equals( integerType ) );
        assertTrue( decimalType.equals( moneyType ) );
        assertTrue( integerType.equals( moneyType ) );
    }

    @Test
    public void stringTypeEqualsTest()
    {
        StringType stringType = new StringType();
        StringType stringType2 = new StringType();
        assertTrue( stringType.equals( stringType2 ) );
    }

    @Test
    public void booleanTypeEqualsTest()
    {
        BooleanType booleanType = new BooleanType();
        BooleanType booleanType2 = new BooleanType();
        assertTrue( booleanType.equals( booleanType2 ) );
    }

    @Test
    public void DateTypeEqualsTest()
    {
        DateType dateType = new DateType();
        DateType dateType2 = new DateType();
        assertTrue( dateType.equals( dateType2 ) );
    }
}
