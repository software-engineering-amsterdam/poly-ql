package net.iplantevin.ql.gui.widgets;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.gui.main.FormFrame;

import javax.swing.*;
import java.util.List;

/**
 * Listens to changes in the values in its condition and manages the activation
 * and deactivation of the AbstractFormComponents it contains.
 *
 * @author Ivan
 */
public class IfElseComponent extends AbstractFormComponent {
    private final JPanel ifBody;
    private final JPanel elseBody;
    private final Expression condition;

    public IfElseComponent(List<AbstractFormComponent> ifBody, Expression condition,
                           FormFrame frame) {
        super(frame);
        this.ifBody = buildBody(ifBody);
        this.elseBody = null;
        this.condition = condition;
    }

    public IfElseComponent(List<AbstractFormComponent> ifBody,
                           List<AbstractFormComponent> elseBody,
                           Expression condition, FormFrame frame) {
        super(frame);
        this.ifBody = buildBody(ifBody);
        this.elseBody = buildBody(elseBody);
        this.condition = condition;
    }

    private JPanel buildBody(List<AbstractFormComponent> ifBody) {
        return null;
    }

    @Override
    public void reEvaluate() {
    }

    @Override
    protected void setActive(boolean active) {
    }
}
