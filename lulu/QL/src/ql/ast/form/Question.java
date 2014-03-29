package ql.ast.form;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ql.ast.environment.Environment;
import ql.ast.expr.exprType.Ident;
import ql.ast.form.answer.AnswerComponent;
import ql.ast.type.Type;
import ql.ast.message.Error;

public class Question extends FormItems{
	private final Ident ident;
	private final String question;
	private final Type type;
	private final JLabel questionLabel;
	private final AnswerComponent answerComponent;
	
	public Question(Ident ident, String question, Type type){
		this.ident = ident;
		this.question = question;
		this.type = type;
		this.answerComponent = type.getAnswer();
		this.questionLabel = new JLabel(question.substring(1, question.length()-1));
		super.question = question;
	}

	public Ident getIdent() {
		return ident;
	}

	public String getQuestion() {
		return question;
	}

	public Type getType() {
		return type;
	}
	
	public JLabel getQuestionLabel() {
		return questionLabel;
	}

	public AnswerComponent getAnswerComponent() {
		return answerComponent;
	}
	
	@Override
	public boolean validate(Environment environment) {
		if (environment.containsType(ident)) {
			if (!(environment.getType(ident).equals(type))) {
				errors.add(new Error("Question " + ident.id + "is already defined with other type!"));
			}
		}
		else{ 
			environment.addType(ident, type);
		}		
		
		return errors.size() == 0;
	}

	@Override
	public void buildForm(JPanel panel, Environment environment, Form form) {
		panel.add(questionLabel);
		panel.add(answerComponent.getAnswerField(true, environment, form, ident), "span");
	}

	@Override
	public void setVisible(Boolean visible) {
		questionLabel.setVisible(visible);
		answerComponent.setVisible(visible);
	}

	@Override
	public void eval(Environment environment) {
	}
	
}
