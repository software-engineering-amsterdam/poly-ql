package org.uva.sea.ql.checker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.visitor.SymbolCollectorStmtVisitor;

public class SymbolCollector {

	private SymbolCollectorStmtVisitor sv;
	
	public SymbolCollector(){
		this.sv = new SymbolCollectorStmtVisitor();
	}
	
	public Map<String, List<Type>> getSymbolTable(Form form){
		form.getBlock().accept(sv);
		return sv.getSymbolTable();
	}

	public Map<String, Type> getSingleTypeSymbolsTable(Map<String, List<Type>> duplicatesSymbolTable){
		Map<String, Type> symbolTable = new HashMap<String, Type>();
		for(Map.Entry<String, List<Type>> entry : duplicatesSymbolTable.entrySet()){
			symbolTable.put(entry.getKey(), entry.getValue().get(0));
		}
		return symbolTable;
	}

}