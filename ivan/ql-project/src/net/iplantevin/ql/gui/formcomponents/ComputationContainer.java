package net.iplantevin.ql.gui.formcomponents;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.evaluation.Value;
import net.iplantevin.ql.gui.main.FormFrame;
import net.iplantevin.ql.gui.main.IdentifierGatherer;

import java.util.Set;

/**
 * @author Ivan
 */
public class ComputationContainer extends AbstractWidgetContainer {
    private final Expression expression;

    public ComputationContainer(String identifier, String labelText,
                                Expression expression, FormFrame frame) {
        super(identifier, labelText, frame);
        this.expression = expression;
        setWidget(new CompWidget(this));
        Set<String> identifiers = IdentifierGatherer.gather(expression);
        getFormFrame().subscribe(this, identifiers);
        initUI();
    }

    @Override
    public Value getValue() {
        if (super.getValue() == null) {
            // Value needs to be calculated. Only the case when this computation
            // is active for the first time.
            Value value = getFormFrame().evaluate(expression);
            setValue(value);
        }
        return super.getValue();
    }

    @Override
    public void setValue(Value value) {
        super.setValue(value);
        ((IWidget) getWidget()).setJComponentValue(value);
    }

    @Override
    public void reEvaluate() {
        if (!isActive()) {
            return;
        }
        Value value = getFormFrame().evaluate(expression);
        if (isNewExpressionValue(value)) {
            setValue(value);
            getFormFrame().registerValueChange(this, getValue());
        }
    }

    /**
     * Deals with the fact that two UndefinedValues would be deemed different.
     */
    private boolean isNewExpressionValue(Value value) {
        if (getValue().isUndefined() && value.isUndefined()) {
            return false;
        }
        return !getValue().equals(value);
    }
}
