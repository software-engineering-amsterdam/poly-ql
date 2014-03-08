package org.uva.sea.ql.parser.antlr.QL4.AST.Value;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

public abstract class Value extends Expression {
	
	public List<QLErrorMsg> accept(IQLVisitor visitor) {
		return visitor.visit(this);
	}
}
