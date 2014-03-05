package org.uva.sea.ql.parser.antlr.QL4.AST;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract syntax tree of the conditional construct in the QL4 grammar
 * 
 * Holds an if expression, possibly ifelse expression,
 * possibly else expression and their corresponding structures
 * @author Sammie Katt
 *
 */
public class Conditional extends QLTree {
	
	// holds the expressions in if and else conditions 
	QLTree ifCondition;
	
	// holds the elseif conditions 
	List<QLTree> elseifConditions = new ArrayList<QLTree>();

	// holds the structures of if and else conditions
	QLTree ifStructure, elseStructure;
	
	// holds the structures of the elseif conditions
	List<QLTree> elseifStructures = new ArrayList<QLTree>();
	
	/**
	 * Constructor, sets if and elseif conditions and
	 * if, else and elseif structures 
	 * @param ifCondition
	 * @param elseifExprs 
	 * @param elseCondition
	 * @param elseStruc 
	 * @param elseifConditions
	 */
	public Conditional(QLTree ifCondition, List<QLTree> elseifConditions, QLTree ifStructure, List<QLTree> elseifStructures, QLTree elseStructure) {
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
}
