package ql.ast.type;

import ql.ast.form.answer.AnswerComponent;
import ql.ast.form.answer.StrComponent;
import ql.ast.value.Str;
import ql.ast.value.Value;

public class StrType extends Type{
	
	@Override
	public String getName() {
		return "Str";
	}

	@Override
	public Value getDefaultValue() {
		return new Str();
	}
	
	@Override
	public AnswerComponent getAnswer() {
		return new StrComponent();
	}
}
