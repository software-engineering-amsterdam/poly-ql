package ql.ast.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.literals.Bool;
import ql.ast.node.literals.Int;
import ql.ast.node.literals.Literal;
import ql.ast.node.literals.Str;
import ql.questionaire.model.answer.Answer;

public class ValueComputer  {

	public static Literal compute(Expression expr, Map<String,Answer> answers) {
		Map<Ident, Literal> identifiers=new HashMap<>();
		Set<String> identList=answers.keySet();
		for(String ident : identList) {				
			Literal literal=null;
			Answer answer=answers.get(ident);
			if(answer.isBool())
				literal=new Bool(Boolean.parseBoolean(answer.getValue()));
			if(answer.isInt())
				literal=new Int(Integer.parseInt(answer.getValue()));
			if(answer.isString())
				literal=new Str(answer.getValue());

			identifiers.put(new Ident(ident), literal);
		}	
		return expr.eval(identifiers);
	}	
}
