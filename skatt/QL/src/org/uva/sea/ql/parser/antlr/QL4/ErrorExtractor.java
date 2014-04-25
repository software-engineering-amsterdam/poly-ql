package org.uva.sea.ql.parser.antlr.QL4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.HighLevel.Question;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.QLErrorGenerator;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors.BoolConditionChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors.CyclicDependencyChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors.DuplicateLabelChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors.DuplicateQuestionChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors.InvalidTypeChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Errors.UndefQuestionChecker;
import org.uva.sea.ql.parser.antlr.QL4.Visitors.AST.Helpers.QuestionExtractor;

/**
 * Uses visitors to check for errors in a form
 * @author Sammie Katt
 */
public class ErrorExtractor {

	/**
	 * Checks a form for errors and warnings by visiting
	 * the form with several visitors 
	 */
	public List<QLErrorMsg> getErrors(Form ast) {
		// holds all errors and warning msgs generated
		List<QLErrorMsg> msgs = new ArrayList<QLErrorMsg>();
		
		// the checker that will perform several checks on our ast input 
		QLErrorGenerator ASTChecker;
		QuestionExtractor extract = new QuestionExtractor();
		
		/**
		 * Questions is a map of identifier -> question
		 * This is necessary for checkers that need to know something
		 * about the question an identifier is referring to
		 */
		Map<Identifier, Question> questions = extract.visit(ast);
		
		ASTChecker = new UndefQuestionChecker();
		msgs.addAll(ASTChecker.visit(ast));
		
		ASTChecker = new DuplicateLabelChecker();
		msgs.addAll(ASTChecker.visit(ast));
		
		ASTChecker = new DuplicateQuestionChecker();
		msgs.addAll(ASTChecker.visit(ast));
		
		ASTChecker = new InvalidTypeChecker(questions);
		msgs.addAll(ASTChecker.visit(ast));
		
		ASTChecker = new BoolConditionChecker(questions);
		msgs.addAll(ASTChecker.visit(ast));
		
		ASTChecker = new CyclicDependencyChecker();
		msgs.addAll(ASTChecker.visit(ast));
		
		return msgs;
	}
}
