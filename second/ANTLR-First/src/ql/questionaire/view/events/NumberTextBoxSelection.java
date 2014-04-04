package ql.questionaire.view.events;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;

import ql.questionaire.model.answer.IntAnswer;
import ql.questionaire.view.QuestionView;

public class NumberTextBoxSelection implements SelectionListener {
	private Text text;
	private QuestionView questionView;

	public NumberTextBoxSelection(QuestionView questionView,Text text) {
		this.text=text;
		this.questionView=questionView;
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		int answer=Integer.parseInt(text.getText());
		questionView.updateValue(new IntAnswer(answer));
	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		int answer=Integer.parseInt(text.getText());
		questionView.updateValue(new IntAnswer(answer));
	}

}
