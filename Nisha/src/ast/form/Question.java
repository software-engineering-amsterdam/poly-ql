package ast.form;


import ast.Visitor;
import ast.literals.StrLiteral;
import ast.type.Type;
import expr.Ident;
public class Question extends Statement{
	
	public final Ident id;
	public final StrLiteral statement;
	public final Type type;
	
	public Question(Ident id, StrLiteral statement, Type type){
		this.id = id;
		this.statement = statement;
		this.type = type;
		
	}
	
	
	public Ident getId() {
		return id;
	}

	public StrLiteral getStatement() {
		return statement;
	}

	public Type getType() {
		return type;
	}
	
	public String getDescription(){
		return this.statement.getValue();
	}

	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}




}
