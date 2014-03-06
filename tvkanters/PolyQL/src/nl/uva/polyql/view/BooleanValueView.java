package nl.uva.polyql.view;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.InvalidParameterException;

import javax.swing.JCheckBox;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;

public class BooleanValueView extends ValueView<BooleanValue> {

    private JCheckBox mCheckBox;

    public BooleanValueView(final Question question) {
        super(question);
    }

    @Override
    protected void init() {
        mCheckBox = new JCheckBox();
        mCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(final ItemEvent arg0) {
                System.out.println(mCheckBox.isSelected() ? "Y" : "N");
                onNewInput();
            }
        });
    }

    @Override
    public Component getComponent() {
        return mCheckBox;
    }

    @Override
    public BooleanValue getValueFromInput() {
        return new BooleanValue(mCheckBox.isSelected());
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
    public void setEnabled(final boolean enabled) {
        mCheckBox.setEnabled(enabled);
    }

    @Override
    protected void setValid(final boolean valid) {
        // A checkbox cannot be invalid
    }
}
