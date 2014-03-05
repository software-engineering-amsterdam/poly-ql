package org.uva.sea.ql.parser.antlr.QL4.AST;

/**
 * Abstract syntax tree of the regQuestion construct in the QL4 grammar
 * Contains a id, type, label and value 
 * 
 * TODO: May possibly be extended into several type of questions 
 * @author Sammie Katt
 *
 */
public class Question extends Tree {
	boolean computed;
	Tree id; 
	Tree label;
	Tree type;
	Tree value;
	
	/**
	 * Constructor, Sets the id, label and type
	 * Additionally, sets computed to false
	 * @param id
	 * @param label
	 * @param type
	 */
	public Question(Tree id, Tree label, Tree type) {
		this.computed = false;
		this.id = id;
		this.label = label;
		this.type = type;
	}
	
	public Question(Tree id, Tree label, Tree type, Tree value) {
		this.computed = true;
		this.id = id;
		this.label = label;
		this.type = type;
		this.value = value;
	}
	
	/**
	 * Returns the description of the question
	 */
	public String toString() {
		return "Question " + id + " of type " + type + " and label " + label;
	}
}
