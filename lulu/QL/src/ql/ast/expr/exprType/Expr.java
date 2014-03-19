package ql.ast.expr.exprType;

import java.util.List;
import ql.ast.environment.Environment;
import ql.ast.message.Error;
import ql.ast.type.Type;
import ql.ast.value.Value;


public abstract class Expr {
	public abstract Value eval(Environment environment);
	public abstract Type getType(Environment environment);
	public abstract List<Error> checkType(Environment environment);
}
