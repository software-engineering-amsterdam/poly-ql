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
public interface IFormElementVisitor {

    void visit(Form form);

    void visit(Question question);

    void visit(Expression expression);

    void visit(Operation operation);

    void visit(Type type);
}
