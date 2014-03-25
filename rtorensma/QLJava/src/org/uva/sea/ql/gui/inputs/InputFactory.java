package org.uva.sea.ql.gui.inputs;

import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.ast.types.Undefined;
import org.uva.sea.ql.eval.ValueEnvironment;

public class InputFactory implements TypeVisitor<Input, InputFactoryArgumentObject> {
	public static Input inputForQuestion(Question question, boolean isComputed, ValueEnvironment valueEnv) {
		final InputFactoryArgumentObject arg = new InputFactoryArgumentObject(question, valueEnv, isComputed);
		return question.getType().accept(new InputFactory(), arg);
	}
	
	@Override
	public Input visit(Bool type, InputFactoryArgumentObject arg) {
		return new BoolInput(arg.getQuestion(), arg.getValueEnv(), arg.isComputed());
	}

	@Override
	public Input visit(Int type, InputFactoryArgumentObject arg) {
		return new IntInput(arg.getQuestion(), arg.getValueEnv(), arg.isComputed());
	}

	@Override
	public Input visit(Str type, InputFactoryArgumentObject arg) {
		return new StrInput(arg.getQuestion(), arg.getValueEnv(), arg.isComputed());
	}

	@Override
	public Input visit(Undefined type, InputFactoryArgumentObject arg) {
		// TODO Auto-generated method stub
		return null;
	}
}
