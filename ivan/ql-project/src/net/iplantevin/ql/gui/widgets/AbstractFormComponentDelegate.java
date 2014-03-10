package net.iplantevin.ql.gui.widgets;

import net.iplantevin.ql.evaluation.Value;

public interface AbstractFormComponentDelegate {
    public void subscribe(String identifier, AbstractFormComponent formComponent);

    public void registerValueChange(String identifier, Value value);
}
