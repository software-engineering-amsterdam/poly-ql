package ql.gui.widget;


/**
 * @author orosu
 */
public interface IWidget
{
    public void setBooleanValue(boolean value);
    public void setStringValue(String value);
    public void setNullValue();

    public void hide();
}
