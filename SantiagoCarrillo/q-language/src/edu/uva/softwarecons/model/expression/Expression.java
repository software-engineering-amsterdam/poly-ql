package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.expression.IExpressionElement;
import edu.uva.softwarecons.visitor.form.IFormElement;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public interface Expression extends IExpressionElement {

    public abstract Type eval();

}
