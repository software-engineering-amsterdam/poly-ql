package typecheck;

import java.util.HashMap;

import ast.expr.types.Type;

public class SymboleTable {
	private final HashMap<String, Type> symboleTable;
	
	public SymboleTable(){
		symboleTable = new HashMap<>();
	}
	
	public void put(String symb, Type type){
		symboleTable.put(symb, type);
	}
	
	public Type getType(String symb){
		return symboleTable.get(symb);
	}
	
	public void removeSymb(String symb){
		symboleTable.remove(symb);
	}
	
	public boolean containsSymb(String symb){
		return symboleTable.containsKey(symb);
	}
	
	public void clearSymboles(){
		symboleTable.clear();
	}
	
}
