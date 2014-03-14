package nl.uva.polyql.view;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.InvalidParameterException;

import javax.swing.JCheckBox;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.ast.values.StringValue;

public class BooleanValueView extends ValueView {

    private JCheckBox mCheckBox;

    public BooleanValueView(final Question question) {
        super(question);
    }

    @Override
    protected void init() {
        mCheckBox = new JCheckBox();
        mCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(final ItemEvent e) {
                onNewInput(new BooleanValue(mCheckBox.isSelected()));
            }
        });
    }

    @Override
    public Component getComponent() {
        return mCheckBox;
    }

    @Override
    public void setComponentValue(final BooleanValue value) {
        mCheckBox.setSelected(value.getValue());
    }

    @Override
    public void setComponentValue(final NumberValue value) {
        throw new InvalidParameterException("Numbers are invalid values for boolean views");
    }

    @Override
    public void setComponentValue(final StringValue value) {
        throw new InvalidParameterException("Strings are invalid values for boolean views");
    }

    @Override
    public void setEditable(final boolean enabled) {
        mCheckBox.setEnabled(enabled);
    }

    @Override
    protected void setValid(final boolean valid) {
        // A checkbox cannot be invalid
    }
}
