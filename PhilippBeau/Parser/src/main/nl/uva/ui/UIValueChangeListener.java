package main.nl.uva.ui;

public interface UIValueChangeListener {

    public void onChange(boolean newValue);

    public void onChange(double newValue);

    public void onChange(String newValue);
}
