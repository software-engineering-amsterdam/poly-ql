package org.uva.sea.ql.parser.antlr.QL4.AST;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.QuestionType;
import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.IQLVisitor;

/**
 * Abstract syntax tree of the regQuestion construct in the QL4 grammar
 * Contains a id, type, label and value 
 * 
 * TODO: May possibly be extended into several type of questions 
 * @author Sammie Katt
 *
 */
public class Question implements QLTree {
	final private boolean computed;
	final private Identifier id; 
	final private Label label;
	final private QuestionType type;
	private Expression value;
	
	/**
	 * Constructor, Sets the id, label and type
	 * Additionally, sets computed to false
	 * @param id
	 * @param label
	 * @param type
	 */
	public Question(Identifier id, Label label, QuestionType type) {
		this.computed = false;
		this.id = id;
		this.label = label;
		this.type = type;
	}
	
	public Question(Identifier id, Label label, QuestionType type, Expression value) {
		this.computed = true;
		this.id = id;
		this.label = label;
		this.type = type;
		this.value = value;
	}
	
	/**
	 * Returns the description of the question
	 */
	public String toString() {
		return "Question " + id + " of type " + type + " and label " + label;
	}
	
	public List<QLErrorMsg> accept(IQLVisitor visitor) {
		return visitor.visit(this);
	}
}
