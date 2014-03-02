package org.uva.sea.ql.parser.antlr.QL4.AST;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract syntax tree of the structures construct in the QL4 grammar
 * Contains an array list of structures
 * @author Sammie Katt
 *
 */
public class QL4Structures extends QLTree {
	
	/**
	 * A list of all the structures in 'structure'
	 */
	List<QLTree> structures = new ArrayList<QLTree>();
	
	/**
	 * Constructor, sets structures
	 * @param structures 
	 */
	public QL4Structures(List<QLTree> structures) {
		this.structures = structures;
	}
	
	/**
	 * Returns the content of structures in the form of a string
	 */
	public String toString() {
		String str = "Structure containing: \n";
		
		// for each structure in structures add its description to the string
		for (QLTree struct : structures) {
			str += struct.toString() + "\n";
		}
		
		return str;
	}
	
}
