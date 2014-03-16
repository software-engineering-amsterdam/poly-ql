package edu.uva.softwarecons.evaluator;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.question.*;
import edu.uva.softwarecons.ui.QuestionHBox;
import edu.uva.softwarecons.visitor.form.IFormElementVisitor;

import java.util.HashMap;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/16/14
 */
public class QuestionEvalVisitor implements IFormElementVisitor {

    private boolean displayQuestion;

    private HashMap<String, QuestionHBox> questions = new HashMap<String, QuestionHBox>();

    private final ExpressionEvaluator expressionEvaluator;

    public QuestionEvalVisitor(boolean displayQuestion, HashMap<String, QuestionHBox> questions, ExpressionEvaluator expressionEvaluator) {
        this.displayQuestion = displayQuestion;
        this.questions = questions;
        this.expressionEvaluator = expressionEvaluator;
    }

    @Override
    public void visitForm(Form form) {
    }

    @Override
    public void visitComputedQuestion(ComputedQuestion question) {
        questions.get(question.getId()).setVisible(displayQuestion);
    }

    @Override
    public void visitQuestion(BasicQuestion question) {
        questions.get(question.getId()).setVisible(displayQuestion);
    }

    @Override
    public void visitIfQuestion(IfQuestion question) {
        boolean display = Boolean.valueOf(question.getExpression().accept(expressionEvaluator).getValue());
        for (Question q : question.getQuestions()) {
            q.accept(new QuestionEvalVisitor(displayQuestion && display,
                    questions, expressionEvaluator));
        }
        if (null != question.getElseQuestion())
            question.getElseQuestion().accept(new QuestionEvalVisitor(!(displayQuestion && display),
                    questions, expressionEvaluator));
    }

    @Override
    public void visitElseQuestion(ElseQuestion question) {
        for (Question q : question.getQuestions()) {
            q.accept(this);
        }

    }
}
