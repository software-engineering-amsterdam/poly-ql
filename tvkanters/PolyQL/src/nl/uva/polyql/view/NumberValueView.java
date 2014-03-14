package nl.uva.polyql.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.InvalidParameterException;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.types.NumberType;
import nl.uva.polyql.ast.values.BooleanValue;
import nl.uva.polyql.ast.values.NumberValue;
import nl.uva.polyql.ast.values.StringValue;

public class NumberValueView extends ValueView {

    private JTextField mTextField;

    public NumberValueView(final Question question) {
        super(question);
    }

    @Override
    protected void init() {
        mTextField = new JTextField();
        mTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent e) {}

            @Override
            public void keyReleased(final KeyEvent e) {
                onNewInput(new NumberType().parseInput(mTextField.getText()));
            }

            @Override
            public void keyPressed(final KeyEvent e) {}
        });
    }

    @Override
    public Component getComponent() {
        return mTextField;
    }

    @Override
    public void setComponentValue(final NumberValue value) {
        mTextField.setText(value.toString());
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
    public void setEditable(final boolean enabled) {
        mTextField.setEnabled(enabled);
    }

    @Override
    protected void setValid(final boolean valid) {
        mTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(valid ? Color.WHITE : Color.RED),
                BorderFactory.createEmptyBorder(2, 5, 2, 0)));
    }
}
