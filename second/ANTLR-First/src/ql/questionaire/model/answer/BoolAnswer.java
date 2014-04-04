package ql.questionaire.model.answer;

public class BoolAnswer extends Answer {
	private Boolean value;

	public BoolAnswer() {
		value=null;
	}

	public BoolAnswer(boolean value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value.toString();
	}

	@Override
	public boolean isBool() {
		return true;
	}

	@Override
	public boolean isInt() {
		return false;
	}

	@Override
	public boolean isString() {
		return false;
	}

	@Override
	public boolean hasValue() {
		return value != null;
	}

	@Override
	public void clearAnswerValue() {
		value=false;
	}
}
