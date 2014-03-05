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

    private Map<String, Type> questionTypes = new HashMap<String, Type>();

    private List<ComputedQuestion> computedQuestions = new ArrayList<ComputedQuestion>();

    private List<IfQuestion> ifQuestions = new ArrayList<IfQuestion>();

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
        computedQuestions.add(question);
    }

    @Override
    public void visitIfQuestion(IfQuestion question) {
        question.getExpression().accept(this);
        for(Question q: question.getQuestions()){
            q.accept(this);
            if(q instanceof BasicQuestion)
                validateDuplicatedQuestion((BasicQuestion) q);
        }
        ifQuestions.add(question);
    }

//    @Override
//    public void (IfElseQuestion question) {
//        question.expression.accept(this);
//        for(BasicQuestion q: question.questions){
//            q.accept(this);
//            validateDuplicatedQuestion(q);
//        }
//        for(BasicQuestion q: question.elseQuestions){
//            q.accept(this);
//            validateDuplicatedQuestion(q);
//        }
//    }



    @Override
    public void visitIdExpression(IdExpression expression) {
        if(!questionTypes.containsKey(expression.getId()))
            errors.add(new CyclicDependencyError(expression.getId()));
        referencedQuestions.add(expression.getId());
    }

    private void validateDuplicatedQuestion(BasicQuestion question) {
        if(questionTypes.containsKey(question.getId()) && !questionTypes.get(question.getId()).getClass().equals(question.getType().getClass())){
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
        for(String questionKey: referencedQuestions){
            if(!questionTypes.containsKey(questionKey)){
                errors.add(new UndefinedReferenceError(questionKey));
            }
        }

        //TODO validate question types on the visit method
        ExpressionTypeChecker expressionTypeChecker = new ExpressionTypeChecker(questionTypes);
        for(ComputedQuestion question: computedQuestions){
            if(question.getType() instanceof NumericType)
                expressionTypeChecker.validateType(question.getId(), question.getExpression(), NumericType.class);
            else
                errors.add(new InvalidTypeError(question.getId(), NumericType.class, question.getType().getClass()));
        }
        for(IfQuestion ifQuestion: ifQuestions){
            expressionTypeChecker.validateType("if ", ifQuestion.getExpression(), BooleanType.class);
        }
        errors.addAll(expressionTypeChecker.getErrors());


    }

}
