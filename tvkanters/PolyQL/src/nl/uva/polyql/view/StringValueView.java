package nl.uva.polyql.view;

import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.values.StringValue;

public class StringValueView extends QuestionView {

    private JTextField mTextField;

    public StringValueView(final Question question) {
        super(question);
    }

    @Override
    protected void init() {
        mTextField = new JTextField();
        mTextField.setMargin(new Insets(2, 5, 2, 0));
        mTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent e) {}

            @Override
            public void keyReleased(final KeyEvent e) {
                onNewInput(new StringValue(mTextField.getText()));
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
    public void setComponentValue(final StringValue value) {
        mTextField.setText(value.getValue());
    }

    @Override
    protected void onEditableChanged(final boolean enabled) {
        mTextField.setEnabled(enabled);
    }
}
