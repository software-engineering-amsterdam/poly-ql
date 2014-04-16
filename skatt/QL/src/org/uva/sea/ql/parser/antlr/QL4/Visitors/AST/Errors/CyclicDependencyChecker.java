package org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.uva.sea.ql.parser.antlr.QL4.AST.ConditionalStructure;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.Messages.CyclicDependencyError;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.QLErrorVisitor;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Helpers.IdentifierExtractor;

/**
 * This QLTree visitor will check for cyclic dependencies and return
 * a list of errors indicating the presence of them.
 * @author Sammie Katt
 *
 */
public class CyclicDependencyChecker extends QLErrorVisitor {

	/**
	 * Holds, for each question visited, a list of dependencies
	 */
	private Map<Identifier, Set<Identifier>> dependencies = new HashMap<Identifier, Set<Identifier>>();
	
	/**
	 * Previous dependencies, used to return to whenever done visiting
	 */
	private Set<Identifier> prevDependencies = new HashSet<Identifier>();
	
	/**
	 * Current dependencies. When visiting in the tree, this will maintain the dependencies in the
	 * current node of the tree
	 */
	private Set<Identifier> curDependencies = new HashSet<Identifier>();
	
	/**
	 * Visitor used for finding IDs in expressions
	 */
	private IdentifierExtractor idExtractor = new IdentifierExtractor();
	
	/**
	 * The visitor will traverse through the form and register the dependencies. 
	 * Afterwards, when these dependencies are collected, warnings will be generated
	 */
	public List<QLErrorMsg> visit(Form form) {
		visitChild(form.getStructures());
		
		return checkDependencies();
	}
	
	/**
	 * In this function, the if and else if expressions will be visited to find
	 * any dependencies. These identifiers will be added to the current list of 
	 * dependencies (curDependencies), after which the structures are visited.
	 * 
	 * When the structures are visited, the dependencies are removed
	 */
	public List<QLErrorMsg> visit(ConditionalStructure struc) {
		prevDependencies = curDependencies;
		
		// gather dependencies
		List<Identifier> dependenciesFromExpressions = idExtractor.visitChild(struc.getIfExpression()); // from if expression
		
		for (Expression expr : struc.getElseIfExpr()) {
			dependenciesFromExpressions.addAll(idExtractor.visitChild(expr));
		}
		
		// depend on a question means depend on all its dependencies too, so expand
		dependenciesFromExpressions = expandDependencies(dependenciesFromExpressions);
		
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
	 * When dependent on question a, then include all
	 * questions that a depends on
	 */
	private List<Identifier> expandDependencies(List<Identifier> initDependencies) {
		List<Identifier> expandedDependencies = new ArrayList<Identifier>();
		
		// for each identifier in the list, add it and its own dependencies (if any)
		for (Identifier dependency : initDependencies) {
			expandedDependencies.add(dependency);
			if (this.dependencies.containsKey(dependency))
				expandedDependencies.addAll(this.dependencies.get(dependency));
		}
		
		return expandedDependencies;
	}
	
	@Override
	/**
	 * When visiting a question, simply add its identifier and current dependencies to the list of dependencies
	 * No further visiting is necessary.
	 */
	public List<QLErrorMsg> visit(Question question) {
		// use tmp as clone method
		Set<Identifier> tmp = new HashSet<Identifier>();
		tmp.addAll(curDependencies);
		
		dependencies.put(question.getIdentifier(), tmp);
		
		return null; // dummy
	}
	
	/**
	 * The actual checking and error generation is done here. The rest of the visitor
	 * is used for collecting dependencies.
	 * @return
	 */
	private List<QLErrorMsg> checkDependencies() {
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		
		for (Identifier keyID : dependencies.keySet()) {
			for (Identifier valueID : dependencies.get(keyID)) {
				// if a valueID of keyID is dependent on keyID, we have a cyclic dependency (ignore if valueID == keyID)
				if (dependencies.get(valueID).contains(keyID) && !(valueID.equals(keyID))) {
					CyclicDependencyError msg = new CyclicDependencyError(keyID, valueID); 
					if (!msgs.contains(msg)) {
						msgs.add(msg);
					}
				}
			}
		}
		return msgs;
	}
}
