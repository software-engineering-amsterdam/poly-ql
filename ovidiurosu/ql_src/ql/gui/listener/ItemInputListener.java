package ql.gui.listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author orosu
 */
public class ItemInputListener implements ItemListener
{
    private final InputListener _inputListener;

    public ItemInputListener(InputListener inputListener)
    {
        this._inputListener = inputListener;
    }

    @Override
    public void itemStateChanged(ItemEvent arg0)
    {
        this._inputListener.evaluateInterpretExpression();
    }
}
