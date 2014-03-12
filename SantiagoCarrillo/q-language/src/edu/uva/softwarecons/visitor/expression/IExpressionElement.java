package edu.uva.softwarecons.visitor.expression;

import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.IQuestionnaireElement;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/5/14
 */
public interface IExpressionElement extends IQuestionnaireElement {

    Type accept(IExpressionElementVisitor visitor);
}
