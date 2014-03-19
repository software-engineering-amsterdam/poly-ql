package org.uva.sea.ql.ast.statement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.uva.sea.ql.ast.StatementVisitor;

public class Questions extends Statement implements Iterable<Statement>{

	private List<Statement> questions = new ArrayList<Statement>();
	
	public Questions(Statement single) {
		questions.add(single);
	}
	
	public Questions(Statement single, Questions multiple) {		
		this.questions.add(single);
		this.questions.addAll(multiple.questions);
	}

	public void accept(StatementVisitor visitor) {
		visitor.visit(this);		
	}
	
	public Iterator<Statement> iterator() {
		return questions.iterator();
	}
}
