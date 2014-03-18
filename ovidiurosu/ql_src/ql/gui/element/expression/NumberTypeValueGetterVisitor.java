package ql.gui.element.expression;

import java.math.BigDecimal;

import ql.ast.expression.value.DecimalValue;
import ql.ast.expression.value.IntegerValue;
import ql.ast.expression.value.NumberValue;
import ql.ast.type.DecimalType;
import ql.ast.type.IntegerType;
import ql.ast.visitor_elements.INumberTypeElementVisitor;

/**
 * @author orosu
 */
public class NumberTypeValueGetterVisitor implements INumberTypeElementVisitor<NumberValue>
{
    private final Number _value;

    public NumberTypeValueGetterVisitor(Number value)
    {
        this._value = value;
    }

    @Override
    public NumberValue visit(IntegerType integerType)
    {
        return new IntegerValue(this._value.intValue());
    }

    @Override
    public NumberValue visit(DecimalType decimalType)
    {
        return new DecimalValue(new BigDecimal(this._value.doubleValue()));
    }
}
