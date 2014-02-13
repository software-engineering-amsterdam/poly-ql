package org.uva.sea.ql.ast.statement;



public class QuestionSet extends Statement{

	public Statement single;
	public Statement multiple;
	
	public QuestionSet(Statement single, Statement multiple) {
		
		this.single = single;
		this.multiple = multiple;
	}

	public QuestionSet(Statement single) {
		
		this.single = single;
	}

	public void accept(IStatementVisitor visitor) {
		visitor.visit(this);
		
	}

}
