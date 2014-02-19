package org.uva.sea.ql.ast.form;

import java.util.ArrayList;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.ast.stat.Statement;

public class Form {
	private Ident ident;
	private ArrayList<Statement> statements;
	
	public Form(Statement stmt){
		this.statements = new ArrayList<Statement>();
		this.statements.add(stmt);
	}
	
	public void addStatement(Statement stmt){
		this.statements.add(stmt);
	}
	
	
}
