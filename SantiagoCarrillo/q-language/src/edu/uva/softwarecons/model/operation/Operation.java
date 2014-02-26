package edu.uva.softwarecons.model.operation;

import edu.uva.softwarecons.model.type.Type;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public abstract class Operation {

    public abstract Type eval(Type leftOperand, Type rightOperand, Operator operator);

}
