package edu.uva.softwarecons.model.value;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/13/14
 */
public class BooleanValue implements Value{

    private final boolean value;

    public BooleanValue(boolean value) {
        this.value = value;
    }


    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        return ((BooleanValue) obj).value == this.value;
    }

    public BooleanValue and(Value value){
        return new BooleanValue(this.value && Boolean.parseBoolean(value.getValue()));
    }

    public BooleanValue or(Value value){
        return new BooleanValue(this.value || Boolean.parseBoolean(value.getValue()));
    }

    public BooleanValue not(){
        return new BooleanValue(!this.value);
    }



}
