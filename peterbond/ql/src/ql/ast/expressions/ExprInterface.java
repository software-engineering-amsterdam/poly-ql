package ql.ast.expressions;

import ql.ast.types.TInterface;
import ql.ast.EInterface;

public interface ExprInterface extends EInterface {
    public TInterface getType();
}