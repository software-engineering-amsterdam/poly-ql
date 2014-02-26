package ql.ast.statement;
import ql.ast.type.*;

/**
 * An interface for type statements
 */
public interface StatementTypeInterface {
	public TypeInterface getType();
	public String toStr();
}
