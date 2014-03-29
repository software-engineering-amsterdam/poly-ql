package net.iplantevin.ql.gui.formcomponents;

import net.iplantevin.ql.evaluation.UndefinedVal;
import net.iplantevin.ql.gui.main.FormFrame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

import static org.apache.commons.lang3.StringEscapeUtils.escapeHtml4;

/**
 * Contains a label and a widget. Implements the necessary value change event
 * related actions.
 *
 * @author Ivan
 */
public abstract class AbstractWidgetContainer extends AbstractFormComponent {
    private JLabel questionLabel;
    private String identifier;
    private JComponent widget;
    private int preferredLabelWidth;
    private Dimension preferredWidgetSize;

    public AbstractWidgetContainer(String identifier, String labelText, FormFrame frame) {
        super(frame);
        setupWidgetContainer(identifier, labelText, frame);
    }

    private void setupWidgetContainer(String identifier, String labelText, FormFrame frame) {
        preferredLabelWidth = frame.getPreferredLabelWidth();
        preferredWidgetSize = frame.getPreferredWidgetSize();
        this.identifier = identifier;
        makeLabel(labelText);
    }

    public void setWidget(JComponent widget) {
        this.widget = widget;
    }

    public JComponent getWidget() {
        return widget;
    }

    /**
     * Creates a label that can span multiple lines by using html with a fixed
     * width. Escapes the string for html characters.
     *
     * @param labelText the Question or Computation for which to create a label.
     */
    private void makeLabel(String labelText) {
        String text = String.format("<html><div style=\"width:%dpx;\">%s</div></html>",
                preferredLabelWidth, escapeHtml4(labelText));
        questionLabel = new JLabel(text);
    }

    /**
     * Applies a BoxLayout on itself adding the label and widget to it.
     */
    public void initUI() {
        setAlignmentX(LEFT_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(questionLabel);
        add(Box.createHorizontalGlue());
        add(widget);

        Border rowBorder = BorderFactory.createCompoundBorder(
                new MatteBorder(0, 0, 1, 0, Color.black),
                new EmptyBorder(3, 3, 3, 3)
        );
        setBorder(rowBorder);
    }

    /**
     * Initialize value in FormFrame.
     */
    @Override
    public void initValue() {
        getFormFrame().storeValue(identifier, getValue());
    }

    /**
     * Handles toggling of active state.
     *
     * @param active whether the AbstractWidgetContainer should be active or not.
     */
    @Override
    protected void setActive(boolean active) {
        super.setActive(active);

        if (active) {
            // The AbstractWidgetContainer was inactive, set default values on (re)activation.
            ((IWidget) widget).setDefaultValue(this);
            reEvaluate();
        } else {
            // Value is considered undefined if element is inactive, propagate
            // this change.
            UndefinedVal undefined = new UndefinedVal();
            setValue(undefined);
            getFormFrame().registerValueChange(this, undefined);
        }
    }

    protected Dimension getPreferredWidgetSize() {
        return preferredWidgetSize;
    }

    public String getIdentifier() {
        return identifier;
    }
}
