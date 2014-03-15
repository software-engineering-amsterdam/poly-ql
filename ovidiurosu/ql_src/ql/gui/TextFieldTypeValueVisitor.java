package ql.gui;

import java.math.BigDecimal;

import ql.ast.expression.value.BooleanValue;
import ql.ast.expression.value.DecimalValue;
import ql.ast.expression.value.IValue;
import ql.ast.expression.value.IntegerValue;
import ql.ast.expression.value.NullValue;
import ql.ast.expression.value.StringValue;
import ql.ast.type.BooleanType;
import ql.ast.type.DateType;
import ql.ast.type.DecimalType;
import ql.ast.type.EnumType;
import ql.ast.type.IntegerType;
import ql.ast.type.NullType;
import ql.ast.type.RangeType;
import ql.ast.type.StringType;
import ql.ast.visitor_elements.ITypeElementVisitor;
import ql.gui.component.input_field.TextFieldInput;

/**
 * @author orosu
 */
public class TextFieldTypeValueVisitor implements ITypeElementVisitor<IValue>
{
    private final TextFieldInput _textFieldUI;

    public TextFieldTypeValueVisitor(TextFieldInput textFieldUI)
    {
        this._textFieldUI = textFieldUI;
    }

    @Override
    public BooleanValue visit(BooleanType booleanType)
    {
        return new BooleanValue(this._textFieldUI.getText().equals("true"));
    }

    @Override
    public IValue visit(IntegerType integerType)
    {
        if (this._textFieldUI.getText().equals("")) {
            return new NullValue();
        }
        return new IntegerValue(Integer.parseInt(this._textFieldUI.getText()));
    }

    @Override
    public IValue visit(DecimalType decimalType)
    {
        if (this._textFieldUI.getText().equals("")) {
            return new NullValue();
        }
        return new DecimalValue(new BigDecimal(this._textFieldUI.getText()));
    }

    @Override
    public StringValue visit(StringType stringType)
    {
        return new StringValue(this._textFieldUI.getText());
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
