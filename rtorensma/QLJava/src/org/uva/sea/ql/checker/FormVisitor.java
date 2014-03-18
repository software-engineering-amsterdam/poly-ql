package org.uva.sea.ql.checker;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.Computed;
import org.uva.sea.ql.ast.stat.IfThen;
import org.uva.sea.ql.ast.stat.IfThenElse;
import org.uva.sea.ql.ast.stat.Question;

public interface FormVisitor<T> {
	T visit(Form ast);
	T visit(Question ast);
	T visit(Computed ast);
	T visit(IfThen ast);
	T visit(IfThenElse ast);
	T visit(Block ast);
}
