package org.uva.sea.ql.parser.antlr.QL4.AST;

import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.IQLVisitor;


/**
 * Class for abstract syntax trees for QL4. Every class 
 * created during parsing extends this
 * @author Sammie Katt
 *
 */
public interface QLTree {
	
	public <T> T accept(IQLVisitor<T> visitor);
}
