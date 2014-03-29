package ql.ast.type;

import ql.ast.form.answer.AnswerComponent;
import ql.ast.value.Value;

public abstract class Type {
	public abstract String getName();
	public abstract Value getDefaultValue();
	public abstract AnswerComponent getAnswer();
	
	public boolean isDefined() {
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		return (obj.getClass().equals(this.getClass()));
	}
	
	public int hashCode() {
		return this.getClass().hashCode();
	}
}
