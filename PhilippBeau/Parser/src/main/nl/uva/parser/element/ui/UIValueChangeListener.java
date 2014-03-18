package main.nl.uva.parser.element.ui;

public interface UIValueChangeListener {

    public void onChange(boolean newValue);

    public void onChange(double newValue);

    public void onChange(String newValue);
}
