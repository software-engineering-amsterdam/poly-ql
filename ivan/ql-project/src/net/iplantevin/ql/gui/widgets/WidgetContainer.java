package net.iplantevin.ql.gui.widgets;

import net.iplantevin.ql.ast.statements.Computation;
import net.iplantevin.ql.ast.statements.Question;
import net.iplantevin.ql.ast.statements.Questionable;
import net.iplantevin.ql.ast.types.BooleanType;
import net.iplantevin.ql.ast.types.ITypeVisitor;
import net.iplantevin.ql.ast.types.IntegerType;
import net.iplantevin.ql.ast.types.StringType;
import net.iplantevin.ql.ast.types.UndefinedType;
import net.iplantevin.ql.gui.main.FormFrame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * Contains a label and a widget.
 *
 * @author Ivan
 */
public class WidgetContainer extends AbstractFormComponent implements ITypeVisitor<JComponent> {
    private JLabel questionLabel;
    private JComponent widget;
    private String identifier;
    private int preferredLabelWidth = 500;
    private Dimension widgetSize = new Dimension(150, 25);

    public WidgetContainer(Question question, FormFrame frame) {
        super(frame);
        setIdentifier(question);
        makeLabel(question);
        widget = question.getType().accept(this);

        initUI();
    }

    public WidgetContainer(Question question, FormFrame frame, int labelWidth,
                           int widgetWidth, int widgetHeight) {
        super(frame);
        setIdentifier(question);
        makeLabel(question);
        preferredLabelWidth = labelWidth;
        widgetSize = new Dimension(widgetWidth, widgetHeight);
        widget = question.getType().accept(this);

        initUI();
    }

    public WidgetContainer(Computation computation, FormFrame frame) {
        super(frame);
        setIdentifier(computation);
        makeLabel(computation);
    }

    public WidgetContainer(Computation computation, FormFrame frame, int labelWidth,
                           int widgetWidth, int widgetHeight) {
        super(frame);
        setIdentifier(computation);
        makeLabel(computation);
        preferredLabelWidth = labelWidth;
        widgetSize = new Dimension(widgetWidth, widgetHeight);
        widget = computation.getType().accept(this);
    }

    private void setIdentifier(Questionable questionable) {
        identifier = questionable.getName().getName();
    }

    /**
     * Creates a label that can span multiple lines by using html with a fixed
     * width.
     *
     * @param questionable the question or computation for which to create a label.
     */
    private void makeLabel(Questionable questionable) {
        String label = questionable.getLabel().getText();
        String text = String.format("<html><div style=\"width:%dpx;\">%s</div></html>",
                preferredLabelWidth, label);
        questionLabel = new JLabel(text);
        questionLabel.setHorizontalAlignment(SwingConstants.LEFT);
    }

    /**
     * Applies a BoxLayout on itself adding the label and widget to it.
     */
    private void initUI() {
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

    @Override
    public void reEvaluate() {
    }

    @Override
    protected void setActive(boolean active) {
    }

    protected Dimension getWidgetSize() {
        return widgetSize;
    }

    protected String getIdentifier() {
        return identifier;
    }

    ////////////////////////////////////////////////////////////////////////////
    // Visitor methods.
    ////////////////////////////////////////////////////////////////////////////
    @Override
    public JComponent visit(BooleanType booleanType) {
        return new BoolWidget(this);
    }

    @Override
    public JComponent visit(IntegerType integerType) {
        return new IntWidget(this);
    }

    @Override
    public JComponent visit(StringType stringType) {
        return new StrWidget(this);
    }

    @Override
    public JComponent visit(UndefinedType undefinedType) {
        return null;
    }
}
