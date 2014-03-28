package net.iplantevin.ql.gui.main;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.evaluation.EvaluationVisitor;
import net.iplantevin.ql.evaluation.Value;
import net.iplantevin.ql.gui.formcomponents.AbstractFormComponent;
import net.iplantevin.ql.gui.formcomponents.AbstractWidgetContainer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Set;

/**
 * A window for a single form. Builds itself by visiting a given Form.
 *
 * @author Ivan
 */
public class FormFrame extends JFrame {
    private final EvaluationVisitor evaluator;
    private final FormEventManager eventManager;
    private final int preferredLabelWidth = 500;
    private final Dimension preferredWidgetSize = new Dimension(150, 25);

    public FormFrame(String title, EvaluationVisitor evaluator,
                     FormEventManager eventManager) {
        setTitle(title);
        this.evaluator = evaluator;
        this.eventManager = eventManager;
    }

    /**
     * To be called by builder to finalise creation of the frame.
     *
     * @param topComponent the top most panel containing all form elements.
     */
    public void initUI(AbstractFormComponent topComponent,
                       final GUIController controller) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // This disables horizontal scrolling (and sets a width of 850px).
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setSize(new Dimension(850, getHeight()));
                super.componentResized(e);
            }

        });

        final FormFrame thisFrame = this;

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                controller.closeForm(thisFrame);
            }
        });

        // Scrolling pane settings.
        JScrollPane formScrollPane = new JScrollPane();
        formScrollPane.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
        formScrollPane.getViewport().add(topComponent);
        add(formScrollPane);

        pack();
    }

    public Value evaluate(Expression expression) {
        return evaluator.evaluate(expression);
    }

    public void storeValue(String identifier, Value value) {
        evaluator.storeValue(identifier, value);
    }

    public void subscribe(AbstractFormComponent formComponent, Set<String> ids) {
        eventManager.subscribe(formComponent, ids);
    }

    public void registerValueChange(AbstractWidgetContainer source, Value value) {
        eventManager.scheduleEvaluation(source, value);
    }

    public int getPreferredLabelWidth() {
        return preferredLabelWidth;
    }

    public Dimension getPreferredWidgetSize() {
        return preferredWidgetSize;
    }
}
