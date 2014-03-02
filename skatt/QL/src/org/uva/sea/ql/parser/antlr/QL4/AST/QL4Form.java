package org.uva.sea.ql.parser.antlr.QL4.AST;

import java.util.List;

/**
 * Abstract syntax tree of the form construct in the QL4 grammar
 * @author Sammie Katt
 *
 */
public class QL4Form extends IQLTree {
	
	/**
	 * The structures of the form, the upper most 
	 * collection of all questions and conditionals
	 */
	IQLTree structures;
	
	/**
	 * sets structures of the form 
	 * @param structures is the structures tree
	 */
	public void setStructures(IQLTree structures) {
		this.structures = structures;
	}
	
	/**
	 * Returns a string explaining its content
	 */
	public String toString() {
		return "This form contains" + structures.toString();
	}
}
