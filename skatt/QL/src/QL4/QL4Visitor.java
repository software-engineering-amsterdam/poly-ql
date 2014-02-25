package QL4;

/**
 * A visitor for the QL4 grammar. Visits a tree parsed by the Antlr4
 * generated QL4parser on the QL4 grammar. 
 * @author Sammie Katt
 *
 */
public class QL4Visitor {

	// Handles the information printed
	boolean verbose = true;
	
	/**
	 * Specifies behavior when visiting a structure. Depending on the 
	 * context of the structure different work flow applies. A structure
	 * may contain either a question, or a form of if/else statements
	 * and structures in between.
	 * @param ctx is the context of the structure
	 */
	public void visitStructure(QL4Parser.StructureContext ctx) {
		
	}
}
