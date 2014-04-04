package ql.questionaire.model.answer;

public abstract class Answer {

	public abstract String getValue();
	public abstract void clearAnswerValue();

	public abstract boolean isBool();
	public abstract boolean isInt();
	public abstract boolean isString();

	public abstract boolean hasValue();
}
