package ql.questionaire.model.question;

import ql.questionaire.model.answer.Answer;

public class AnswerableQuestion extends QuestionModel {

	public AnswerableQuestion(String ident, String label, Answer answer) {
		super(ident,label,answer);
	}

	public String getLabel() {
		return label;
	}

	public boolean isEditable() {
		return true;
	}

}
