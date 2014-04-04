package ql.questionaire.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ql.ast.node.syntactic.Form;
import ql.questionaire.model.answer.Answer;
import ql.questionaire.model.question.QuestionModel;

public class QuestionaireModel {
	private List<QuestionModel> questions;
	private Form ast;

	public QuestionaireModel(List<QuestionModel> questions, Form ast) {
		this.ast=ast;
		this.questions=questions;
	}

	public Map<String, Answer> getQuestionAnswers() {
		Map<String,Answer> map=new HashMap<>();
		for(QuestionModel q :questions) {
			Answer a=q.getAnswer();
			if(a.hasValue())
				map.put(q.getIdent(), a);
		}
		return map;
	}

	public Form getAST() {
		return ast;
	}

	public void updateQuestion(QuestionModel question, Answer newValue) {
		for(QuestionModel q: questions) {
			if(q.getIdent().equals(question.getIdent()))
				q.setAnswer(newValue);
		}
	}

	public void updateEnabledQuestions(List<String> map) {
		for(QuestionModel q : questions) {
			if(map.contains(q.getIdent()))
				q.setEnabled(true);
			else
				q.setEnabled(false);
		}
	}

	public void updateFixedQuestionsValues(Map<String, Answer> values) {
		for(QuestionModel q : questions) 
			if(! q.isEditable()) {
				Answer a = values.get(q.getIdent());
				if(a!=null)
					q.setAnswer(a);
				else
					q.clearAnswerValue();
			}
	}
}
