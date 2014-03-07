package typecheck;

import java.util.HashMap;

import ast.expr.types.Type;

public class Symboles {
	private final HashMap<String, Type> symboles;
	
	public Symboles(){
		symboles = new HashMap<>();
	}
	
	public void put(String symb, Type type){
		symboles.put(symb, type);
	}
	
	public Type getType(String symb){
		return symboles.get(symb);
	}
	
	public void removeSymb(String symb){
		symboles.remove(symb);
	}
	
	public boolean containsSymb(String symb){
		return symboles.containsKey(symb);
	}
	
	public void clearSymboles(){
		symboles.clear();
	}
	
}
