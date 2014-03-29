package edu.uva.softwarecons.test;

import edu.uva.softwarecons.checker.TypeChecker;
import edu.uva.softwarecons.checker.error.CyclicDependencyError;
import edu.uva.softwarecons.checker.error.DuplicateQuestionError;
import edu.uva.softwarecons.checker.error.InvalidTypeError;
import edu.uva.softwarecons.checker.error.QuestionnaireError;
import edu.uva.softwarecons.checker.error.UndefinedReferenceError;
import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.BinaryExpression;
import edu.uva.softwarecons.model.expression.comparison.EqualExpression;
import edu.uva.softwarecons.model.expression.comparison.GreaterEqualExpression;
import edu.uva.softwarecons.model.expression.comparison.GreaterExpression;
import edu.uva.softwarecons.model.expression.comparison.LessEqualExpression;
import edu.uva.softwarecons.model.expression.comparison.LessExpression;
import edu.uva.softwarecons.model.expression.comparison.NotEqualExpression;
import edu.uva.softwarecons.model.expression.literal.IdExpression;
import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.DateType;
import edu.uva.softwarecons.model.type.DecimalType;
import edu.uva.softwarecons.model.type.IntegerType;
import edu.uva.softwarecons.model.type.MoneyType;
import edu.uva.softwarecons.model.type.StringType;
import edu.uva.softwarecons.model.type.Type;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * @author: Santiago Carrillo
 * Date: 3/19/14
 */
public class TypeCheckerTest
{


    private boolean containsErrorType( TypeChecker typeChecker, QuestionnaireError errorType )
    {
        boolean errorFound = false;
        for ( QuestionnaireError error : typeChecker.getErrors() )
        {
            if ( error.equals( errorType ) )
            {
                errorFound = true;
            }
        }
        return errorFound;
    }

    @Test
    public void undefinedQuestionReferenceErrorFoundTest()
    {
        IdExpression idExpression = new IdExpression( "none existing" );
        List<Question> questions = new ArrayList<Question>();
        questions.add( new IfQuestion( idExpression, null, null, null ) );
        Form form = new Form( "test", questions );
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.checkForm( form );
        assertTrue( containsErrorType( typeChecker, new UndefinedReferenceError( null ) ) );
    }


    @Test
    public void undefinedNestedIfQuestionReferenceErrorFoundTest()
    {
        IdExpression idExpression = new IdExpression( "question1" );
        IdExpression idExpression2 = new IdExpression( "none existing" );
        List<Question> questions = new ArrayList<Question>();
        questions.add( new BasicQuestion( "question1", null, new BooleanType() ) );
        List<Question> ifQuestions = new ArrayList<Question>();
        ifQuestions.add( new IfQuestion( idExpression2, null, null, null ) );
        questions.add( new IfQuestion( idExpression, ifQuestions, null, null ) );
        Form form = new Form( "test", questions );
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.checkForm( form );
        assertTrue( containsErrorType( typeChecker, new UndefinedReferenceError( null ) ) );
    }

    @Test
    public void duplicatedQuestionWithDifferentTypeErrorFoundTest()
    {
        String duplicateId = "duplicateId";
        List<Question> questions = new ArrayList<Question>();
        questions.add( new BasicQuestion( duplicateId, null, new BooleanType() ) );
        questions.add( new BasicQuestion( duplicateId, null, new IntegerType() ) );
        Form form = new Form( "test", questions );
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.checkForm( form );
        assertTrue( containsErrorType( typeChecker, new DuplicateQuestionError( null ) ) );
    }

    @Test
    public void invalidConditionIdExpressionTypeErrorFoundTest()
    {
        String questionId = "questionId";
        IdExpression idExpression = new IdExpression( questionId );
        List<Question> questions = new ArrayList<Question>();
        questions.add( new BasicQuestion( questionId, null, new IntegerType() ) );
        questions.add( new IfQuestion( idExpression, null, null, null ) );
        Form form = new Form( "test", questions );
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.checkForm( form );
        assertTrue( containsErrorType( typeChecker, new InvalidTypeError( null, "" ) ) );
    }

