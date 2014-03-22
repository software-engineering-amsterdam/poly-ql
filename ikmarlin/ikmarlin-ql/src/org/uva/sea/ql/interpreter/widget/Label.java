package org.uva.sea.ql.interpreter.widget;

import java.util.EventListener;

import javax.swing.JComponent;
import javax.swing.JLabel;

import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.interpreter.value.Str;
import org.uva.sea.ql.interpreter.value.Value;

public class Label extends Widget {
	
	protected JLabel widget = new JLabel();
	
	public Label(Question question, Value<?> value){
		widget.setName(question.getIdent().getName());
		setValue(value);
	}

	@Override
	public JComponent getWidget() {
		return widget;
	}

	@Override
	public void setWidget(JComponent widget) {
		this.widget = (JLabel) widget;
	}

	@Override
	public void setValue(Value<?> value) {
		widget.setText(value.getValue().toString());
	}

	public Value<?> getValue() {
		return new Str(widget.getText());
	}
	
	@Override
	public void setActionListener(EventListener listener) {
	}

}
