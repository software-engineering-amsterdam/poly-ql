package ql.questionaire.view;

import org.eclipse.swt.widgets.Text;

import ql.questionaire.view.observer.ValueObserver;

public class TextLabel implements ValueObserver {
	private Text text;

	public TextLabel(Text text) {
		this.text=text;
	}

	@Override
	public void setNewValue(String value) {
		text.setText(value);		
	}

	@Override
	public void clearValue() {
		text.setText("");
	}
}


