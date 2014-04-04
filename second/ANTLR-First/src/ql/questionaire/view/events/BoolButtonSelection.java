package ql.questionaire.view.events;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;


import ql.questionaire.model.answer.BoolAnswer;
import ql.questionaire.view.QuestionView;


public class BoolButtonSelection implements FocusListener {
	private QuestionView questionView;
	private BoolAnswer expr;

	public BoolButtonSelection(QuestionView questionView, BoolAnswer bool) {
		this.questionView=questionView;
		this.expr=bool;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		questionView.updateValue(expr);
	}

	@Override
	public void focusLost(FocusEvent arg0) {	}
}
