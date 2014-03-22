package org.uva.sea.ql.interpreter.widget;

import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.EventListener;

import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;

import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.interpreter.value.Int;
import org.uva.sea.ql.interpreter.value.Undefined;
import org.uva.sea.ql.interpreter.value.Value;

public class IntInput extends Widget implements KeyListener {
	
	JFormattedTextField widget;
	NumberFormatter mf;

	public IntInput(Question question, Value<?> value) {
		mf = new NumberFormatter(NumberFormat.getIntegerInstance());
		mf.setAllowsInvalid(false);
		widget = new JFormattedTextField(mf);
		widget.setColumns(10);
		widget.setName(question.getIdent().getName());
		setValue(value);
	}

	@Override
	public void setValue(Value<?> value) {
		if(value.getValue()!=null){
			widget.setText(value.getValue().toString());
		}
	}

	@Override
	public Value<?> getValue() {
		if(!widget.getText().isEmpty()){
			String groupingSymbol = "\\"+String.valueOf(new DecimalFormatSymbols().getGroupingSeparator());
			String stringValue = widget.getText();
			return new Int(Integer.parseInt(stringValue.replaceAll(groupingSymbol, "")));
		}
		return new Undefined();
	}

	@Override
	public JComponent getWidget() {
		return widget;
	}

	@Override
	public void setWidget(JComponent widget) {
		this.widget = (JFormattedTextField) widget;
	}

	@Override
	public void setActionListener(EventListener listener) {
		widget.addFocusListener((FocusListener)listener);
		widget.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		disallow();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		disallow();
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE){
			if(widget.getText().length() == 1){
				mf.setAllowsInvalid(true);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	private void disallow(){
		if(!mf.getAllowsInvalid()){
			mf.setAllowsInvalid(false);
		}
	}

}
