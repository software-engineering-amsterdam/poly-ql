package ql.questionaire.model.answer;

public class StringAnswer extends Answer {
	private String value;

	public StringAnswer() {
		value=null;
	}

	public StringAnswer(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public boolean isBool() {
		return false;
	}

	@Override
	public boolean isInt() {
		return false;
	}

	@Override
	public boolean isString() {
		return true;
	}

	@Override
	public boolean hasValue() {
		return value != null;
	}

	@Override
	public void clearAnswerValue() {
		value="";
	}
}
