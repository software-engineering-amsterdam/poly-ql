package org.uva.sea.ql.parser.antlr.QL4.AST.Expression;

import org.uva.sea.ql.parser.antlr.QL4.AST.QLTree;
import org.uva.sea.ql.parser.antlr.QL4.Types.Type;
/**
 * Class for abstract syntax trees of expressions for QL4. 
 * Every expression extends this. Contains get type, which
 * each child need to override.
 * 
 * @author Sammie Katt
 *
 */
public abstract class Expression implements QLTree {
	
	public Type getType() {
		return null;
	}
}
