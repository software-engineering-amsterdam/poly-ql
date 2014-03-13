package edu.uva.softwarecons.model.expression.literal;

import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.type.StringType;
import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.expression.IExpressionElementVisitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/12/14
 */
public class StringExpression implements Expression{

    private String value;

    public StringExpression(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Expression eval() {
        return new StringExpression(value);
    }

    @Override
    public Type accept(IExpressionElementVisitor visitor) {
        return new StringType();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof StringExpression;
    }

}
