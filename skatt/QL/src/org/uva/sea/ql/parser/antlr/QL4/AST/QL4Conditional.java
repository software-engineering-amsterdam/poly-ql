package org.uva.sea.ql.parser.antlr.QL4.AST;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract syntax tree of the conditional construct in the QL4 grammar
 * 
 * TODO: Add structures implementation in constructor
 * 
 * Holds an if expression, possibly ifelse expression,
 * possibly else expression and their corresponding structures
 * @author Sammie Katt
 *
 */
public class QL4Conditional extends QLTree {
	
	// holds the expressions in if and else conditions 
	QLTree ifCondition, elseCondition;
	
	// holds the elseif conditions 
	List<QLTree> elseifConditions = new ArrayList<QLTree>();

	// holds the structures of if and else conditions
	QLTree ifStructures, elseStructures;
	
	// holds the structures of the elseif conditions
	List<QLTree> elseifStructures = new ArrayList<QLTree>();
	
	/**
	 * Constructor, sets if, else and ifelse conditions 
	 * @param ifCondition
	 * @param elseCondition
	 * @param elseifConditions
	 */
	public QL4Conditional(QLTree ifCondition, QLTree elseCondition, List<QLTree> elseifConditions) {
		this.ifCondition = ifCondition;
		this.elseCondition = elseCondition;
		this.elseifConditions = elseifConditions;
	}
	
	/**
	 * Standard to string, returning content of conditional in a string form
	 */
	public String toString() {
		String str = "A conditional statement containing:" 
				+ "\nIf condition: " + ifCondition
				+ "\nIf Structures: " + ifStructures;
		
		for (int i = 0; i < elseifConditions.size(); i++) {
			str += "\nElseif condition " + elseifConditions.get(i);
			str += "\nElseif structure " + elseifStructures.get(i);
		}
		
		str += "\nElse condition " + elseCondition
				+ "\nElse structure " + elseStructures;

		return str;
	}
}
