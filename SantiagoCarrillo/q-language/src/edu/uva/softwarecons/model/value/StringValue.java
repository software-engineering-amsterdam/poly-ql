package edu.uva.softwarecons.model.value;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public class StringValue implements Value{

    private final String value;

    public StringValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
