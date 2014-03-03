package edu.uva.softwarecons.checker;

import edu.uva.softwarecons.checker.error.*;
import edu.uva.softwarecons.checker.warning.DuplicatedQuestionLabelWarning;
import edu.uva.softwarecons.checker.warning.QuestionnaireWarning;
import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.IdExpression;
import edu.uva.softwarecons.model.expression.ParenthesisExpression;
import edu.uva.softwarecons.model.expression.arithmetic.AddExpression;
import edu.uva.softwarecons.model.expression.arithmetic.DivExpression;
import edu.uva.softwarecons.model.expression.arithmetic.MulExpression;
import edu.uva.softwarecons.model.expression.arithmetic.SubExpression;
import edu.uva.softwarecons.model.expression.bool.AndExpression;
import edu.uva.softwarecons.model.expression.bool.NotExpression;
import edu.uva.softwarecons.model.expression.bool.OrExpression;
import edu.uva.softwarecons.model.expression.comparison.*;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.question.IfElseQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.NumericType;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.FormBaseVisitor;

import java.util.*;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/27/14
 */
public class TypeChecker extends FormBaseVisitor {

    public Map<String, Type> questionTypes = new HashMap<String, Type>();

    private List<ComputedQuestion> computedQuestions = new ArrayList<ComputedQuestion>();

    private List<IfQuestion> ifQuestions = new ArrayList<IfQuestion>();

    public Set<String> referencedQuestions = new HashSet<String>();

    public Map<String, Question> questionsText = new HashMap<String, Question>();

    public List<QuestionnaireError> errors = new ArrayList<QuestionnaireError>();

    public List<QuestionnaireWarning> warnings = new ArrayList<QuestionnaireWarning>();



    @Override
    public void visitForm(Form form) {
        for(Question question: form.questions){
            question.accept(this);
        }
    }

    @Override
    public void visitQuestion(Question question) {
        validateDuplicatedQuestion(question);
        questionTypes.put(question.id, question.type);
        verifyDuplicatedQuestionText(question);
    }



    @Override
    public void visitComputedQuestion(ComputedQuestion question) {
        validateDuplicatedQuestion(question);
        questionTypes.put(question.id, question.type);
        question.expression.accept(this);
        verifyDuplicatedQuestionText(question);
        computedQuestions.add(question);
    }

    @Override
    public void visitIfQuestion(IfQuestion question) {
        question.expression.accept(this);
        for(Question q: question.questions){
            q.accept(this);
            validateDuplicatedQuestion(q);
        }
        ifQuestions.add(question);
    }

    @Override
    public void visitIfElseQuestion(IfElseQuestion question) {
        question.expression.accept(this);
        for(Question q: question.questions){
            q.accept(this);
            validateDuplicatedQuestion(q);
        }
        for(Question q: question.elseQuestions){
            q.accept(this);
            validateDuplicatedQuestion(q);
        }
    }

    @Override
    public void visitAddExpression(AddExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitDivExpression(DivExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitMulExpression(MulExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitSubExpression(SubExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitAndExpression(AndExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitOrExpression(OrExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitEqualExpression(EqualExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitGreaterEqualExpression(GreaterEqualExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitGreaterExpression(GreaterExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitLessEqualExpression(LessEqualExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitLessExpression(LessExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitNotEqualExpression(NotEqualExpression expression) {
        expression.leftExpression.accept(this);
        expression.rightExpression.accept(this);
    }

    @Override
    public void visitNotExpression(NotExpression expression) {
        expression.expression.accept(this);
    }

    @Override
    public void visitParenthesisExpression(ParenthesisExpression expression) {
        expression.expression.accept(this);
    }

    @Override
    public void visitIdExpression(IdExpression expression) {
        if(!questionTypes.containsKey(expression.id))
            errors.add(new CyclicDependencyError(expression.id));
        referencedQuestions.add(expression.id);
    }

    private void validateDuplicatedQuestion(Question question) {
        if(questionTypes.containsKey(question.id) && !questionTypes.get(question.id).getClass().equals(question.type.getClass())){
            errors.add(new DuplicateQuestionError(question.id));
        }
    }

    private void verifyDuplicatedQuestionText(Question question) {
        if(questionsText.containsKey(question.text))
            warnings.add(new DuplicatedQuestionLabelWarning(questionsText.get(question.text).id, question.id));
        else
            questionsText.put(question.text, question);
    }

    public void checkForm(Form form){
        form.accept(this);
        for(String questionKey: referencedQuestions){
            if(!questionTypes.containsKey(questionKey)){
                errors.add(new UndefinedReferenceError(questionKey));
            }
        }
        ValueTypeChecker valueTypeChecker = new ValueTypeChecker(questionTypes);
        NumericType numericType = new NumericType();
        BooleanType booleanType = new BooleanType();
        for(ComputedQuestion question: computedQuestions){
            if(question.type instanceof NumericType)
                valueTypeChecker.validateType(question.id, question.expression, numericType);
            else
                errors.add(new InvalidTypeError(question.id, numericType, question.type));
        }
        for(IfQuestion ifQuestion: ifQuestions){
            valueTypeChecker.validateType("if ", ifQuestion.expression, booleanType);
        }
        errors.addAll(valueTypeChecker.errors);


    }

}
