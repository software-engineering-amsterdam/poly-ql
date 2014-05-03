package org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel;

import org.uva.sea.ql.parser.antlr.QL4.AST.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.QLTree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.Type;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.IQLVisitor;

/**
 * Abstract syntax tree of the regQuestion construct in the QL4 grammar
 * Contains a id, type, label and value 
 * 
 * @author Sammie Katt
 */

public class Question implements QLTree {
	final private boolean computed;
	final private Identifier id; 
	final private Label label;
	final private Type type;
	private Expression value;
	
	/**
	 * Constructor, Sets the id, label and type
	 * Additionally, sets computed to false
	 */
	public Question(Identifier id, Label label, Type type) {
		this.computed = false;
		this.id = id;
		this.label = label;
		this.type = type;
	}
	
	public Question(Identifier id, Label label, Type type, Expression value) {
		this.computed = true;
		this.id = id;
		this.label = label;
		this.type = type;
		this.value = value;
	}
	
	public String toString() {
		return "Question " + id + " of type " + type + " and label " + label;
	}
	
	@Override
	public <T> T accept(IQLVisitor<T> visitor) {
		return visitor.visit(this);
	}

	////////////// getters
	
	public Identifier getIdentifier() {
		return id;
	}

	public Label getLabel() {
		return label;
	}

	public Type getType() {
		return type;
	}

	public Expression getValue() {
		return value;
	}
	
	public Boolean isComputed() {
		return computed;
	}
}
