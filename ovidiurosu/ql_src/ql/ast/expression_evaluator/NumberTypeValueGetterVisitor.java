package ql.ast.expression_evaluator;

import java.math.BigDecimal;

import ql.ast.expression_value.DecimalValue;
import ql.ast.expression_value.IntegerValue;
import ql.ast.expression_value.NumberValue;
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
    public IntegerValue visit(IntegerType integerType)
    {
        return new IntegerValue(this._value.intValue());
    }

    @Override
    public DecimalValue visit(DecimalType decimalType)
    {
        return new DecimalValue(new BigDecimal(this._value.doubleValue()));
    }
}
