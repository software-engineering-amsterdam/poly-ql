package org.uva.sea.ql.parser.antlr.QL4.AST;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Abstract syntax tree of the conditional construct in the QL4 grammar
 * 
 * Holds an if expression, possibly ifelse expression,
 * possibly else expression and their corresponding structures
 * @author Sammie Katt
 *
 */
public class ConditionalStructure implements QLTree {
	
	// holds the expressions in if and else conditions 
	final private Expression ifCondition;
	
	// holds the elseif conditions 
	final private List<Expression> elseifConditions;

	// holds the structures of if and else conditions
	final private Structures ifStructure, elseStructure;
	
	// holds the structures of the elseif conditions
	final private List<Structures> elseifStructures;
	
	/**
	 * Constructor, sets if and elseif conditions and
	 * if, else and elseif structures 
	 * @param ifCondition
	 * @param elseifExprs 
	 * @param elseCondition
	 * @param elseStruc 
	 * @param elseifConditions
	 */
	public ConditionalStructure(Expression ifCondition, List<Expression> elseifConditions, Structures ifStructure, List<Structures> elseifStructures, Structures elseStructure) {
		this.ifCondition = ifCondition;
		this.elseifConditions = elseifConditions;

		this.ifStructure = ifStructure;
		this.elseStructure = elseStructure;
		this.elseifStructures = elseifStructures;
	}
	
	/**
	 * Standard to string, returning content of conditional in a string form
	 */
	public String toString() {
		String str = "If " + ifCondition
				+ "\nthen " + ifStructure;
		
		for (int i = 0; i < elseifConditions.size(); i++) {
			str += "\nElseif " + elseifConditions.get(i);
			str += "\nthen " + elseifStructures.get(i);
		}
		
		str += "\nElse " + elseStructure;

		return str;
	}

	public Object accept(IQLVisitor<?> visitor) {
		return visitor.visit(this);
	}

	///////// getters and setters 
	
	public Expression getIfExpression() {
		return ifCondition;
	}

	public Structures getIfStructures() {
		return ifStructure;
	}

	public List<Expression> getElseIfExpr() {
		return elseifConditions;
	}

	public List<Structures> getElseIfStructs() {
		return elseifStructures;
	}

	public Structures getElseStruct() {
		return elseStructure;
	}
}
