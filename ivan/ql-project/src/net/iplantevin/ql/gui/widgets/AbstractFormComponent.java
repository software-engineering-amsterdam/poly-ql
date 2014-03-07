package net.iplantevin.ql.gui.widgets;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.evaluation.UndefinedVal;
import net.iplantevin.ql.evaluation.Value;
import net.iplantevin.ql.gui.main.FormFrame;

import javax.swing.*;

/**
 * Top level of the JPanel hierarchy from which the elements of a form are
 * created. Its subtypes are the WidgetContainer and the IfElseComponent.
 * An AbstractFormComponent can be active or inactive. An active component is
 * displayed and will react to events from the FormFrame that created it and
 * will notify that frame.
 * It contains a reference to the FormFrame that created it to manage notifications
 * and subscriptions (through AbstractFormComponentDelegate).
 *
 * @author Ivan
 */
public abstract class AbstractFormComponent extends JPanel {
    private boolean active = false;
    private final FormFrame formFrame;
    private Value value = new UndefinedVal();

    public AbstractFormComponent(FormFrame formFrame) {
        this.formFrame = formFrame;
    }

    public abstract void reEvaluate();

    /**
     * Concrete subtypes are responsible for performing the necessary actions
     * when the state changes.
     */
    protected void setActive(boolean active) {
        this.active = true;
    }

    protected boolean isActive() {
        return active;
    }

    protected FormFrame getFormFrame() {
        return formFrame;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Value evaluate(Expression expression) {
        return formFrame.evaluate(expression);
    }
}
