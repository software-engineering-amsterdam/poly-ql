package ql.gui.listener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author orosu
 */
public class DocumentInputListener implements DocumentListener
{
    private final InputListener _inputListener;

    public DocumentInputListener(InputListener inputListener)
    {
        this._inputListener = inputListener;
    }

    @Override
    public void changedUpdate(DocumentEvent arg0)
    {
        this._update();
    }

    @Override
    public void insertUpdate(DocumentEvent arg0)
    {
        this._update();
    }

    @Override
    public void removeUpdate(DocumentEvent arg0)
    {
        this._update();
    }

    private void _update()
    {
        this._inputListener.evaluateInterpretExpression();
    }
}
