package org.uva.sea.ql.interpreter.value;

import org.uva.sea.ql.ast.type.Type;

public abstract class Num<T> extends Value<T> {

	public abstract Value<?> parse(Type type);

	protected abstract Value<?> parse(Int value);

	protected abstract Value<?> parse(Undefined value);
	
	public abstract Value<?> add(Value<?> value);

	public abstract Value<?> sub(Value<?> value);

	public abstract Value<?> mul(Value<?> value);

	public abstract Value<?> div(Value<?> value);

	public abstract Value<?> pos();

	public abstract Value<?> neg();

	public abstract Value<?> lt(Value<?> value);

	public abstract Value<?> leq(Value<?> value);

	public abstract Value<?> gt(Value<?> value);

	public abstract Value<?> geq(Value<?> value);

	public abstract Value<?> eq(Value<?> value);

	public abstract Value<?> neq(Value<?> value);

	protected abstract Value<?> intAdd(Int leftValue);

	protected abstract Value<?> intSub(Int leftValue);

	protected abstract Value<?> intMul(Int leftValue);

	protected abstract Value<?> intDiv(Int leftValue);

	protected abstract Value<?> intLt(Int leftValue);

	protected abstract Value<?> intLeq(Int leftValue);

	protected abstract Value<?> intGt(Int leftValue);

	protected abstract Value<?> intGeq(Int leftValue);

	protected abstract Value<?> intEq(Int value);

	protected abstract Value<?> intNeq(Int value);

}