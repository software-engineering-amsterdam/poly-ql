package org.uva.sea.ql.parser.antlr.QL4.AST;

import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Abstract syntax tree of the form construct in the QL4 grammar
 * @author Sammie Katt
 *
 */
public class Form implements QLTree {
	
	/**
	 * The structures of the form, the upper most 
	 * collection of all questions and conditionals
	 */
	final private Structures structures;
	
	/**
	 * Constructor, setting input QLtree as structures
	 * @param structures
	 */
	public Form(Structures structures) {
		this.structures = structures;
	}
		
	/**
	 * Returns a string explaining its content
	 */
	public String toString() {
		return "This form contains " + structures.toString();
	}
	
	@Override
	public Object accept(IQLVisitor<?> visitor) {
		return visitor.visit(this);
	}

	public Structures getStructures() {
		return structures;
	}
}
