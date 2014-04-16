package org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Question;
import org.uva.sea.ql.parser.antlr.QL4.Messages.DuplicateLabelError;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.QLErrorGenerator;

/**
 * Visitor that checks a QLTree on duplicate labels
 * @author Sammie Katt
 *
 */
public class DuplicateLabelChecker extends QLErrorGenerator {

	/**
	 * The list of labels found when visiting
	 */
	List<Label> labels = new ArrayList<Label>();
	
	@Override
	/**
	 * When visiting a question, its label is compared to 
	 * previous visited questions labels. If it is a duplicate,
	 * a warning is returned, otherwise it is added to the list 
	 * of known labels
	 */
	public List<QLErrorMsg> visit(Question question) {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		Label qLabel = question.getLabel();
		
		if (labels.contains(qLabel)) {
			msgs.add(new DuplicateLabelError(qLabel));
		} else {
			labels.add(qLabel);
		}
		
		return msgs;
	}
}
