package typecheck;

import java.util.HashMap;

import ast.expr.Identifier;
import ast.types.Type;

public class SymbolTable {
	private HashMap<Identifier, Type> symbolTable;
	
	public SymbolTable(){
		symbolTable = new HashMap<>();
	}
	
	public void put(Identifier symb, Type type){
		symbolTable.put(symb, type);
	}
	
	public Type getType(Identifier symb){
		return symbolTable.get(symb);
	}
	
	public boolean containsSymb(Identifier symb){
		return symbolTable.containsKey(symb);
	}
	
	public void clearSymbols(){
		symbolTable.clear();
	}
	
}
