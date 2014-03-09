package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;


/**
 * Visits the custom AST created by AntlrVisitor and check whether undefined 
 * questions are referred to
 * 
 * @author Sammie Katt
 *
 */
public class UndefinedCheck extends QLErrorVisitor {
	/**
	 * Holds all the questions defined
	 */
	private List<Identifier> definedQuestions = new ArrayList<Identifier>();
	
	/**
	 * Adds id of the visited question to definedQuestions
	 */
	public List<QLErrorMsg> visit(Question question) {
		System.out.println("Adding id " + question.getIdentifier());
		definedQuestions.add(question.getIdentifier());

		return null;
	}
	
	/**
	 * Returns an error msgs whenever a identifier is visited 
	 * that has not been added to defined questions
	 */
	public List<QLErrorMsg> visit(Identifier id) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		System.out.println("Testing id " + id);
		if (!definedQuestions.contains(id)) {
			msgs.add(new QLErrorMsg("Identifier " + id + " has not been defined before being used"));
		}
		
		return msgs;
	}
	
}
