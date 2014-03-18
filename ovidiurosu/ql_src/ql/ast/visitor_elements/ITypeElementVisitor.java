package ql.ast.visitor_elements;

import ql.ast.type.BooleanType;
import ql.ast.type.DateType;
import ql.ast.type.EnumType;
import ql.ast.type.NullType;
import ql.ast.type.RangeType;
import ql.ast.type.StringType;

/**
 * @author orosu
 */
public interface ITypeElementVisitor<T> extends INumberTypeElementVisitor<T>
{
    public T visit(BooleanType booleanType);
    public T visit(DateType dateType);
    public T visit(StringType stringType);
    public T visit(EnumType enumType);
    public T visit(RangeType rangeType);
    public T visit(NullType nullType);
}
