package edu.uva.softwarecons.visitor.form;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.IdExpression;
import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.BooleanType;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class FormPrintVisitor extends FormBaseVisitor{


    @Override
    public void visitForm(Form form) {
        System.out.println("form: " + form.getId());
        for(Question question: form.getQuestions()){
            question.accept(this);
        }
    }

    @Override
    public void visitQuestion(BasicQuestion question) {
        System.out.println(question);
    }


    @Override
    public void visitComputedQuestion(ComputedQuestion question) {
        System.out.println("computedQuestion: ");
        question.getExpression().accept(this);
    }

    @Override
    public void visitIfQuestion(IfQuestion question) {
        System.out.println("ifQuestions {");
        for(Question q: question.getQuestions()){
            q.accept(this);
        }
        System.out.println("}");
    }


    @Override
    public void visitBooleanType(BooleanType type) {
        System.out.print(" boolean ");
    }

    @Override
    public void visitIdExpression(IdExpression expression) {
        System.out.print(expression.getId());
    }


}
