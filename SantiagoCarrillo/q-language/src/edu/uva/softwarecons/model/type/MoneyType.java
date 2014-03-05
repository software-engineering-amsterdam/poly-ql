package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.IFormElementVisitor;

import java.math.BigDecimal;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class MoneyType extends NumericType{

    private final BigDecimal value;

    public MoneyType(BigDecimal value) {
        this.value = value;
    }

    @Override
    public BigDecimal getValue() {
        return value;
    }

    @Override
    public void accept(IFormElementVisitor visitor) {
        visitor.visitMoneyType(this);
    }

    @Override
    public String toString() {
        return "money";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof NumericType;
    }
}
