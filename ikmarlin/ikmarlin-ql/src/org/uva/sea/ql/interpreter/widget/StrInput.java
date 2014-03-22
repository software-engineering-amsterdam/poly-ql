package org.uva.sea.ql.interpreter.widget;

import java.awt.event.FocusListener;
import java.util.EventListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.interpreter.value.Str;
import org.uva.sea.ql.interpreter.value.Value;

public class StrInput extends Widget {
	
	private JTextField widget= new JTextField();
	
	public StrInput(Question question, Value<?> value){
		widget.setName(question.getIdent().getName());
		setValue(value);
		widget.setColumns(20);
	}
	
	@Override
	public JComponent getWidget() {
		return widget;
	}
	
	@Override
	public void setWidget(JComponent widget) {
		this.widget = (JTextField) widget;
	}

	@Override
	public void setValue(Value<?> value) {
		if(value.getValue() != null) {
			Str strValue = (Str) value;
			widget.setText(strValue.getValue());
		}
	}

	@Override
	public Value<?> getValue() {
		return new Str(widget.getText());
	}

	@Override
	public void setActionListener(EventListener listener) {
		widget.addFocusListener((FocusListener)listener);
	}

}
