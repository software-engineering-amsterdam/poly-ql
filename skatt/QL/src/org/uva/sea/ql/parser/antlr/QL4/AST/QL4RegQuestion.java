package org.uva.sea.ql.parser.antlr.QL4.AST;

/**
 * Abstract syntax tree of the regQuestion construct in the QL4 grammar
 * Contains a id, type, label and value 
 * 
 * TODO: May possibly be extended into several type of questions 
 * TODO: missing value, while this is important. Think of classes hierarchy with
 * comp question (who extends what?)
 * @author Sammie Katt
 *
 */
public class QL4RegQuestion extends QLTree {

	QLTree id; 
	QLTree label;
	QLTree type;
	
	/**
	 * Constructor, Sets the id, label and type
	 * @param id
	 * @param label
	 * @param type
	 */
	public QL4RegQuestion(QLTree id, QLTree label, QLTree type) {
		this.id = id;
		this.label = label;
		this.type = type;
	}
	
	/**
	 * Returns the description of the question
	 */
	public String toString() {
		return "Question " + id + " of type " + type + " and label " + label;
	}
}
