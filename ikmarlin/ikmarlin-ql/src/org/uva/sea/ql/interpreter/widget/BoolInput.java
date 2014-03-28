package org.uva.sea.ql.interpreter.widget;

import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.interpreter.value.Bool;
import org.uva.sea.ql.interpreter.value.Value;

public class BoolInput extends Widget {
	
	private JCheckBox widget= new JCheckBox();
	
	public BoolInput(Question question, Value<?> value){
		widget.setName(question.getIdent().getName());
		setValue(value);
	}
	
	@Override
	public JComponent getWidget() {
		return widget;
	}
	
	@Override
	public void setWidget(JComponent widget) {
		this.widget = (JCheckBox) widget;
	}

	@Override
	public void setValue(Value<?> value) {
		if (value.getValue() != null) {
			Bool boolValue = (Bool) value;
			widget.setSelected(boolValue.getValue());
		}
	}

	@Override
	public Value<?> getValue() {
		return new Bool(widget.isSelected());
	}

	@Override
	public void setActionListener(EventListener listener) {
		widget.addActionListener((ActionListener) listener);
	}

}
