package problems;

import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.type.Type;

public class RedeclaredWarning extends Warning{
	
	public RedeclaredWarning(Identifier id, Type type){
		super("Redeclaration of Identifier " +  id.toString() +" with type " + type.toString() );
	}

}
