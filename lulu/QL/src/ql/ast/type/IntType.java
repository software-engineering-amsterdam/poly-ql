package ql.ast.type;

import ql.ast.form.answer.AnswerComponent;
import ql.ast.form.answer.IntComponent;
import ql.ast.value.Int;
import ql.ast.value.Value;

public class IntType extends Type{

	@Override
	public String getName() {
		return "Int";
	}

	@Override
	public Value getDefaultValue() {
		return new Int();
	}

	@Override
	public AnswerComponent getAnswer() {
		return new IntComponent();
	}
}
