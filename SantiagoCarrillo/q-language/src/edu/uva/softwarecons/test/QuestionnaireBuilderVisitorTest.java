package edu.uva.softwarecons.test;

import edu.uva.softwarecons.grammar.QuestionnaireBuilderVisitor;
import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.BinaryExpression;
import edu.uva.softwarecons.model.expression.literal.IdExpression;
import edu.uva.softwarecons.model.expression.logical.AndExpression;
import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.ElseQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.DateType;
import edu.uva.softwarecons.model.type.DecimalType;
import edu.uva.softwarecons.model.type.IntegerType;
import edu.uva.softwarecons.model.type.MoneyType;
import edu.uva.softwarecons.model.type.StringType;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.util.FileReader;
import edu.uva.softwarecons.util.ParserBuilder;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.Assert.assertTrue;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/7/14
 */
public class QuestionnaireBuilderVisitorTest
{


    private ParserBuilder parserBuilder;

    private Form form;

    private HashMap<String, BasicQuestion> questions;

    private IfQuestion ifQuestion;

    @Before
    public void setUp()
    {
        parserBuilder = new ParserBuilder();
        try
        {
            ParseTree tree =
                parserBuilder.buildParseTree( FileReader.getFileContent( "questionnaire_builder_test.txt", "res" ) );
            QuestionnaireBuilderVisitor questionnaireBuilderVisitor = new QuestionnaireBuilderVisitor();
            form = (Form) questionnaireBuilderVisitor.visit( tree );
            questions = new HashMap<String, BasicQuestion>();
            for ( Question q : form.getQuestions() )
            {
                if ( new BasicQuestion( null, null, null ).equals( q ) )
                {
                    BasicQuestion basicQuestion = (BasicQuestion) q;
                    questions.put( basicQuestion.getId(), basicQuestion );
                }
                else if ( new IfQuestion( null, null, null, null ).equals( q ) )
                {
                    ifQuestion = (IfQuestion) q;
                    for ( Question question : ifQuestion.getQuestions() )
                    {
                        BasicQuestion basicQuestion1 = (BasicQuestion) question;
                        questions.put( basicQuestion1.getId(), basicQuestion1 );
                    }
                    ElseQuestion elseQuestion = ifQuestion.getElseQuestion();
                    for ( Question question : elseQuestion.getQuestions() )
                    {
                        BasicQuestion basicQuestion1 = (BasicQuestion) question;
                        questions.put( basicQuestion1.getId(), basicQuestion1 );
                    }
                }

            }
        }
        catch ( IOException e )
        {
            assert false : "Error reading the input file for the QuestionnaireBuilderTest";
        }
    }

    @Test
    public void formIdTest()
    {
        assertTrue( "TestFormId".equals( form.getId() ) );
    }

    @Test
    public void booleanQuestionTest()
    {
        BasicQuestion question = questions.get( "booleanQuestion" );
        validateQuestionInfo( question, "booleanQuestion", "\"booleanQuestion label\"", new BooleanType() );
    }

    @Test
    public void dateQuestionTest()
    {
        BasicQuestion question = questions.get( "dateQuestion" );
        validateQuestionInfo( question, "dateQuestion", "\"dateQuestion label\"", new DateType() );
    }

    @Test
    public void decimalQuestionTest()
    {
        BasicQuestion question = questions.get( "decimalQuestion" );
        validateQuestionInfo( question, "decimalQuestion", "\"decimalQuestion label\"", new DecimalType() );
    }

    @Test
    public void integerQuestionTest()
    {
        BasicQuestion question = questions.get( "integerQuestion" );
        validateQuestionInfo( question, "integerQuestion", "\"integerQuestion label\"", new IntegerType() );
    }

    @Test
    public void moneyQuestionTest()
    {
        BasicQuestion question = questions.get( "moneyQuestion" );
        validateQuestionInfo( question, "moneyQuestion", "\"moneyQuestion label\"", new MoneyType() );
    }

    @Test
    public void stringQuestionTest()
    {
        BasicQuestion question = questions.get( "stringQuestion" );
        validateQuestionInfo( question, "stringQuestion", "\"stringQuestion label\"", new StringType() );
    }

    @Test
    public void ifQuestionTest()
    {
        BasicQuestion question = questions.get( "ifQuestion" );
        validateQuestionInfo( question, "ifQuestion", "\"ifQuestion label\"", new StringType() );
    }

    @Test
    public void elseQuestionTest()
    {
        BasicQuestion question = questions.get( "elseQuestion" );
        validateQuestionInfo( question, "elseQuestion", "\"elseQuestion label\"", new StringType() );
    }

    @Test
    public void ifExpressionTest()
    {
        assertTrue( ifQuestion.getExpression().equals( new AndExpression( null, null ) ) );
        BinaryExpression expression = ( (BinaryExpression) ifQuestion.getExpression() );
        assertTrue( expression.getLeftExpression().equals( new IdExpression( null ) ) );
        assertTrue( expression.getRightExpression().equals( new IdExpression( null ) ) );
        assertTrue( ifQuestion.getConditionText().equals( "booleanQuestion&&booleanQuestion" ) );

    }

    private void validateQuestionInfo( BasicQuestion question, String expectedId, String expectedText,
                                       Type expectedType )
    {
        assertTrue( expectedId.equals( question.getId() ) );
        assertTrue( expectedText.equals( question.getText() ) );
        assertTrue( expectedType.equals( question.getType() ) );
    }


}
