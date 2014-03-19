package org.uva.sea.ql.gui.widget;

import javax.swing.JComponent;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.gui.questionaire.State;

public class MissingWidget extends Control {

	public MissingWidget(Identifier identifier, State state) {
		super(identifier, state);
	}


	@Override
	public JComponent UIElement() {
		throw new UnsupportedOperationException();
	}


	@Override
	public void setEnabled(boolean isEnabled) {
		throw new UnsupportedOperationException();
	}


	@Override
	public void setValue(Value value) {
		throw new UnsupportedOperationException();
		
	}


}
