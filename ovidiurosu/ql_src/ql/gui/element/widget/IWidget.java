package ql.gui.element.widget;

import ql.gui.element.IGuiElement;

/**
 * @author orosu
 */
public interface IWidget extends IGuiElement
{
    public void setBooleanValue(boolean value);
    public void setStringValue(String value);
    public void setNullValue();

    public void hide();
}
