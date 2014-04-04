package ql.questionaire.model.answer;

public class IntAnswer extends Answer {
	private Integer value;

	public IntAnswer() {
		value=null;
	}

	public IntAnswer(int value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value.toString();
	}

	@Override
	public boolean isBool() {
		return false;
	}

	@Override
	public boolean isInt() {
		return true;
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
		value=0;
	}

}
