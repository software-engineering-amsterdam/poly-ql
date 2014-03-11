package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Conditional;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.UnaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiLogicExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.BiMathExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.EqualityExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Decimal;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.QuestionType;
import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;

/**
 * Interface for visitors. Visitors must visit AST classes
 * @author Sammie Katt
 *
 */
public interface IQLVisitor {

	///// All the visit functions necessary for a visitor to operate
	
	// upper level ast nodes
	public List<QLErrorMsg> visit(Form form);
	public List<QLErrorMsg> visit(Question question);
	public List<QLErrorMsg> visit(Structures struc);
	public List<QLErrorMsg> visit(Conditional condition);
	
	// expression nodes
	public List<QLErrorMsg> visit(UnaryExpr expr);
	public List<QLErrorMsg> visit(BiLogicExpr expr);
	public List<QLErrorMsg> visit(BiMathExpr expr);
	public List<QLErrorMsg> visit(EqualityExpr expr);
	
	// value nodes
	public List<QLErrorMsg> visit(Identifier id);
	public List<QLErrorMsg> visit(Bool bool);
	public List<QLErrorMsg> visit(Decimal dec);
	public List<QLErrorMsg> visit(Label label);
	public List<QLErrorMsg> visit(Number number);
	public List<QLErrorMsg> visit(QuestionType type);
}
