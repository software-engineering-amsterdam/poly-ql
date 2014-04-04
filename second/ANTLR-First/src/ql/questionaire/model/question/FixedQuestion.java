package ql.questionaire.model.question;

import ql.questionaire.model.answer.Answer;

public class FixedQuestion extends QuestionModel {

	public FixedQuestion(String ident, String label, Answer answer) {
		super(ident, label, answer);
	}

	public boolean isEditable() {
		return false;
	}

}
