package ast.statement;

import java.util.ArrayList;

import ast.Visitor;

public class StatementList extends Statement{
	
	private final ArrayList<Statement> list;
	
	public StatementList() {
		this.list = new ArrayList<>(); 
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	public ArrayList<Statement> getList() {
		return list;
	}
	
	public void addStatement(Statement statement){
		list.add(statement);
	}

}
