package ql.gui.widget;

import ql.gui.input_listener.InputListenerLinker;

/**
 * @author orosu
 */
public interface IWidgetListener
{
    public InputListenerLinker getInputListenerLinker();
    public void attachInputListener();
}
