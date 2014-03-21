package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import org.uva.sea.ql.parser.antlr.QL4.AST.ConditionalStructure;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
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
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.BoolType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.CurrencyType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.DateType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NullType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.NumberType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Types.StringType;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Decimal;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Text;

/**
 * Interface for visitors. Visitors must visit AST classes
 * @author Sammie Katt
 *
 */
public interface IQLVisitor<T> {

	///// All the visit functions necessary for a visitor to operate
	
	// upper level ast nodes
	public T visit(Form form);
	public T visit(Question question);
	public T visit(Structures struc);
	public T visit(ConditionalStructure condition);
	
	// unary expression nodes
	public T visit(BraceExpr expr);
	public T visit(NegExpr expr);
	
	// binary relation expression nodes
	public T visit(GeqExpr expr);
	public T visit(GreExpr expr);
	public T visit(LeqExpr expr);
	public T visit(LesExpr expr);
	
	// binary mathematical expression nodes
	public T visit(PlusExpr expr);
	public T visit(MinExpr expr);
	public T visit(DivExpr expr);
	public T visit(MultExpr expr);
	
	// binary logical expression nodes
	public T visit(AndExpr expr);
	public T visit(OrExpr expr);
	
	// binary equality expression nodes
	public T visit(EqExpr expr);
	public T visit(NeqExpr expr);
	
	// value nodes
	public T visit(Identifier id);
	public T visit(Bool bool);
	public T visit(Decimal dec);
	public T visit(Label label);
	public T visit(Number number);
	
	// types
	public T visit(BoolType boolType);
	public T visit(NumberType numberType);
	public T visit(DateType dateType);
	public T visit(CurrencyType currencyType);
	public T visit(NullType nullType);
	public T visit(StringType stringType);
	public T visit(Text text);
}
