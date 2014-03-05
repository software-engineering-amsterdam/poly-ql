package org.uva.sea.ql.parser.antlr.QL4.AST;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract syntax tree of the structures construct in the QL4 grammar
 * Contains an array list of structures
 * @author Sammie Katt
 *
 */
public class Structures extends Tree {
	
	/**
	 * A list of all the structures in 'structure'
	 */
	List<Tree> structures = new ArrayList<Tree>();
	
	/**
	 * Constructor, sets structures
	 * @param structures 
	 */
	public Structures(List<Tree> structures) {
		this.structures = structures;
	}
	
	/**
	 * Returns the content of structures in the form of a string
	 */
	public String toString() {
		String str = "Structure: ";
		
		// for each structure in structures add its description to the string
		for (Tree struct : structures) {
			str += "\n" + struct.toString();
		}
		
		return str;
	}
	
}
