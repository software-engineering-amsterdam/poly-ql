package edu.uva.softwarecons.model.expression;

import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.IFormElement;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public interface Expression extends IFormElement {

    public abstract Type eval();

}
