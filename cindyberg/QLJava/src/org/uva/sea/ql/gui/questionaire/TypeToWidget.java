package org.uva.sea.ql.gui.questionaire;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.TypeVisitor;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.IntegerType;
import org.uva.sea.ql.ast.type.MissingType;
import org.uva.sea.ql.ast.type.StringType;
import org.uva.sea.ql.gui.widget.BooleanWidget;
import org.uva.sea.ql.gui.widget.Widget;
import org.uva.sea.ql.gui.widget.IntegerWidget;
import org.uva.sea.ql.gui.widget.StringWidget;

public class TypeToWidget implements TypeVisitor<Widget> {

	private final Identifier identifier;
	private final State state;
	
	public TypeToWidget(Identifier identifier, State state){
		this.identifier = identifier;
		this.state = state;
	}
	
	public Widget visit(IntegerType type) {
		return new IntegerWidget(identifier, state);
	}

	public Widget visit(StringType type) {
		return new StringWidget(identifier, state);
	}

	public Widget visit(BooleanType booleanType) {
		return new BooleanWidget(identifier,state);
	}

	public Widget visit(MissingType missingType) {
		throw new UnsupportedOperationException();
	}

}
