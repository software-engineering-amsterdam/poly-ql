package org.uva.sea.ql.gui.questionaire;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.TypeVisitor;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MissingType;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.gui.widget.BooleanWidget;
import org.uva.sea.ql.gui.widget.Control;
import org.uva.sea.ql.gui.widget.IntegerWidget;
import org.uva.sea.ql.gui.widget.StringWidget;

public class TypeToWidget implements TypeVisitor<Control> {

	Identifier identifier;
	State state;
	
	public TypeToWidget(Identifier identifier, State state){
		this.identifier = identifier;
		this.state = state;
	}
	
	public Control visit(MoneyType moneyType) {
		return new IntegerWidget(identifier, state);
	}

	public Control visit(IntegerType type) {
		return new IntegerWidget(identifier, state);
	}

	public Control visit(StringType type) {
		return new StringWidget(identifier, state);
	}

	public Control visit(BooleanType booleanType) {
		return new BooleanWidget(identifier,state);
	}

	public Control visit(MissingType missingType) {
		throw new UnsupportedOperationException();
	}

}
