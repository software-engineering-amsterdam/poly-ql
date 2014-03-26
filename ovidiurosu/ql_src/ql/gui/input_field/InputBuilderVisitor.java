package ql.gui.input_field;

import ql.ast.expression_evaluator.ValueEnvironment;
import ql.ast.expression_value.BooleanValue;
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
 * @author orosu
 */
public class InputBuilderVisitor implements ITypeElementVisitor<IInput>
{
    private final ValueEnvironment _valueEnvironment; // used for setting default values
    private final String _id;

    public InputBuilderVisitor(ValueEnvironment valueEnvironment, String id)
    {
        this._valueEnvironment = valueEnvironment;
        this._id = id;
    }

    @Override
    public CheckBoxInput visit(BooleanType booleanType)
    {
        // Set Default Value
        this._valueEnvironment.setValue(this._id, new BooleanValue(false));

        return new CheckBoxInput(this._id);
    }

    @Override
    public TextFieldInput visit(IntegerType integerType)
    {
        return new TextFieldInput(this._id, integerType);
    }

    @Override
    public IInput visit(DecimalType decimalType)
    {
        return new TextFieldInput(this._id, decimalType);
    }

    @Override
    public CalendarInput visit(DateType dateType)
    {
        return new CalendarInput(this._id);
    }

    @Override
    public TextFieldInput visit(StringType stringType)
    {
        return new TextFieldInput(this._id, stringType);
    }

    @Override
    public ListInput visit(EnumType enumType)
    {
        return new ListInput(this._id);
    }

    @Override
    public ListInput visit(RangeType rangeType)
    {
        return new ListInput(this._id);
    }

    @Override
    public IInput visit(NullType nullType)
    {
        assert false: "Execution should never reach this!";
        return null;
    }
}
