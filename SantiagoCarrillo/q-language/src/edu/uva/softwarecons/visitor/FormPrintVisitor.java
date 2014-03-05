package edu.uva.softwarecons.visitor;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.IdExpression;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.question.IfElseQuestion;
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
        System.out.println("form: " + form.id);
        for(Question question: form.questions){
            question.accept(this);
        }
    }

    @Override
    public void visitQuestion(Question question) {
        System.out.println(question);
    }


    @Override
    public void visitComputedQuestion(ComputedQuestion question) {
        System.out.println("computedQuestion( " + question.id + " ) ");
        question.expression.accept(this);
    }

    @Override
    public void visitIfQuestion(IfQuestion question) {
        System.out.println("ifQuestions {");
        for(Question q: question.questions){
            q.accept(this);
        }
        System.out.println("}");
    }

    @Override
    public void visitIfElseQuestion(IfElseQuestion question) {
        System.out.println("IfElseQuestions {");
        System.out.print("if ( ");
        question.expression.accept(this);
        System.out.println(" ){");

        for(Question q: question.questions){
            q.accept(this);
        }
        System.out.println("}");
        System.out.println("else {");
        for(Question q: question.elseQuestions){
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
        System.out.print(expression.id);
    }


}
