package ql.ast.type;

import ql.ast.form.answer.AnswerComponent;
import ql.ast.form.answer.BoolComponent;
import ql.ast.value.Bool;
import ql.ast.value.Value;

public class BoolType extends Type{

	@Override
	public String getName() {
		return "Bool";
	}

	@Override
	public Value getDefaultValue() {
		return new Bool();
	}

	@Override
	public AnswerComponent getAnswer() {
		return new BoolComponent();
	}

}
