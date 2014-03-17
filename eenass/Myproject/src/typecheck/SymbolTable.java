package typecheck;

import java.util.HashMap;

import ast.expr.types.Type;

public class SymbolTable {
	private final HashMap<String, Type> symbolTable;
	
	public SymbolTable(){
		symbolTable = new HashMap<>();
	}
	
	public void put(String symb, Type type){
		symbolTable.put(symb, type);
	}
	
	public Type getType(String symb){
		return symbolTable.get(symb);
	}
	
	public boolean containsSymb(String symb){
		return symbolTable.containsKey(symb);
	}
	
	public void clearSymbols(){
		symbolTable.clear();
	}
	
}
