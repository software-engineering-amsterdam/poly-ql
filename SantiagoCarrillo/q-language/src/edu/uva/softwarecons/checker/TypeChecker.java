package edu.uva.softwarecons.checker;

import edu.uva.softwarecons.checker.error.*;
import edu.uva.softwarecons.checker.warning.DuplicatedQuestionLabelWarning;
import edu.uva.softwarecons.checker.warning.QuestionnaireWarning;
import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.IdExpression;
import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.IntegerType;
import edu.uva.softwarecons.model.type.NumericType;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.form.FormBaseVisitor;

import java.util.*;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/27/14
 */
public class TypeChecker extends FormBaseVisitor {

    private Map<String, Type> questionTypes = new HashMap<String, Type>();

    private Set<String> referencedQuestions = new HashSet<String>();

    private Map<String, BasicQuestion> questionsText = new HashMap<String, BasicQuestion>();

    private List<QuestionnaireError> errors = new ArrayList<QuestionnaireError>();

    private List<QuestionnaireWarning> warnings = new ArrayList<QuestionnaireWarning>();



    @Override
    public void visitForm(Form form) {
        for(Question question: form.getQuestions()){
            question.accept(this);
        }
    }

    @Override
    public void visitQuestion(BasicQuestion question) {
        validateDuplicatedQuestion(question);
        questionTypes.put(question.getId(), question.getType());
        verifyDuplicatedQuestionText(question);
    }



    @Override
    public void visitComputedQuestion(ComputedQuestion question) {
        validateDuplicatedQuestion(question);
        questionTypes.put(question.getId(), question.getType());
        question.getExpression().accept(this);
        verifyDuplicatedQuestionText(question);
    }

    @Override
    public void visitIfQuestion(IfQuestion question) {
        question.getExpression().accept(this);
        for(Question q: question.getQuestions()){
            q.accept(this);
            if(new BasicQuestion(null, null, null).equals(q))
                validateDuplicatedQuestion((BasicQuestion) q);
        }
        if(null != question.getElseQuestion()){
            for(Question q: question.getElseQuestion().getQuestions()){
                q.accept(this);
                if(new BasicQuestion(null, null, null).equals(q))
                    validateDuplicatedQuestion((BasicQuestion) q);
            }
        }
    }



    @Override
    public void visitIdExpression(IdExpression expression) {
        if(!questionTypes.containsKey(expression.getId()))
            errors.add(new CyclicDependencyError(expression.getId()));
        referencedQuestions.add(expression.getId());
    }

    private void validateDuplicatedQuestion(BasicQuestion question) {
        if(questionTypes.containsKey(question.getId()) && !questionTypes.get(question.getId()).equals(question.getType())){
            errors.add(new DuplicateQuestionError(question.getId()));
        }
    }

    private void verifyDuplicatedQuestionText(BasicQuestion question) {
        if(questionsText.containsKey(question.getText()))
            warnings.add(new DuplicatedQuestionLabelWarning(questionsText.get(question.getText()).getId(), question.getId()));
        else
            questionsText.put(question.getText(), question);
    }

    public void checkForm(Form form){
        form.accept(this);
        findUndefinedVariables();
        ExpressionTypeChecker expressionTypeChecker = new ExpressionTypeChecker(questionTypes);
        checkComputedQuestionExpressionsType(form, expressionTypeChecker);
        checkIfStatementExpressionTypes(form, expressionTypeChecker);
        errors.addAll(expressionTypeChecker.getErrors());
    }


    private void checkIfStatementExpressionTypes(Form form, ExpressionTypeChecker expressionTypeChecker) {
        IfQuestion ifQuestion = new IfQuestion(null, null, null);
        for(Question q: form.getQuestions()){
            if(ifQuestion.equals(q)){
                expressionTypeChecker.validateType("if ", ((IfQuestion) q).getExpression(), new BooleanType(false));
            }
        }
    }

    private void checkComputedQuestionExpressionsType(Form form, ExpressionTypeChecker expressionTypeChecker) {
        ComputedQuestion computedQuestion = new ComputedQuestion(null, null, null, null);
        for(Question q: form.getQuestions()){
            if(computedQuestion.equals(q)){
                ComputedQuestion question = (ComputedQuestion) q;
                if(question.getType() instanceof NumericType)
                    expressionTypeChecker.validateType(question.getId(), question.getExpression(), new IntegerType(0));
                else
                    errors.add(new InvalidTypeError(question.getId(), NumericType.class.getSimpleName(), question.getType().toString()));
            }
        }
    }

    private void findUndefinedVariables() {
        for(String questionKey: referencedQuestions){
            if(!questionTypes.containsKey(questionKey)){
                errors.add(new UndefinedReferenceError(questionKey));
            }
        }
    }

    public List<QuestionnaireError> getErrors() {
        return errors;
    }

    public List<QuestionnaireWarning> getWarnings() {
        return warnings;
    }
}