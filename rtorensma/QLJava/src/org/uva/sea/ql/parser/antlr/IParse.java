package org.uva.sea.ql.parser.antlr;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.form.Form;

public interface IParse {
	Expr parseExpr(String src) throws ParseError;
	Form parseForm(String src) throws ParseError;
}
