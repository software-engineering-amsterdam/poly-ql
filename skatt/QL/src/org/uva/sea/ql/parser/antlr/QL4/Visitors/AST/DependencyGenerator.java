package org.uva.sea.ql.parser.antlr.QL4.Visitors.AST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.uva.sea.ql.parser.antlr.QL4.AST.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.QLTree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
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
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.ConditionalStructure;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Structures;
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
import org.uva.sea.ql.parser.antlr.QL4.Visitors.Visitor;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Helpers.IdentifierExtractor;

public class DependencyGenerator extends Visitor implements IQLVisitor<List<Identifier>> {
	// the real dependencies
	private Map<Identifier, Set<Identifier>> dependencies = new HashMap<Identifier, Set<Identifier>>();
		
	// holds all the current dependencies
	private Set<Identifier> curDependencies = new HashSet<Identifier>();
	
	// holds all the previous dependencies (return to this after visiting child)
	private Set<Identifier> prevDependencies = new HashSet<Identifier>();
	
	// visitor used for extracting ids from an expression
	private IdentifierExtractor idExtractor = new IdentifierExtractor();
	
	/**
	 * Creates listeners from the depencencies and returns these 
	 */
	public Map<Identifier, Set<Identifier>> recoverListeners() {
		Map<Identifier, Set<Identifier>> listeners = new HashMap<Identifier, Set<Identifier>>();
		
		// dependencies:= listener -> listened. So loop over them all and create: listened -> listeners
		for (Map.Entry<Identifier, Set<Identifier>> entry : dependencies.entrySet()) {
			Identifier listened = entry.getKey();
			
			// for each listener, check if entry already exists (if not create one)
			for (Identifier listener: entry.getValue()) {
				if (listeners.containsKey(listener))
					listeners.get(listener).add(listened);
				else 
					listeners.put(listener, new HashSet<Identifier>(Arrays.asList(listened)));
			}
		}

		return listeners;
	}
	
	/**
	 * Each visited child is handled through this function
	 * Conducts checks on null
	 */
	private List<Identifier> visitChild(QLTree child) {
		List<Identifier> identifiers = null; 
		
		// if child is not null, visit
		if(child != null) {
			identifiers = child.accept(this);
		}
		
		// if resulting questions are null, instantiate questions as empty list
		if (identifiers == null) {
			identifiers = new ArrayList<Identifier>();
		}
		
		return identifiers;
	}
	
	/**
	 * Visit functions. Visits all higher level nodes:
	 * - form
	 * - structures
	 * - conditional structure
	 */
	@Override
	public List<Identifier> visit(Form form) {
		return visitChild(form.getStructures());
	}

	@Override
	public List<Identifier> visit(Structures struc) {
		List<Identifier> identifiers = new ArrayList<Identifier>();
		List<QLTree> structures = struc.getStructures();

		// loop over all structure children of a structures
		for (QLTree structure : structures) {
			identifiers.addAll(this.visitChild(structure));
		}
		
		return identifiers;
	}

	@Override
	public List<Identifier> visit(ConditionalStructure struc) {
		prevDependencies = curDependencies;
		
		// gather dependencies
		List<Identifier> dependenciesFromExpressions = idExtractor.visitChild(struc.getIfExpression()); // from if expression
		
		for (Expression expr : struc.getElseIfExpr()) {
			dependenciesFromExpressions.addAll(idExtractor.visitChild(expr));
		}
		
		// add to current dependencies
		curDependencies.addAll(dependenciesFromExpressions);

		// visit all structures
		visitChild(struc.getIfStructures());
		
		for (Structures structures : struc.getElseIfStructs()) {
			visitChild(structures);
		}
		
		visitChild(struc.getElseStruct());
		
		// done visiting, get previous dependencies
		curDependencies = prevDependencies;
		
		return null; // dummy
	}

	/**
	 * Visiting question: all current dependencies are the dependencies of this question
	 */
	@Override
	public List<Identifier> visit(Question question) {
		// use tmp as clone method
		Set<Identifier> tmp = new HashSet<Identifier>();
		tmp.addAll(curDependencies);
		
		dependencies.put(question.getIdentifier(), tmp);
		
		return null; // dummy)
	}
	
	/////// Expressions, values and the like are not visited
	
	
	@Override
	public List<Identifier> visit(BraceExpr expr) {
		return null;
	}

	@Override
	public List<Identifier> visit(NegExpr expr) {
		return null;
	}

	@Override
	public List<Identifier> visit(GeqExpr expr) {
		return null;
	}

	@Override
	public List<Identifier> visit(GreExpr expr) {
		return null;
	}

	@Override
	public List<Identifier> visit(LeqExpr expr) {
		return null;
	}

	@Override
	public List<Identifier> visit(LesExpr expr) {
		return null;
	}

	@Override
	public List<Identifier> visit(PlusExpr expr) {
		return null;
	}

	@Override
	public List<Identifier> visit(MinExpr expr) {
		return null;
	}

	@Override
	public List<Identifier> visit(DivExpr expr) {
		return null;
	}

	@Override
	public List<Identifier> visit(MultExpr expr) {
		return null;
	}

	@Override
	public List<Identifier> visit(AndExpr expr) {
		return null;
	}

	@Override
	public List<Identifier> visit(OrExpr expr) {
		return null;
	}

	@Override
	public List<Identifier> visit(EqExpr expr) {
		return null;
	}

	@Override
	public List<Identifier> visit(NeqExpr expr) {
		return null;
	}

	@Override
	public List<Identifier> visit(Identifier id) {
		return null;
	}

	@Override
	public List<Identifier> visit(Bool bool) {
		return null;
	}

	@Override
	public List<Identifier> visit(Decimal dec) {
		return null;
	}

	@Override
	public List<Identifier> visit(Label label) {
		return null;
	}

	@Override
	public List<Identifier> visit(Number number) {
		return null;
	}

	@Override
	public List<Identifier> visit(NullValue nullValue) {
		return null;
	}

	@Override
	public List<Identifier> visit(BoolType boolType) {
		return null;
	}

	@Override
	public List<Identifier> visit(NumberType numberType) {
		return null;
	}

	@Override
	public List<Identifier> visit(DateType dateType) {
		return null;
	}

	@Override
	public List<Identifier> visit(CurrencyType currencyType) {
		return null;
	}

	@Override
	public List<Identifier> visit(NullType nullType) {
		return null;
	}

	@Override
	public List<Identifier> visit(StringType stringType) {
		return null;
	}

	@Override
	public List<Identifier> visit(Text text) {
		return null;
	}
}
