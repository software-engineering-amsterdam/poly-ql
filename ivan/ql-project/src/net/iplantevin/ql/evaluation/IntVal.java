package net.iplantevin.ql.evaluation;

/**
 * @author Ivan
 */
public class IntVal extends Value {
    private final Integer value;

    public IntVal(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public Value add(Value argument) {
        return argument.intAdd(this);
    }

    @Override
    public Value sub(Value argument) {
        return argument.intSub(this);
    }

    @Override
    public Value mul(Value argument) {
        return argument.intMul(this);
    }

    @Override
    public Value div(Value argument) {
        return argument.intDiv(this);
    }

    @Override
    public Value geq(Value argument) {
        return argument.intGeq(this);
    }

    @Override
    public Value gt(Value argument) {
        return argument.intGt(this);
    }

    @Override
    public Value leq(Value argument) {
        return argument.intLeq(this);
    }

    @Override
    public Value lt(Value argument) {
        return argument.intLt(this);
    }

    @Override
    public Value neg() {
        return new IntVal(-value);
    }

    @Override
    public Value pos() {
        return this;
    }

    // Methods for double dispatch.
    // Note: order is reversed!! If val1.sub(val2) is called, this will result
    // in val2.intSub(val1), where val1 - val2 must actually be performed!
    @Override
    protected Value intAdd(IntVal argument) {
        return new IntVal(argument.getValue() + value);
    }

    @Override
    protected Value intSub(IntVal argument) {
        return new IntVal(argument.getValue() - value);
    }

    @Override
    protected Value intMul(IntVal argument) {
        return new IntVal(argument.getValue() * value);
    }

    @Override
    protected Value intDiv(IntVal argument) {
        return new IntVal(argument.getValue() / value);
    }

    @Override
    protected Value intGeq(IntVal argument) {
        return new BoolVal(argument.getValue() >= value);
    }

    @Override
    protected Value intGt(IntVal argument) {
        return new BoolVal(argument.getValue() > value);
    }

    @Override
    protected Value intLeq(IntVal argument) {
        return new BoolVal(argument.getValue() <= value);
    }

    @Override
    protected Value intLt(IntVal argument) {
        Value val = new BoolVal(argument.getValue() < value);
        return val;
    }


    @Override
    public boolean equals(Object object) {
        if (object instanceof IntVal) {
            Integer castedInt = ((IntVal) object).getValue();
            return value.equals(castedInt);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
