package org.uva.sea.ql.interpreter.widget;

import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.interpreter.value.Value;

public class ComputedQuestionWidget {
	
	Question question;
	Value<?> value;
	
	public ComputedQuestionWidget(Question question, Value<?> value){
		this.question = question;
		this.value = value;
	}

	public Widget getWidget() {
		return new Label(question, value);
	}

}
