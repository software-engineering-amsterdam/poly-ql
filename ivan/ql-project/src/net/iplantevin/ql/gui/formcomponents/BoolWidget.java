package net.iplantevin.ql.gui.formcomponents;

import net.iplantevin.ql.evaluation.BoolVal;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Checkbox widget to put in a AbstractWidgetContainer. An itemStateChanged event will
 * propagate the value change to the container and then further to the form frame.
 *
 * @author Ivan
 */
public class BoolWidget extends JCheckBox implements IWidget {
    /**
     * Constructs a new checkbox widget with the desired dimensions, sets the
     * default value and adds the ItemListener.
     *
     * @param container the AbstractWidgetContainer to use.
     */
    public BoolWidget(AbstractWidgetContainer container) {
        super("No");
        setPreferredSize(container.getPreferredWidgetSize());
        setMaximumSize(container.getPreferredWidgetSize());

        setDefaultValue(container);

        addItemListener(new BoolWidgetListener(this, container));
    }

    @Override
    public void setJComponentValue(Object value) {
    }

    @Override
    public void setDefaultValue(AbstractWidgetContainer container) {
        setSelected(false);
        container.setValue(new BoolVal(false));
    }

    /**
     * Inner ItemListener subclass that performs the necessary actions when
     * the checkbox is (un)checked by the user.
     */
    class BoolWidgetListener implements ItemListener {
        final BoolWidget widget;
        final AbstractWidgetContainer container;
        final BoolVal TRUE = new BoolVal(true);
        final BoolVal FALSE = new BoolVal(false);

        /**
         * Constructs a new listener for the given BoolWidget and AbstractWidgetContainer.
         */
        public BoolWidgetListener(BoolWidget widget, AbstractWidgetContainer container) {
            this.widget = widget;
            this.container = container;
        }

        /**
         * When the checkbox is (un)checked, its text is changed, the container's
         * value is changed and reEvaluate is called on the container.
         */
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (widget.isSelected()) {
                widget.setText("Yes");
                container.setValue(TRUE);
            } else {
                widget.setText("No");
                container.setValue(FALSE);
            }

            container.reEvaluate();
        }
    }
}
