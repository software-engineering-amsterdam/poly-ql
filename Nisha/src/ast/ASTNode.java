package ast;

public interface ASTNode {
	public <T> T accept (Visitor<T> visitor);
}
