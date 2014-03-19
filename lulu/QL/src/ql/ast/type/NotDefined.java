package ql.ast.type;

import ql.ast.form.answer.AnswerComponent;
import ql.ast.value.Value;

public class NotDefined extends Type{

	@Override
	public String getName() {
		return "NotDefined";
	}

	@Override
	public Value getDefaultValue() {
		return null;
	}
	
	public boolean isDefined() {
		return false;
	}

	@Override
	public AnswerComponent getAnswer() {
		return null;
	}
}
