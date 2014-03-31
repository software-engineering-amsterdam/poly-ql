package typecheck;

import java.util.HashMap;

import ast.expr.Identifier;
import ast.types.Type;

public class SymbolTable {
	
	private HashMap<Identifier, Type> symbolTable;
	
	public SymbolTable(){
		symbolTable = new HashMap<>();
	}
	
	public void put(Identifier ident, Type type){
		symbolTable.put(ident, type);
	}
	
	public Type getType(Identifier ident){
		return symbolTable.get(ident);
	}
	
	public boolean containsSymbol(Identifier ident){
		return symbolTable.containsKey(ident);
	}
	
	public void clearSymbols(){
		symbolTable.clear();
	}
	
}
