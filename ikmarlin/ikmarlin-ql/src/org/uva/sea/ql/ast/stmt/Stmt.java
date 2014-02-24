package org.uva.sea.ql.ast.stmt;

import org.uva.sea.ql.checker.StmtVisitable;
import org.uva.sea.ql.checker.StmtVisitor;

public abstract class Stmt implements StmtVisitable {
	
	public abstract void accept(StmtVisitor sv);

}
