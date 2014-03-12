package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.ConditionalStructure;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Equality.EqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Equality.NeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical.AndExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical.OrExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.DivExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.MinExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.MultExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.PlusExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.GeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.GreExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.LeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Relational.LesExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary.BraceExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary.NegExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Decimal;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.QuestionType;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;

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
	public List<QLErrorMsg> visit(ConditionalStructure condition);
	
	// unary expression nodes
	public List<QLErrorMsg> visit(BraceExpr expr);
	public List<QLErrorMsg> visit(NegExpr expr);
	
	// binary relation expression nodes
	public List<QLErrorMsg> visit(GeqExpr expr);
	public List<QLErrorMsg> visit(GreExpr expr);
	public List<QLErrorMsg> visit(LeqExpr expr);
	public List<QLErrorMsg> visit(LesExpr expr);
	
	// binary mathematical expression nodes
	public List<QLErrorMsg> visit(PlusExpr expr);
	public List<QLErrorMsg> visit(MinExpr expr);
	public List<QLErrorMsg> visit(DivExpr expr);
	public List<QLErrorMsg> visit(MultExpr expr);
	
	// binary logical expression nodes
	public List<QLErrorMsg> visit(AndExpr expr);
	public List<QLErrorMsg> visit(OrExpr expr);
	
	// binary equality expression nodes
	public List<QLErrorMsg> visit(EqExpr expr);
	public List<QLErrorMsg> visit(NeqExpr expr);
	
	// value nodes
	public List<QLErrorMsg> visit(Identifier id);
	public List<QLErrorMsg> visit(Bool bool);
	public List<QLErrorMsg> visit(Decimal dec);
	public List<QLErrorMsg> visit(Label label);
	public List<QLErrorMsg> visit(Number number);
	public List<QLErrorMsg> visit(QuestionType type);
}
