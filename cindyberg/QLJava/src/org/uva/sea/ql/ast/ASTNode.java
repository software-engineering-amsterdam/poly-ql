package org.uva.sea.ql.ast;


public class ASTNode {

	public void accept(IVisitor visitor){
		visitor.visit(this);
	}
}