package org.uva.sea.ql.parser.antlr.QL4.AST.Expression;

import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.QLTree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Identifier;
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
