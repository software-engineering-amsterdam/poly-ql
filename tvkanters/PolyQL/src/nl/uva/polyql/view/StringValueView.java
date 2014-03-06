package nl.uva.polyql.view;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.InvalidParameterException;

import javax.swing.JTextArea;

import nl.uva.polyql.model.Question;
import nl.uva.polyql.model.values.BooleanValue;
import nl.uva.polyql.model.values.NumberValue;
import nl.uva.polyql.model.values.StringValue;

public class StringValueView extends ValueView<StringValue> {

    private JTextArea mTextArea;

    public StringValueView(final Question question) {
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
    public StringValue getValueFromInput() {
        return new StringValue(mTextArea.getText());
    }

    @Override
    public void setComponentValue(final StringValue value) {
        mTextArea.setText(value.getValue());
    }

    @Override
    public void setComponentValue(final BooleanValue value) {
        throw new InvalidParameterException("Booleans are invalid values for string views");
    }

    @Override
    public void setComponentValue(final NumberValue value) {
        throw new InvalidParameterException("Numbers are invalid values for string views");
    }

    @Override
    public void setEnabled(final boolean enabled) {
        mTextArea.setEnabled(enabled);
    }

    @Override
    protected void setValid(final boolean valid) {
        // A string cannot be invalid
    }
}
