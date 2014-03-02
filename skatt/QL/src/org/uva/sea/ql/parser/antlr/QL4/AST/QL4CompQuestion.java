package org.uva.sea.ql.parser.antlr.QL4.AST;

/**
 * AST representing the Compquestion of grammar QL
 * Extends RegQuestion, adding computed value and 
 * a constructor of initializing computed value.
 * @author Sammie Katt
 *
 */
public class QL4CompQuestion extends QL4RegQuestion {
	
	QLTree value;
	
	/**
	 * Constructor, Sets the id (super), label (super), type (super) and value
	 * @param id
	 * @param label
	 * @param type
	 * @param value
	 */
	public QL4CompQuestion(QLTree id, QLTree label, QLTree type, QLTree value) {
		super(id, label, type);
		this.value = value;
	}
	
	/**
	 * Returns the description of the question
	 */
	public String toString() {
		return "Question " + id + " of type " + type + ", label " + label + ", and value " + value;
	}
}
