package ast;

public interface ASTNode {
	<T> T accept (Visitor<T> visitor);
}
