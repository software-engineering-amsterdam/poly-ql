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
public class Conditional extends QL4Tree {
	
	// holds the expressions in if and else conditions 
	QL4Tree ifCondition;
	
	// holds the elseif conditions 
	List<QL4Tree> elseifConditions = new ArrayList<QL4Tree>();

	// holds the structures of if and else conditions
	QL4Tree ifStructure, elseStructure;
	
	// holds the structures of the elseif conditions
	List<QL4Tree> elseifStructures = new ArrayList<QL4Tree>();
	
	/**
	 * Constructor, sets if and elseif conditions and
	 * if, else and elseif structures 
	 * @param ifCondition
	 * @param elseifExprs 
	 * @param elseCondition
	 * @param elseStruc 
	 * @param elseifConditions
	 */
	public Conditional(QL4Tree ifCondition, List<QL4Tree> elseifConditions, QL4Tree ifStructure, List<QL4Tree> elseifStructures, QL4Tree elseStructure) {
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
