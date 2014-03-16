package nl.uva.polyql.view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTextField;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.values.NumberValue;

public class NumberValueView extends QuestionView {

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
                onNewInput(NumberValue.parse(mTextField.getText()));
            }

            @Override
            public void keyPressed(final KeyEvent e) {}
        });
    }

    @Override
    protected JComponent getValueComponent() {
        return mTextField;
    }

    @Override
    public void setComponentValue(final NumberValue value) {
        mTextField.setText(value.toString());
    }

    @Override
    protected void onEditableChanged(final boolean enabled) {
        mTextField.setEnabled(enabled);
    }

    @Override
    protected void onValidityChanged(final boolean valid) {
        mTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(valid ? Color.LIGHT_GRAY : Color.RED),
                BorderFactory.createEmptyBorder(2, 5, 2, 0)));
    }
}
