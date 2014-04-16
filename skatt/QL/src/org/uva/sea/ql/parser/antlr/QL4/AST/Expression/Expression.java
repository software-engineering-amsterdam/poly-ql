package org.uva.sea.ql.parser.antlr.QL4.AST.Expression;

import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.QLTree;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
/**
 * Class for abstract syntax trees of expressions for QL4. 
 * Every expression extends this. Contains get type, which
 * each child need to override.
 * 
 * @author Sammie Katt
 *
 */
public abstract class Expression implements QLTree {
	
	public Type getType(Map<Identifier, Question> questions) {
		return null;
	}
}
