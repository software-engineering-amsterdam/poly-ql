package ql.ast.checker;

import java.util.LinkedList;
import java.util.List;

import ql.ast.node.ASTNode;
import ql.ast.node.Expression;
import ql.ast.node.Ident;
import ql.ast.node.syntactic.Label;
import ql.ast.node.types.Type;
import ql.ast.visitor.ASTVisitor;

public class CyclicDependencies extends ASTVisitor {
	private List<Ident> identifiers;	
	private List<Ident> dependencies;	

	public String check(ASTNode root) {
		identifiers=new LinkedList<>();
		dependencies=null;

		List<Ident> list = findCycles(root);

		if(list.size()!=0) {
			String message= "ERROR: The following questions form a cycle of dependencies: \n";
			for(Ident ident: list)
				message+=ident.toString()+" -> ";
			return message;
		}
		return null;
	}

	private List<Ident> findCycles(ASTNode root) {
		root.accept(this);

		for (Ident ident: identifiers) {
			dependencies=new LinkedList<>();
			dependencies.add(ident);
			for(int i=0; i<= identifiers.size()+2; i++)
				root.accept(this);
			if(dependencies.size() > identifiers.size())
				return getFirstCycle(dependencies);
		}
		return new LinkedList<>();
	}

	private List<Ident> getFirstCycle(List<Ident> dependencies) {
		List<Ident> returnList=new LinkedList<>();
		for(int i=0; i< dependencies.size(); i++) {
			Ident el = dependencies.get(i);
			if(returnList.contains(el)) {
				returnList.add(el);
				break;
			}
			returnList.add(el);
		}
		return returnList;			
	}

	@Override
	public void visit(Ident ident, Label label, Type type) {
		if(dependencies == null) {
			identifiers.add(ident);
		} 
	}

	@Override
	public void visit(Ident ident, Label label, Type type, Expression expr) {
		if(dependencies == null)
			identifiers.add(ident);
		else {
			Ident lastIdent=dependencies.get(dependencies.size()-1);
			if(expr.contains( lastIdent))
				dependencies.add(ident);				
		}
	}
}
