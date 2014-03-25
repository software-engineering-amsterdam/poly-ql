package net.iplantevin.ql.gui.formcomponents;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.gui.main.FormFrame;

/**
 * @author Ivan
 */
public class IfComponent extends ConditionalComponent {
    public IfComponent(AbstractFormComponent ifBody, Expression condition,
                       FormFrame frame) {
        super(ifBody, condition, frame);
        super.initUI();
    }
}
