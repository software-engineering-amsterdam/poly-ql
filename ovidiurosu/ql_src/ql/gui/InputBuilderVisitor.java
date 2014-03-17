package ql.gui;

import ql.ast.type.BooleanType;
import ql.ast.type.DateType;
import ql.ast.type.DecimalType;
import ql.ast.type.EnumType;
import ql.ast.type.IntegerType;
import ql.ast.type.NullType;
import ql.ast.type.RangeType;
import ql.ast.type.StringType;
import ql.ast.visitor_elements.ITypeElementVisitor;
import ql.gui.component.input_field.CalendarInput;
import ql.gui.component.input_field.CheckBoxInput;
import ql.gui.component.input_field.IInput;
import ql.gui.component.input_field.ListInput;
import ql.gui.component.input_field.TextFieldInput;

/**
 * @author orosu
 */
public class InputBuilderVisitor implements ITypeElementVisitor<IInput>
{
    @Override
    public CheckBoxInput visit(BooleanType booleanType)
    {
        return new CheckBoxInput("Yes");
    }

    @Override
    public TextFieldInput visit(IntegerType integerType)
    {
        return new TextFieldInput(new IntegerType());
    }

    @Override
    public IInput visit(DecimalType decimalType)
    {
        return new TextFieldInput(new DecimalType());
    }

    @Override
    public CalendarInput visit(DateType dateType)
    {
        return new CalendarInput();
    }

    @Override
    public TextFieldInput visit(StringType stringType)
    {
        return new TextFieldInput(new StringType());
    }

    @Override
    public ListInput visit(EnumType enumType)
    {
        return new ListInput();
    }

    @Override
    public ListInput visit(RangeType rangeType)
    {
        return new ListInput();
    }

    @Override
    public IInput visit(NullType nullType)
    {
        assert false: "Execution should never reach this!";
        return null;
    }
}
