package org.uva.sea.ql.parser.antlr.QL4.AST;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.QLIVisitor;


/**
 * Class for abstract syntax trees for QL4. Every class 
 * created during parsing extends this
 * @author Sammie Katt
 *
 */
public abstract class QLTree {
	
	public List<QLErrorMsg> accept(QLIVisitor visitor) {
		return visitor.visit(this);
	}
}
