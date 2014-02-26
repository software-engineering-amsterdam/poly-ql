package edu.uva.softwarecons.model.expression;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public class VariableExpression implements Expression{


    String id;

    public VariableExpression(String id) {
        this.id = id;
    }
}
