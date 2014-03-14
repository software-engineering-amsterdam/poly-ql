package nl.uva.polyql.view;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.InvalidParameterException;

import javax.swing.JTextArea;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.ast.values.StringValue;

public class StringValueView extends ValueView {

    private JTextArea mTextArea;

    public StringValueView(final Question question) {
        super(question);
    }

    @Override
    protected void init() {
        mTextArea = new JTextArea();
        mTextArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent e) {}

            @Override
            public void keyReleased(final KeyEvent e) {
                onNewInput(new StringValue(mTextArea.getText()));
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
    public void setEditable(final boolean enabled) {
        mTextArea.setEnabled(enabled);
    }

    @Override
    protected void setValid(final boolean valid) {
        // A string cannot be invalid
    }
}
