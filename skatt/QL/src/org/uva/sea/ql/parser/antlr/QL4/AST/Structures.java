package org.uva.sea.ql.parser.antlr.QL4.AST;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Abstract syntax tree of the structures construct in the QL4 grammar
 * Contains an array list of structures
 * @author Sammie Katt
 *
 */
public class Structures implements QLTree {
	
	/**
	 * A list of all the structures in 'structure'
	 */
	final private List<QLTree> structures;
	
	/**
	 * Constructor, sets structures
	 * @param structures 
	 */
	public Structures(List<QLTree> structures) {
		this.structures = structures;
	}
	
	@Override
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
	
	public Object accept(IQLVisitor<?> visitor) {
		return visitor.visit(this);
	}
	
	public List<QLTree> getStructures() {
		return structures;
	}
	
}
