package edu.uva.softwarecons.visitor.type;

import edu.uva.softwarecons.model.type.*;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/5/14
 */
public interface ITypeElementVisitor {

    void visitBooleanType(BooleanType type);

    void visitDateType(DateType type);

    void visitDecimalType(DecimalType type);

    void visitIntegerType(IntegerType type);

    void visitMoneyType(MoneyType type);

    void visitStringType(StringType type);
}
