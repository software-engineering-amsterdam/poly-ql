package typecheck;

import java.util.HashMap;
import ast.types.Types;

public class Symboles {
	private final HashMap<String, Types> symboles;
	
	public Symboles(){
		symboles = new HashMap<>();
	}
	
	public void put(String symb, Types type){
		symboles.put(symb, type);
	}
	
	public Types getType(String symb){
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
