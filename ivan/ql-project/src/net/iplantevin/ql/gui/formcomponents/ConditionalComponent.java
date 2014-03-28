package net.iplantevin.ql.gui.formcomponents;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.evaluation.BoolVal;
import net.iplantevin.ql.evaluation.UndefinedVal;
import net.iplantevin.ql.evaluation.Value;
import net.iplantevin.ql.gui.main.FormFrame;
import net.iplantevin.ql.gui.main.IdentifierGatherer;

import javax.swing.*;
import java.util.Set;

/**
 * Listens to changes in the values in its condition and manages the activation
 * and deactivation of the AbstractFormComponents it contains.
 *
 * @author Ivan
 */
public abstract class ConditionalComponent extends AbstractFormComponent {
    private final AbstractFormComponent ifBody;
    private Expression condition;
    private static BoolVal TRUE = new BoolVal(true);

    /**
     * Constructs a ConditionalComponent.
     *
     * @param ifBody    the component of the if statement body.
     * @param condition the Expression of this if statement.
     * @param frame     the FormFrame to manage changes.
     */
    public ConditionalComponent(AbstractFormComponent ifBody, Expression condition,
                                FormFrame frame) {
        super(frame);
        this.ifBody = ifBody;
        this.condition = condition;
        subScribe();
    }

    private void subScribe() {
        Set<String> identifiers = IdentifierGatherer.gather(condition);
        getFormFrame().subscribe(this, identifiers);
    }

    protected void initUI() {
        setAlignmentY(TOP_ALIGNMENT);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(ifBody);
    }

    /**
     * Re-evaluates this ConditionalComponent if it is currently active.
     */
    @Override
    public void reEvaluate() {
        if (!isActive()) {
            return;
        }

        Value conditionValue = getFormFrame().evaluate(condition);
        if (isNewConditionValue(conditionValue)) {
            setValue(conditionValue);
            setIfBodyActive();
        }
    }

    /**
     * Handles the fact that two UndefinedVals are considered different.
     */
    private boolean isNewConditionValue(Value conditionValue) {
        if (getValue().isUndefined() && conditionValue.isUndefined()) {
            return false;
        }
        return !conditionValue.equals(getValue());
    }

    private void setIfBodyActive() {
        if (getValue().equals(TRUE)) {
            ifBody.setActive(true);
        } else {
            ifBody.setActive(false);
        }
    }

    @Override
    public void initValue() {
        Value conditionValue = getFormFrame().evaluate(condition);
        setValue(conditionValue);
        setIfBodyActive();
    }

    @Override
    protected void setActive(boolean active) {
        super.setActive(active);

        if (active) {
            reEvaluate();
        } else {
            setValue(new UndefinedVal());
            ifBody.setActive(false);
        }
    }
}
