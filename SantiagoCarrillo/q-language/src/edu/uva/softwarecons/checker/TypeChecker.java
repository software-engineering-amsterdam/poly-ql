package edu.uva.softwarecons.checker;

import edu.uva.softwarecons.checker.error.CyclicDependencyError;
import edu.uva.softwarecons.checker.error.DuplicateQuestionError;
import edu.uva.softwarecons.checker.error.InvalidComputedQuestionExpressionType;
import edu.uva.softwarecons.checker.error.InvalidComputedQuestionType;
import edu.uva.softwarecons.checker.error.QuestionnaireError;
import edu.uva.softwarecons.checker.error.UndefinedReferenceError;
import edu.uva.softwarecons.checker.warning.DuplicatedQuestionLabelWarning;
import edu.uva.softwarecons.checker.warning.QuestionnaireWarning;
import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.literal.IdExpression;
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
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.form.FormBaseVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/27/14
 */
public class TypeChecker
    extends FormBaseVisitor
{

    private Map<String, Type> questionTypes = new HashMap<String, Type>();

    private Set<String> referencedQuestions = new HashSet<String>();

    private Map<String, BasicQuestion> questionsText = new HashMap<String, BasicQuestion>();

    private List<QuestionnaireError> errors = new ArrayList<QuestionnaireError>();

    private List<QuestionnaireWarning> warnings = new ArrayList<QuestionnaireWarning>();

    private final ExpressionTypeChecker expressionTypeChecker = new ExpressionTypeChecker();


    @Override
    public void visitForm( Form form )
    {
        for ( Question question : form.getQuestions() )
        {
            question.accept( this );
        }
    }

    @Override
    public void visitQuestion( BasicQuestion question )
    {
        validateDuplicatedQuestion( question );
        questionTypes.put( question.getId(), question.getType() );
        verifyIfQuestionTextIsDuplicated( question );
    }


    @Override
    public void visitComputedQuestion( ComputedQuestion question )
    {
        validateDuplicatedQuestion( question );
        questionTypes.put( question.getId(), question.getType() );
        validateComputedQuestionTypes( question );
        verifyIfQuestionTextIsDuplicated( question );
    }

    private void validateComputedQuestionTypes( ComputedQuestion question )
    {
        Type type = question.getExpression().accept( this );
        if ( !type.equals( new IntegerType() ) )
        {
            errors.add( new InvalidComputedQuestionExpressionType( question.getId() ) );
        }
        if ( !question.getType().equals( new IntegerType() ) )
        {
            errors.add( new InvalidComputedQuestionType( question.getId() ) );

        }
    }

    @Override
    public void visitIfQuestion( IfQuestion question )
    {
        question.getExpression().accept( this );
        expressionTypeChecker.validateType( question.getConditionText(), question.getExpression(), questionTypes,
                                            getBooleanExpressionInvalidTypesList() );
        if ( null != question.getQuestions() )
        {
            for ( Question q : question.getQuestions() )
            {
                q.accept( this );
            }
        }
        if ( null != question.getElseQuestion() )
        {
            for ( Question q : question.getElseQuestion().getQuestions() )
            {
                q.accept( this );
            }
        }
    }


    @Override
    public Type visitIdExpression( IdExpression expression )
    {
        if ( !questionTypes.containsKey( expression.getId() ) )
        {
            errors.add( new CyclicDependencyError( expression.getId() ) );
        }
        referencedQuestions.add( expression.getId() );
        return questionTypes.get( expression.getId() );
    }


    private void validateDuplicatedQuestion( BasicQuestion question )
    {
        if ( questionTypes.containsKey( question.getId() ) && !questionTypes.get( question.getId() ).equals(
            question.getType() ) )
        {
            errors.add( new DuplicateQuestionError( question.getId() ) );
        }
    }

    private void verifyIfQuestionTextIsDuplicated( BasicQuestion question )
    {
        if ( questionsText.containsKey( question.getText() ) )
        {
            warnings.add( new DuplicatedQuestionLabelWarning( questionsText.get( question.getText() ).getId(),
                                                              question.getId() ) );
        }
        else
        {
            questionsText.put( question.getText(), question );
        }
    }

    public void checkForm( Form form )
    {
        form.accept( this );
        findUndefinedVariables();
        errors.addAll( expressionTypeChecker.getErrors() );
    }


    private void findUndefinedVariables()
    {
        for ( String questionKey : referencedQuestions )
        {
            if ( !questionTypes.containsKey( questionKey ) )
            {
                errors.add( new UndefinedReferenceError( questionKey ) );
            }
        }
    }

    public List<QuestionnaireError> getErrors()
    {
        return errors;
    }

    public List<QuestionnaireWarning> getWarnings()
    {
        return warnings;
    }


    public static List<Type> getSingleInvalidTypeList( Type type )
    {
        List<Type> expectedTypes = new ArrayList<Type>();
        expectedTypes.add( type );
        return expectedTypes;
    }

    public static List<Type> getComparableExpressionInvalidTypesList()
    {
        List<Type> expectedTypes = getSingleInvalidTypeList( new BooleanType() );
        expectedTypes.add( new StringType() );
        return expectedTypes;
    }

    public static List<Type> getArithmeticExpressionInvalidTypesList()
    {
        List<Type> expectedTypes = getSingleInvalidTypeList( new StringType() );
        expectedTypes.add( new BooleanType() );
        expectedTypes.add( new DateType() );
        return expectedTypes;
    }

    public static List<Type> getBooleanExpressionInvalidTypesList()
    {
        List<Type> expectedTypes = getSingleInvalidTypeList( new StringType() );
        expectedTypes.add( new DateType() );
        expectedTypes.add( new DecimalType() );
        expectedTypes.add( new IntegerType() );
        expectedTypes.add( new MoneyType() );
        return expectedTypes;
    }


}
