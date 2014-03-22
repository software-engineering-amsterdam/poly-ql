package ql.ast.visitor_elements;

import ql.ast.expression_value.BooleanValue;
import ql.ast.expression_value.DecimalValue;
import ql.ast.expression_value.IntegerValue;
import ql.ast.expression_value.NullValue;
import ql.ast.expression_value.StringValue;

/**
 * @author orosu
 */
public interface IValueElementVisitor<T>
{
    public T visit(BooleanValue booleanValue);
    public T visit(IntegerValue integerValue);
    public T visit(DecimalValue decimalValue);
    public T visit(StringValue stringValue);
    public T visit(NullValue nullValue);
}
