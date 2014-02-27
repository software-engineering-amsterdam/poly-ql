package edu.uva.softwarecons.visitor;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.IdExpression;
import edu.uva.softwarecons.model.operation.Operation;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.question.IfElseQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.Type;

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
    public void visitQuestion(Question question) {
        System.out.println("question( " + question.id + " ) ");
    }


    @Override
    public void visitComputedQuestion(ComputedQuestion question) {
        System.out.println("computedQuestion( " + question.id + " ) ");
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
    public void visitOperation(Operation operation) {
        System.out.print("Visiting operation");
    }

    @Override
    public void visitType(Type type) {
        System.out.print("Visiting type");
    }

    @Override
    public void visitIdExpression(IdExpression expression) {
        System.out.print(expression.id);
    }
}
