package org.uva.sea.ql.checker;

import org.uva.sea.ql.ast.form.Form;

public interface FormVisitor {
	
	void visit(Form form);

}
