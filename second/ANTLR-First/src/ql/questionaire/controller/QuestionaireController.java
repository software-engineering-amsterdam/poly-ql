package ql.questionaire.controller;

import java.util.List;
import java.util.Map;

import ql.ast.visitor.EnabledQuestionsCollecter;
import ql.ast.visitor.FixedQuestionValuesCollecter;
import ql.questionaire.model.QuestionaireModel;
import ql.questionaire.model.answer.Answer;
import ql.questionaire.model.question.QuestionModel;
import ql.questionaire.view.QuestionaireView;

public class QuestionaireController {
	private QuestionaireView view;
	private QuestionaireModel model;

	public QuestionaireController(QuestionaireView view, QuestionaireModel model) {
		this.view=view;
		this.model=model;		
	}

	public void refreshQuestionSet() {
		Map<String, Answer> answers = model.getQuestionAnswers();
		refreshEnabledQuestionSet(answers);
		refreshFixedQuestionsValues(answers);
		view.refreshLayout();
	}

	private void refreshFixedQuestionsValues(Map<String, Answer> answers) {
		Map<String, Answer> values = new FixedQuestionValuesCollecter().
				collect(answers, model.getAST());
		model.updateFixedQuestionsValues(values);
	}

	private void refreshEnabledQuestionSet(Map<String, Answer> answers) {
		List<String> list = new EnabledQuestionsCollecter().
				collect(answers, model.getAST());		
		model.updateEnabledQuestions(list);
	}

	public void updateQuestion(QuestionModel question, Answer newValue) {
		model.updateQuestion(question, newValue);
	}
}
