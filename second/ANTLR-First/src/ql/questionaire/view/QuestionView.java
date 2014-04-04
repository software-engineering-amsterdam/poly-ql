package ql.questionaire.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import ql.questionaire.controller.QuestionaireController;
import ql.questionaire.model.answer.Answer;
import ql.questionaire.model.question.QuestionModel;
import ql.questionaire.view.events.NumberTextBoxSelection;
import ql.questionaire.view.events.StringTextBoxSelection;
import ql.questionaire.view.observer.EnabledStateObserver;

public class QuestionView implements EnabledStateObserver {
	private QuestionModel question;
	private Group group;
	private QuestionaireController controller;

	public QuestionView(QuestionModel q, QuestionaireController controller, Composite parent) {
		this.question=q;
		this.controller=controller;

		group = new Group(parent, SWT.NONE);
		group.setLayout(new RowLayout());
		setEnabled(false);

		drawLabel(question.getLabel());
		Answer answer = question.getAnswer();
		String value=null;
		if(answer.hasValue())
			value=answer.getValue();
		if (answer.isBool()) this.drawTrueFalseButtons(value);
		if (answer.isInt()) this.drawNumericText(value);
		if(answer.isString()) this.drawStringText(value);	

		question.addEnabledStateObserver(this);
	}

	public String getQuestionIdent() {
		return question.getIdent();
	}

	public void setEnabled(boolean b) {
		if(b==true)
			display();
		else
			hide();
	}

	private void hide() {
		group.setVisible(false);
		RowData rowData = new RowData();
		rowData.exclude=true;
		group.setLayoutData(rowData);
	}

	private void display() {
		group.setLayoutData(new RowData());
		group.setVisible(true);
	}

	private void drawTrueFalseButtons(String text) {	
		QRadioButtons buttons= new QRadioButtons(
				question.isEditable(), group, this);
		question.addValueObserver(buttons);
	}

	private void drawLabel(String text) {
		Label label = new Label(group, SWT.NONE);
		if(text!=null)
			label.setText(text);
	}

	private void drawNumericText(String value) {
		Text text =  createStandardTextBox();
		text.setSize(0, 100);

		if(question.isEditable()) {
			text.addSelectionListener(new NumberTextBoxSelection(this,text));
		} 
		else {
			text.setEditable(false);
		}

		TextLabel label = new TextLabel(text);
		question.addValueObserver(label);
	}

	private Text createStandardTextBox() {
		return new Text(group,SWT.FILL);
	}

	private void drawStringText(String value) {
		Text text =  createStandardTextBox();
		text.setSize(0, 100);

		if(question.isEditable()) {
			text.addSelectionListener( new StringTextBoxSelection(this,text));
		} 
		else {
			text.setEditable(false);
		}
		TextLabel label = new TextLabel(text);
		question.addValueObserver(label);
	}

	public void updateValue(Answer newValue) {
		question.setAnswer(newValue);
		controller.updateQuestion(question,newValue);
		controller.refreshQuestionSet();
	}
}
