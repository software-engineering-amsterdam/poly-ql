package ql.ast.visitor_elements;

import ql.ast.type.DecimalType;
import ql.ast.type.IntegerType;

/**
 * @author orosu
 */
public interface INumberTypeElementVisitor<T>
{
    public T visit(IntegerType integerType);
    public T visit(DecimalType decimalType);
}
