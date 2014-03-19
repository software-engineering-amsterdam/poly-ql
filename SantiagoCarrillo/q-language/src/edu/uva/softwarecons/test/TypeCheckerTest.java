package edu.uva.softwarecons.test;

import com.sun.source.tree.AssertTree;
import edu.uva.softwarecons.checker.TypeChecker;
import edu.uva.softwarecons.checker.error.DuplicateQuestionError;
import edu.uva.softwarecons.checker.error.InvalidTypeError;
import edu.uva.softwarecons.checker.error.QuestionnaireError;
import edu.uva.softwarecons.checker.error.UndefinedReferenceError;
import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.literal.IdExpression;
import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.IntegerType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * @author: Santiago Carrillo
 * Date: 3/19/14
 */
public class TypeCheckerTest
{
    @Test
    public void undefinedQuestionReferenceErrorFoundTest(){
        TypeChecker typeChecker = new TypeChecker();
        IdExpression idExpression = new IdExpression( "none existing" );
        List<Question> questions = new ArrayList<Question>(  );
        questions.add( new IfQuestion(idExpression, null, null, null  ) );
        Form form = new Form("test", questions);
        typeChecker.checkForm( form );
        boolean errorFound = false;
        for(QuestionnaireError error: typeChecker.getErrors()){
            if(error.equals( new UndefinedReferenceError( null ) ))
                errorFound = true;
        }
        assertTrue(errorFound);
    }

    @Test
    public void duplicatedQuestionWithDifferentTypeErrorFoundTest(){
        TypeChecker typeChecker = new TypeChecker();
        String duplicateId = "duplicateId";
        List<Question> questions = new ArrayList<Question>(  );
        questions.add( new BasicQuestion(duplicateId, null, new BooleanType() ) );
        questions.add( new BasicQuestion(duplicateId, null, new IntegerType() ) );
        Form form = new Form("test", questions);
        typeChecker.checkForm( form );
        assertTrue( typeChecker.getErrors().get( 0 ).equals( new DuplicateQuestionError( null ) ) );
    }

    @Test
    public void invalidConditionIdExpressionTypeErrorFoundTest(){
        TypeChecker typeChecker = new TypeChecker();
        String questionId = "questionId";
        IdExpression idExpression = new IdExpression( questionId );
        List<Question> questions = new ArrayList<Question>(  );
        questions.add( new BasicQuestion(questionId, null, new IntegerType() ) );
        questions.add( new IfQuestion(idExpression, null, null, null  ) );
        Form form = new Form("test", questions);
        typeChecker.checkForm( form );
        assertTrue( typeChecker.getErrors().get( 0 ).equals( new InvalidTypeError( null, null ) ) );
    }

    @Test
    public void cyclicDependencyErrorFoundTest(){
        TypeChecker typeChecker = new TypeChecker();
        String questionId = "questionId";
        IdExpression idExpression = new IdExpression( questionId );
        List<Question> questions = new ArrayList<Question>(  );
        questions.add( new IfQuestion(idExpression, null, null, null  ) );
        questions.add( new BasicQuestion(questionId, null, new IntegerType() ) );
        Form form = new Form("test", questions);
        typeChecker.checkForm( form );
        assertTrue( typeChecker.getErrors().get( 0 ).equals( new InvalidTypeError( null, null ) ) );
    }
}
