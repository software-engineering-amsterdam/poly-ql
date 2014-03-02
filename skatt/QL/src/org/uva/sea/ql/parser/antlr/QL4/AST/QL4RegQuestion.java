package org.uva.sea.ql.parser.antlr.QL4.AST;

/**
 * Abstract syntax tree of the regQuestion construct in the QL4 grammar
 * Contains a id, type, label and value TODO
 * May possibly be extended into several type of questions
 * @author Sammie Katt
 *
 */
public class QL4RegQuestion extends QLTree {

	/**
	 * Returns the description of the question
	 * TODO
	 */
	public String toString() {
		return "Question";
	}
}
