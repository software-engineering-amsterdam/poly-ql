package ql.ast.statement;
import ql.ast.*;

/**
 * Interface for statements
 */
public interface StatementInterface extends ElementInterface {
	public StatementTypeInterface getType();
}
