package edu.uva.softwarecons.model.type;

import edu.uva.softwarecons.visitor.form.IFormElementVisitor;
import edu.uva.softwarecons.visitor.type.ITypeElementVisitor;

import java.math.BigDecimal;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class MoneyType extends NumericType{


    @Override
    public String toString() {
        return "money";
    }

    @Override
    public void accept(ITypeElementVisitor visitor) {
        visitor.visitMoneyType(this);
    }
}
