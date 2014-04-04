package ql.questionaire.model.question;

import java.util.LinkedList;
import java.util.List;

import ql.questionaire.model.answer.Answer;
import ql.questionaire.view.observer.EnabledStateObserver;
import ql.questionaire.view.observer.ValueObserver;


public abstract class QuestionModel   {
	protected String ident; 
	protected String label;
	protected Answer answer;
	protected boolean isEnabled;

	protected List<ValueObserver> valueObservers;
	protected List<EnabledStateObserver> enabledStateObservers;

	public QuestionModel(String ident, String label, Answer answer) {
		this.ident = ident;
		this.label = label;
		this.answer = answer;
		this.isEnabled = false;

		this.valueObservers = new LinkedList<>();
		this.enabledStateObservers = new LinkedList<>();
	}

	public String getLabel() {
		return label;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setEnabled(boolean b) {
		if(b!=isEnabled) {
			isEnabled=b;
			notifyViewObservers();
		}
	}

	private void notifyViewObservers() {
		for(EnabledStateObserver o : enabledStateObservers)
			o.setEnabled(isEnabled);
	}

	public abstract boolean isEditable();

	public boolean hasAnswer() {
		return answer.hasValue();
	}

	public void setAnswer(Answer answer) {
		this.answer=answer;
		notifyObserversOfNewValue();
	}

	private void notifyObserversOfNewValue() {
		for(ValueObserver o : valueObservers)
			o.setNewValue(answer.getValue());
	}

	public String getIdent() {
		return ident;
	}

	public void addValueObserver(ValueObserver o) {
		valueObservers.add(o);
	}

	public void addEnabledStateObserver(EnabledStateObserver o) {
		enabledStateObservers.add(o);
	}

	public void clearAnswerValue() {		
		answer.clearAnswerValue();
		notifyObserversOfFieldCleared();
	}

	private void notifyObserversOfFieldCleared() {
		for(ValueObserver o : valueObservers)
			o.clearValue();
	}
}
