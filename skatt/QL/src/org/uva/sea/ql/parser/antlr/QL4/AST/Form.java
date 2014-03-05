package org.uva.sea.ql.parser.antlr.QL4.AST;

/**
 * Abstract syntax tree of the form construct in the QL4 grammar
 * @author Sammie Katt
 *
 */
public class Form extends Tree {
	
	/**
	 * The structures of the form, the upper most 
	 * collection of all questions and conditionals
	 */
	Tree structures;
	
	/**
	 * Constructor, setting input QLtree as structures
	 * @param structures
	 */
	public Form(Tree structures) {
		this.structures = structures;
	}
		
	/**
	 * Returns a string explaining its content
	 */
	public String toString() {
		return "This form contains " + structures.toString();
	}
}
