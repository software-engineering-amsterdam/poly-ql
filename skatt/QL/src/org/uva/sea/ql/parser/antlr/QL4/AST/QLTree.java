package org.uva.sea.ql.parser.antlr.QL4.AST;

import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;


/**
 * Class for abstract syntax trees for QL4. Every class 
 * created during parsing extends this
 * @author Sammie Katt
 *
 */
public interface QLTree {
	
	public <T> T accept(IQLVisitor<T> visitor);
}
