package ql.ast.expression_evaluator;

import java.math.BigDecimal;

import ql.ast.expression_value.BooleanValue;
import ql.ast.expression_value.DecimalValue;
import ql.ast.expression_value.IValue;
import ql.ast.expression_value.IntegerValue;
import ql.ast.expression_value.NullValue;
import ql.ast.expression_value.StringValue;
import ql.ast.type.BooleanType;
import ql.ast.type.DateType;
import ql.ast.type.DecimalType;
import ql.ast.type.EnumType;
import ql.ast.type.IntegerType;
import ql.ast.type.NullType;
import ql.ast.type.RangeType;
import ql.ast.type.StringType;
import ql.ast.visitor_elements.ITypeElementVisitor;

/**
 * Based on Type and a String value, get an IValue
 * @author orosu
 */
public class TextValueGetterVisitor implements ITypeElementVisitor<IValue>
{
    private final String _text;

    public TextValueGetterVisitor(String text)
    {
        this._text = text;
    }

    @Override
    public BooleanValue visit(BooleanType booleanType)
    {
        return new BooleanValue(this._text.equals("true"));
    }

    @Override
    public IValue visit(IntegerType integerType)
    {
        if (this._text.equals("")) {
            return new NullValue();
        }

        IValue value;
        try {
            value = new IntegerValue(Integer.parseInt(this._text));
        } catch(Exception exception) {
            value = new NullValue();
        }
        return value;
    }

    @Override
    public IValue visit(DecimalType decimalType)
    {
        if (this._text.equals("")) {
            return new NullValue();
        }

        IValue value;
        try {
            value = new DecimalValue(new BigDecimal(this._text));
        } catch(Exception exception) {
            value = new NullValue();
        }
        return value;
    }

    @Override
    public StringValue visit(StringType stringType)
    {
        return new StringValue(this._text);
    }

    @Override
    public IValue visit(NullType nullType)
    {
        return new NullValue();
    }

    @Override
    public IValue visit(DateType dateType)
    {
        assert false: "Execution should never reach this!";
        return null;
    }

    @Override
    public IValue visit(EnumType enumType)
    {
        assert false: "Execution should never reach this!";
        return null;
    }

    @Override
    public IValue visit(RangeType rangeType)
    {
        assert false: "Execution should never reach this!";
        return null;
    }
}
