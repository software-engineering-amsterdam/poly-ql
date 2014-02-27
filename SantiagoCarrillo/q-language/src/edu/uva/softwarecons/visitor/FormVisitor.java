package edu.uva.softwarecons.visitor;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.operation.Operation;
import edu.uva.softwarecons.model.question.Question;
import edu.uva.softwarecons.model.type.Type;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public class FormVisitor extends FormBaseVisitor{

    @Override
    public void visitForm(Form form) {
        System.out.println("Visiting form: "+form.getId());
        for(Question question: form.getQuestions()){
            question.accept(this);
        }
    }

    @Override
    public void visitQuestion(Question question) {
        System.out.println("Visiting question: "+question.getId());
    }

    @Override
    public void visitExpression(Expression expression) {
        System.out.println("Visiting expression");

    }

    @Override
    public void visitOperation(Operation operation) {
        System.out.println("Visiting operation");
    }

    @Override
    public void visitType(Type type) {
        System.out.println("Visiting type");
    }
}
