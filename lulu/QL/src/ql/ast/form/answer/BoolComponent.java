package ql.ast.form.answer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import net.miginfocom.swing.MigLayout;
import ql.ast.environment.Environment;
import ql.ast.expr.exprType.Ident;
import ql.ast.form.Form;
import ql.ast.value.Bool;
import ql.ast.value.Value;

public class BoolComponent extends AnswerComponent{
	private JPanel panel;
	private JRadioButton buttonTrue, buttonFalse;
	
	@Override
	public JComponent getAnswerField(boolean enabled, final Environment environment,
			final Form form, final Ident id) {
		panel = new JPanel(new MigLayout("ins 1"));
		ButtonGroup buttons = new ButtonGroup();
		buttonTrue = new JRadioButton("Yes");
		buttonFalse = new JRadioButton("No");
		buttonTrue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				environment.addValue(id, new Bool(true));
				form.eval();
			}
		});
		
		buttonFalse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				environment.addValue(id, new Bool(false));
				form.eval();
			}
		});
		
		buttonTrue.setEnabled(enabled);
		buttonFalse.setEnabled(enabled);
		buttons.add(buttonTrue);
		buttons.add(buttonFalse);
		panel.add(buttonTrue);
		panel.add(buttonFalse);
		return panel;
	}

	@Override
	public boolean hasValue() {
		return buttonTrue.isSelected();
	}

	@Override
	public Value getAnswerValue() {
		return new Bool(buttonTrue.isSelected());
	}

	@Override
	public void setAnswerValue(Value value) {
		if (value.getClass().equals(Bool.class)) {
			if (((Bool)value).getValue()) {
				buttonTrue.setSelected(true);
			}
			else {
				buttonFalse.setSelected(true);
			}
		}
		else {
			throw new IllegalArgumentException("The given value should be a Boolean type");
		}		
	}

	@Override
	public void setVisible(boolean visible) {
		panel.setVisible(visible);	
	}

}
