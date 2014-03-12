package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;

/**
 * Visitor that checks a QLTree on duplicate question identifiers
 * @author Sammie Katt
 *
 */
public class DuplicateQuestionChecker extends QLErrorVisitor {

	/**
	 * The list of identifiers found when visiting
	 */
	List<Identifier> ids = new ArrayList<Identifier>();
	
	@Override
	/**
	 * When visiting a question, its identifier is compared to 
	 * previous visited questions identifiers. If it is a duplicate,
	 * a warning is returned, otherwise it is added to the list 
	 * of known identifiers 
	 */
	public List<QLErrorMsg> visit(Question question) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		Identifier qId = question.getIdentifier();
		
		if (ids.contains(qId)) {
			msgs.add(new QLErrorMsg("A duplicate question id is used: " + qId));
		} else {
			ids.add(qId);
		}
		
		return msgs;
	}
}
