package ql.ast.visitor_elements;

import ql.ast.expression.value.BooleanValue;
import ql.ast.expression.value.DecimalValue;
import ql.ast.expression.value.IntegerValue;
import ql.ast.expression.value.NullValue;
import ql.ast.expression.value.StringValue;

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
