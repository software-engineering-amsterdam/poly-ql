package net.iplantevin.ql.gui.formcomponents;

import net.iplantevin.ql.evaluation.Value;
import net.iplantevin.ql.gui.main.FormFrame;

import javax.swing.*;

/**
 * Top level of the JPanel hierarchy from which the elements of a form are
 * created. Its subtypes are the AbstractWidgetContainer, the ConditionalComponent and the
 * ContainerComponent.
 * <p/>
 * An AbstractFormComponent can be active or inactive. An active component is
 * displayed and will react to events from the FormFrame that created it and
 * will notify that frame.
 * <p/>
 * It contains a reference to the FormFrame that created it to manage notifications
 * and subscriptions.
 *
 * @author Ivan
 */
public abstract class AbstractFormComponent extends JPanel {
    private boolean active = true;
    private final FormFrame formFrame;
    private Value value = null;

    /**
     * Constructs an AbstractFormComponent with a reference to a FormFrame.
     */
    public AbstractFormComponent(FormFrame formFrame) {
        this.formFrame = formFrame;
    }

    /**
     * Must be implemented by concrete subtypes. Should be used to update value
     * etc. e.g. when an identifier that this component is subscribed to changed
     * its value.
     */
    public abstract void reEvaluate();

    /**
     * Used for initialization of the value. Should not trigger an event on an
     * event manager.
     */
    public abstract void initValue();

    /**
     * Concrete subtypes are responsible for performing the necessary actions
     * when the state changes, apart from setting the active value and visibility.
     *
     * @param active whether this component should be active or not.
     */
    protected void setActive(boolean active) {
        this.active = active;
        setVisible(active);
    }

    public boolean isActive() {
        return active;
    }

    protected FormFrame getFormFrame() {
        return formFrame;
    }

    public Value getValue() {
        return value;
    }

    protected void setValue(Value value) {
        this.value = value;
    }
}
