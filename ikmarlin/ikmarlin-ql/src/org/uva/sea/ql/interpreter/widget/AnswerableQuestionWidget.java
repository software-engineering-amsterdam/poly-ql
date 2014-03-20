package org.uva.sea.ql.interpreter.widget;

import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.ast.type.Int;
import org.uva.sea.ql.ast.type.Null;
import org.uva.sea.ql.ast.type.Str;
import org.uva.sea.ql.ast.type.Undefined;
import org.uva.sea.ql.interpreter.value.Value;
import org.uva.sea.ql.interpreter.visitor.ITypeVisitor;

public class AnswerableQuestionWidget implements ITypeVisitor<Widget> {
	
	Question question;
	Value<?> value;
	Widget inputField;
	
	public AnswerableQuestionWidget(Question question, Value<?> value){
		this.question = question;
		this.value = value;
		this.inputField = question.getType().accept(this);
	}

	public AnswerableQuestionWidget(Question question){
		this.question = question;
		this.value = new org.uva.sea.ql.interpreter.value.Undefined();
		this.inputField = question.getType().accept(this);
	}

	public Widget getWidget() {
		return inputField;
	}

	@Override
	public Widget visit(Bool type) {
		return new BoolInput(question, value);
	}

	@Override
	public Widget visit(Str type) {
		return new StrInput(question, value);
	}

	@Override
	public Widget visit(Int type) {
		return new IntInput(question, value);
	}

	@Override
	public Widget visit(Undefined type) {
		throw new UnsupportedOperationException("at: undefined widget");
	}

	@Override
	public Widget visit(Null type) {
		throw new UnsupportedOperationException("at: null widget");
	}

}