    @Test
    public void cyclicDependencyErrorFoundTest()
    {
        IdExpression idExpression = new IdExpression( "questionId" );
        List<Question> questions = new ArrayList<Question>();
        questions.add( new IfQuestion( idExpression, null, null, null ) );
        Form form = new Form( "test", questions );
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.checkForm( form );
        assertTrue( containsErrorType( typeChecker, new CyclicDependencyError( null ) ) );
    }

    @Test
    public void validTypeEqualComparisonTest()
    {
        assertTrue( validateComparisonForType( new BooleanType(), new EqualExpression( null, null ) ) );
        assertTrue( validateComparisonForType( new DateType(), new EqualExpression( null, null ) ) );
        assertTrue( validateComparisonForType( new DecimalType(), new EqualExpression( null, null ) ) );
        assertTrue( validateComparisonForType( new IntegerType(), new EqualExpression( null, null ) ) );
        assertTrue( validateComparisonForType( new MoneyType(), new EqualExpression( null, null ) ) );
        assertTrue( validateComparisonForType( new StringType(), new EqualExpression( null, null ) ) );
    }

    @Test
    public void validTypeNotEqualComparisonTest()
    {
        assertTrue( validateComparisonForType( new BooleanType(), new NotEqualExpression( null, null ) ) );
        assertTrue( validateComparisonForType( new DateType(), new NotEqualExpression( null, null ) ) );
        assertTrue( validateComparisonForType( new DecimalType(), new NotEqualExpression( null, null ) ) );
        assertTrue( validateComparisonForType( new IntegerType(), new NotEqualExpression( null, null ) ) );
        assertTrue( validateComparisonForType( new MoneyType(), new NotEqualExpression( null, null ) ) );
        assertTrue( validateComparisonForType( new StringType(), new NotEqualExpression( null, null ) ) );
    }


    @Test
    public void validComparisonExpressionsTypesTest()
    {
        List<BinaryExpression> comparisonExpressions = new ArrayList<BinaryExpression>();
        comparisonExpressions.add( new GreaterExpression( null, null ) );
        comparisonExpressions.add( new GreaterEqualExpression( null, null ) );
        comparisonExpressions.add( new LessExpression( null, null ) );
        comparisonExpressions.add( new LessEqualExpression( null, null ) );
        for ( BinaryExpression expression : comparisonExpressions )
        {
            validTypeGreaterComparisonExpressionTest( expression );
            invalidTypeGreaterComparisonTest( expression );
        }

    }

    private void validTypeGreaterComparisonExpressionTest( BinaryExpression expression )
    {
        assertTrue( validateComparisonForType( new DateType(), expression ) );
        assertTrue( validateComparisonForType( new DecimalType(), expression ) );
        assertTrue( validateComparisonForType( new IntegerType(), expression ) );
        assertTrue( validateComparisonForType( new MoneyType(), expression ) );
    }

    private void invalidTypeGreaterComparisonTest( BinaryExpression expression )
    {
        assertFalse( validateComparisonForType( new BooleanType(), expression ) );
        assertFalse( validateComparisonForType( new StringType(), expression ) );
    }

    private boolean validateComparisonForType( Type type, BinaryExpression expression )
    {
        String exp1Id = "exp1";
        IdExpression idExpression = new IdExpression( exp1Id );
        String exp2Id = "exp2";
        IdExpression idExpression2 = new IdExpression( exp2Id );
        List<Question> questions = new ArrayList<Question>();
        questions.add( new BasicQuestion( exp1Id, null, type ) );
        questions.add( new BasicQuestion( exp2Id, null, type ) );
        questions.add( new IfQuestion( expression.getNewInstance( idExpression, idExpression2 ), null, null, null ) );
        Form form = new Form( "test", questions );
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.checkForm( form );
        return typeChecker.getErrors().isEmpty();
    }

}
