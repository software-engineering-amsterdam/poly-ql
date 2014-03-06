package nl.uva.polyql.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.InvalidParameterException;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.types.NumberType;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;

public class NumberValueView extends ValueView<NumberValue> {

    private JTextArea mTextArea;

    public NumberValueView(final Question question) {
        super(question);
    }

    @Override
    protected void init() {
        mTextArea = new JTextArea();
        mTextArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent arg0) {}

            @Override
            public void keyReleased(final KeyEvent arg0) {
                System.out.println(mTextArea.getText());
                onNewInput();
            }

            @Override
            public void keyPressed(final KeyEvent e) {}
        });
    }

    @Override
    public Component getComponent() {
        return mTextArea;
    }

    @Override
    public void setComponentValue(final NumberValue value) {
        mTextArea.setText(value.toString());
    }

    @Override
    public NumberValue getValueFromInput() {
        return new NumberType().parseInput(mTextArea.getText());
    }

    @Override
    public void setComponentValue(final BooleanValue value) {
        throw new InvalidParameterException("Booleans are invalid values for number views");
    }

    @Override
    public void setComponentValue(final StringValue value) {
        throw new InvalidParameterException("Strings are invalid values for number views");
    }

    @Override
    public void setEnabled(final boolean enabled) {
        mTextArea.setEnabled(enabled);
    }

    @Override
    protected void setValid(final boolean valid) {
        mTextArea.setBorder(BorderFactory.createLineBorder(valid ? Color.WHITE : Color.RED));
    }
}
