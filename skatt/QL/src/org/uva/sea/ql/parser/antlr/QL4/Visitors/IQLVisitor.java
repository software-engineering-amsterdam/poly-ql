package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Conditional;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.BinaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.UnaryExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Value;
import org.uva.sea.ql.parser.antlr.QL4.TypeChecker.QLErrorMsg;

/**
 * Interface for visitors. Visitors must visit AST classes
 * @author Sammie Katt
 *
 */
public interface IQLVisitor {

	// All the visit functions necessary for a visitor to operate
	public List<QLErrorMsg> visit(Form form);
	public List<QLErrorMsg> visit(Question question);
	public List<QLErrorMsg> visit(Structures struc);
	public List<QLErrorMsg> visit(Conditional condition);
	public List<QLErrorMsg> visit(UnaryExpr expr);
	public List<QLErrorMsg> visit(BinaryExpr expr);
	public List<QLErrorMsg> visit(Value expr);
	public List<QLErrorMsg> visit(Identifier id);
}
