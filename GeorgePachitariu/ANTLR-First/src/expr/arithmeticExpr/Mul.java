package expr.arithmeticExpr;



import typeChecker.ASTVisitor;
import expr.BinaryExpr;
import expr.Expression;

public class Mul extends BinaryExpr {

	public Mul(Expression first, Expression second) {
		super(first,second);
	}
	
	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visit(this);
		this.first.accept(visitor);
		this.second.accept(visitor);
	}
	
	@Override
	public boolean isBoolean() {
		return false;
	}
	
	@Override
	public String toString() {
		return this.first.toString() + "*" + this.second.toString(); 
	}
}
