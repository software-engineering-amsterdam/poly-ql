package org.uva.sea.ql.parser.antlr.QL4.Visitors.Errors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Value;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Messages.UndefinedQuestionError;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.QLErrorVisitor;


/**
 * Visits the custom AST created by AntlrVisitor and check whether undefined 
 * questions are referred to
 * 
 * @author Sammie Katt
 *
 */
public class UndefQuestionChecker extends QLErrorVisitor {
	/**
	 * Holds all the questions defined
	 */
	private List<Identifier> definedQuestions = new ArrayList<Identifier>();
	
	/**
	 * Adds id of the visited question to definedQuestions
	 */
	public List<QLErrorMsg> visit(Question question) {
		definedQuestions.add(question.getIdentifier());
		return null;
	}
	
	/**
	 * Returns an error msgs whenever a identifier is visited 
	 * that has not been added to defined questions
	 */
	public List<QLErrorMsg> visit(Identifier id) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		if (!definedQuestions.contains(id)) {
			msgs.add(new UndefinedQuestionError(id));
		}
		
		return msgs;
	}
	
	public List<QLErrorMsg> visit(Value value) {
		return null;
	}
}
