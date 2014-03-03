package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.checker.visitor.IStmtVisitable;
import org.uva.sea.ql.checker.visitor.IStmtVisitor;

public abstract class Stmt implements IStmtVisitable {
	
	public abstract void accept(IStmtVisitor sv);

}
