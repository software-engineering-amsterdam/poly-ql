package org.uva.sea.ql.parser.antlr.QL4.AST;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.QLExpression;

/**
 * Abstract syntax tree of the conditional construct in the QL4 grammar
 * 
 * Holds an if expression, possibly ifelse expression,
 * possibly else expression and their corresponding structures
 * @author Sammie Katt
 *
 */
public class QL4Conditional extends QLTree{
	// holds the expressions in if and else conditions 
	QLExpression ifCondition, elseCondition;
	
	// holds the elseif conditions 
	List<QLExpression> elseifConditions = new ArrayList<QLExpression>();
	
}
