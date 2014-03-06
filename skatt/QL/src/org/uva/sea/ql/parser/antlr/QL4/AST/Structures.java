package org.uva.sea.ql.parser.antlr.QL4.AST;

import java.util.List;

/**
 * Abstract syntax tree of the structures construct in the QL4 grammar
 * Contains an array list of structures
 * @author Sammie Katt
 *
 */
public class Structures extends QLTree {
	
	/**
	 * A list of all the structures in 'structure'
	 */
	final private List<Structures> structures;
	
	/**
	 * Constructor, sets structures
	 * @param structures 
	 */
	public Structures(List<Structures> structures) {
		this.structures = structures;
	}
	
	/**
	 * Returns the content of structures in the form of a string
	 */
	public String toString() {
		String str = "Structure: ";
		
		// for each structure in structures add its description to the string
		for (QLTree struct : structures) {
			str += "\n" + struct.toString();
		}
		
		return str;
	}
	
}
