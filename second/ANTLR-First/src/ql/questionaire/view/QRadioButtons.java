package ql.questionaire.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import ql.questionaire.model.answer.BoolAnswer;
import ql.questionaire.view.events.BoolButtonSelection;
import ql.questionaire.view.observer.ValueObserver;

public class QRadioButtons implements ValueObserver {
	private Button[] radioButtons;

	public QRadioButtons(boolean isEditable, Composite group, QuestionView questionView) {

		radioButtons = new Button[2];
		radioButtons[0] = createRadioButton("true",group);
		radioButtons[1] = createRadioButton("false",group);

		radioButtons[0].addFocusListener(
				new BoolButtonSelection(questionView,new BoolAnswer(true)));
		radioButtons[1].addFocusListener(
				new BoolButtonSelection(questionView,new BoolAnswer(false)));
		if(! isEditable) {
			radioButtons[0].setEnabled(false);
			radioButtons[1].setEnabled(false);
		}
	}

	@Override
	public void setNewValue(String value) {
		if(value.equals("true"))
			radioButtons[0].setSelection(true);
		else if(value.equals("false"))
			radioButtons[1].setSelection(true);
		else assert false : "New Value unrecognised";
	}

	private Button createRadioButton(String text, Composite group) {
		Button button = new Button(group, SWT.RADIO);
		button.setText(text);    	
		button.pack();
		return button;
	}

	@Override
	public void clearValue() {
		radioButtons[0].setSelection(false);
		radioButtons[1].setSelection(false);
	}

}
