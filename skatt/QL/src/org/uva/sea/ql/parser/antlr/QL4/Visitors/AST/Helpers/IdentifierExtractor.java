package org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Helpers;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.ConditionalStructure;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.QLTree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.UnaryExpr;
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
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.NullValue;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Text;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.IQLVisitor;

/**
 * List<Identifier>his visitor will extract the (question) dependencies on a QL ASList<Identifier>.
 * Assumption: the AST it visites are only expressions
 * @author Sammie Katt
 *
 */
public class IdentifierExtractor implements IQLVisitor<List<Identifier>> {

	
	/** 
	 * Implementing form, question, struc, condition, but return null
	 * as the visitor does not expect to find any and should crash by return null
	 */
	@Override
	public List<Identifier> visit(Form form) {
		return null;
	}

	@Override
	public List<Identifier> visit(Question question) {
		return null;
	}

	@Override
	public List<Identifier> visit(Structures struc) {
		return null;
	}

	@Override
	public List<Identifier> visit(ConditionalStructure condition) {
		return null;
	}

	@Override
	public List<Identifier> visit(BraceExpr expr) {
		return getIds(expr);
	}

	@Override
	public List<Identifier> visit(NegExpr expr) {
		return getIds(expr);
	}

	@Override
	public List<Identifier> visit(GeqExpr expr) {
		return getIds(expr);
	}

	@Override
	public List<Identifier> visit(GreExpr expr) {
		return getIds(expr);
	}

	@Override
	public List<Identifier> visit(LeqExpr expr) {
		return getIds(expr);
	}

	@Override
	public List<Identifier> visit(LesExpr expr) {
		return getIds(expr);
	}

	@Override
	public List<Identifier> visit(PlusExpr expr) {
		return getIds(expr);
	}

	@Override
	public List<Identifier> visit(MinExpr expr) {
		return getIds(expr);
	}

	@Override
	public List<Identifier> visit(DivExpr expr) {
		return getIds(expr);
	}

	@Override
	public List<Identifier> visit(MultExpr expr) {
		return getIds(expr);
	}

	@Override
	public List<Identifier> visit(AndExpr expr) {
		return getIds(expr);
	}

	@Override
	public List<Identifier> visit(OrExpr expr) {
		return getIds(expr);
	}

	@Override
	public List<Identifier> visit(EqExpr expr) {
		return getIds(expr);
	}

	@Override
	public List<Identifier> visit(NeqExpr expr) {
		return getIds(expr);
	}

	@Override
	/**
	 * Actual magic happens here, if an identifier is found
	 * return it
	 */
	public List<Identifier> visit(Identifier id) {
		List<Identifier> ids = new ArrayList<Identifier>();
		ids.add(id);
		return ids;
	}

	/**
	 * Visiting unary expressions
	 */
	private List<Identifier> getIds(UnaryExpr expr) {
		List<Identifier> ids = new ArrayList<Identifier>();
		ids.addAll(visitChild(expr.getExpr()));
		return ids;
	}
	
	/**
	 * Visiting binary expressions here
	 */
	private List<Identifier> getIds(BinaryExpr expr) {
		List<Identifier> ids = new ArrayList<Identifier>();
		ids.addAll(visitChild(expr.getLHS()));
		ids.addAll(visitChild(expr.getRHS()));
		return ids;
	}
	
	/**
	 * Not interested in values or types 
	 */
	
	@Override
	public List<Identifier> visit(Bool bool) {
		return null;
	}

	@Override
	public List<Identifier> visit(Decimal dec) {
		return null;
	}

	@Override
	public List<Identifier> visit(NullValue nullValue) {
		return null;
	}

	@Override
	public List<Identifier> visit(Label label) {
		return null;
	}

	@Override
	public List<Identifier> visit(NumberType type) {
		return null;
	}

	@Override
	public List<Identifier> visit(BoolType type) {
		return null;
	}

	@Override
	public List<Identifier> visit(DateType type) {
		return null;
	}

	@Override
	public List<Identifier> visit(CurrencyType type) {
		return null;
	}

	@Override
	public List<Identifier> visit(NullType type) {
		return null;
	}

	@Override
	public List<Identifier> visit(StringType type) {
		return null;
	}

	@Override
	public List<Identifier> visit(Number number) {
		return null;
	}
	
	@Override
	public List<Identifier> visit(Text text) {
		return null;
	}
	
	/**
	 * Whenever children are visited, one should check
	 * whether the children themselves are not null,
	 * and neither their return
	 */
	public List<Identifier> visitChild(QLTree child) {
		List<Identifier> ids = null; 
		
		// if child is not null, visit
		if(child != null) {
			ids = child.accept(this);
		}
		
		// if resulting msgs are null, instantiate msgs as empty list
		if (ids == null) {
			ids = new ArrayList<Identifier>();
		}
		
		return ids;
	}

	
}
