package ql.questionaire.view.events;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;

import ql.questionaire.model.answer.StringAnswer;
import ql.questionaire.view.QuestionView;

public class StringTextBoxSelection implements SelectionListener {
	private Text text;
	private QuestionView questionView;

	public StringTextBoxSelection(QuestionView questionView,Text text) {
		this.text=text;
		this.questionView=questionView;
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {		
		questionView.updateValue(new StringAnswer(text.getText()));		
	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		questionView.updateValue(new StringAnswer(text.getText()));
	}
}
