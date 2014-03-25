package net.iplantevin.ql.gui.formcomponents;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.evaluation.BoolVal;
import net.iplantevin.ql.gui.main.FormFrame;

/**
 * @author Ivan
 */
public class IfElseComponent extends ConditionalComponent {
    private final AbstractFormComponent elseBody;
    private static BoolVal FALSE = new BoolVal(false);

    public IfElseComponent(AbstractFormComponent ifBody,
                           AbstractFormComponent elseBody,
                           Expression condition, FormFrame frame) {
        super(ifBody, condition, frame);
        this.elseBody = elseBody;
        initUI();
    }

    @Override
    protected void initUI() {
        super.initUI();
        add(elseBody);
    }

    private void setElseBodyActive() {
        if (getValue().equals(FALSE)) {
            elseBody.setActive(true);
        } else {
            elseBody.setActive(false);
        }
    }

    @Override
    public void initValue() {
        super.initValue();
        setElseBodyActive();
    }

    @Override
    public void reEvaluate() {
        if (!isActive()) {
            return;
        }

        super.reEvaluate();
        setElseBodyActive();
    }

    @Override
    public void setActive(boolean active) {
        super.setActive(active);
        setElseBodyActive();
    }
}
