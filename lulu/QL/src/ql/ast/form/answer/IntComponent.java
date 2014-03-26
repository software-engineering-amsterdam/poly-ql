package ql.ast.form.answer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import ql.ast.environment.Environment;
import ql.ast.expr.exprType.Ident;
import ql.ast.form.Form;
import ql.ast.value.Int;
import ql.ast.value.Value;

public class IntComponent extends AnswerComponent{
	private JTextField answer;
	
	@Override
	public JComponent getAnswerField(boolean enabled, final Environment environment,
			final Form form, final Ident id) {
		answer = new JTextField(15);
		answer.setEnabled(enabled);
		answer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isValidInteger())
					submitResult(environment, form, id);
				else
					showErrorMessageAndClearField();
				
				form.eval();
			}
		});
		
		answer.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (isValidInteger()) {
					submitResult(environment, form, id);
					form.eval();
				}
				else if (!answer.getText().equals("")) {
					showErrorMessageAndClearField();
				}
			}
			@Override
			public void focusGained(FocusEvent e) {}
		});
		return answer;
	}

	@Override
	public boolean hasValue() {
		return isValidInteger();
	}

	@Override
	public Value getAnswerValue() {
		if(isValidInteger())
			return new Int(Integer.parseInt(answer.getText()));
		return new Int();
	}

	@Override
	public void setAnswerValue(Value value) {
		if (value.getClass().equals(Int.class)) {
			answer.setText(((Int)value).getValue().toString());
		}
		else {
			throw new IllegalArgumentException("The given value should be a Integer type");
		}
	}

	@Override
	public void setVisible(boolean visible) {
		answer.setVisible(visible);		
	}

	private boolean isValidInteger() {
		try {
			Integer.parseInt(answer.getText());
		}
		catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private void showErrorMessageAndClearField() {
		JOptionPane.showMessageDialog(null, "The value should be an Integer!");
		answer.setText("");
	}
}
