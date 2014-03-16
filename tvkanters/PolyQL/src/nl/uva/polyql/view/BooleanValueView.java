package nl.uva.polyql.view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import nl.uva.polyql.ast.Question;
import nl.uva.polyql.ast.values.BooleanValue;

public class BooleanValueView extends QuestionView {

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
    protected JComponent getValueComponent() {
        return mCheckBox;
    }

    @Override
    public void setComponentValue(final BooleanValue value) {
        mCheckBox.setSelected(value.getValue());
    }

    @Override
    protected void onEditableChanged(final boolean enabled) {
        mCheckBox.setEnabled(enabled);
    }
}
