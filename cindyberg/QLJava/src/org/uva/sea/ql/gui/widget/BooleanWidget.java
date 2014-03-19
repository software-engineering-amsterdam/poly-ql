package org.uva.sea.ql.gui.widget;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.evaluate.BooleanValue;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.gui.questionaire.State;

public class BooleanWidget extends Control{

	private JCheckBox checkbox;
	
	public BooleanWidget(Identifier identifier, State state) {
		super(identifier, state);
		checkbox = new JCheckBox();
		checkbox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
              stateChanged(e);
            }
        });
		setValue(new BooleanValue(false));
	}
	

	@Override
	public JComponent UIElement() {
		return checkbox;
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		checkbox.setEnabled(isEnabled);
	}



	public void setValue(Value value) {
		checkbox.setSelected(((BooleanValue)value).getValue());
		setChanged();
		getState().putVariable(getIdentifier(), value);
		getState().notify(getIdentifier());
	}

	public void stateChanged(ItemEvent e) {
		setValue( new BooleanValue(checkbox.isSelected()) );
	}

}
