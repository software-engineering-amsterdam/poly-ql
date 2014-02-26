package ql.ast.expression;

import ql.ast.*;
import ql.ast.type.*;

/**
 * Expression interface
 */
public interface ExpressionInterface extends ElementInterface {
	public TypeInterface getType();
}
