package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.operators.arithmetic.*;
import org.uva.sea.ql.ast.operators.comparison.*;
import org.uva.sea.ql.ast.operators.logical.*;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.ast.type.*;

public class PrintVisitor implements IVisitor{

	public void visit(Add add) {
		printbrOpen();
		visit(add.returnLeft());
		System.out.print(add.show());
		visit(add.returnRight());
		printbrClose();
	}

	public void visit(Sub sub) {
		printbrOpen();
		visit(sub.returnLeft());
		System.out.print(sub.show());
		visit(sub.returnRight());
		printbrClose();
	}

	public void visit(Div div) {
		printbrOpen();
		visit(div.returnLeft());
		System.out.print(div.show());
		visit(div.returnRight());
		printbrClose();
	}

	public void visit(Mul mul) {
		printbrOpen();
		visit(mul.returnLeft());
		System.out.print(mul.show());
		visit(mul.returnRight());
		printbrClose();
	}

	public void visit(Neg neg) {
		printbrOpen();
		System.out.print(neg.show());
		visit(neg.returnExpr());
		printbrClose();
	}

	public void visit(Pos pos) {
		printbrOpen();
		System.out.print(pos.show());
		visit(pos.returnExpr());
		printbrClose();
	}

	public void visit(Eq eq) {
		printbrOpen();
		visit(eq.returnLeft());
		System.out.print(eq.show());
		visit(eq.returnRight());
		printbrClose();
	}

	public void visit(GEq geq) {
		printbrOpen();
		visit(geq.returnLeft());
		System.out.print(geq.show());
		visit(geq.returnRight());
		printbrClose();
	}

	public void visit(GT gt) {
		printbrOpen();
		visit(gt.returnLeft());
		System.out.print(gt.show());
		visit(gt.returnRight());
		printbrClose();
	}

	public void visit(LEq leq) {
		printbrOpen();
		visit(leq.returnLeft());
		System.out.print(leq.show());
		visit(leq.returnRight());
		printbrClose();
	}

	public void visit(LT lt) {
		printbrOpen();
		visit(lt.returnLeft());
		System.out.print(lt.show());
		visit(lt.returnRight());
		printbrClose();
	}

	public void visit(NEq neq) {
		printbrOpen();
		visit(neq.returnLeft());
		System.out.print(neq.show());
		visit(neq.returnRight());
		printbrClose();
	}

	public void visit(And and) {
		printbrOpen();
		visit(and.returnLeft());
		System.out.print(and.show());
		visit(and.returnRight());
		printbrClose();
	}

	public void visit(Or or) {
		visit(or.returnLeft());
		System.out.print(or.show());
		visit(or.returnRight());
		
	}

	public void visit(Not not) {
		System.out.print(not.show());
		visit(not.returnExpr());
		
	}

	public void visit(Identifier identifier) {
		System.out.print(identifier.show());		
	}

	public void visit(Expression expression) {
		expression.accept(this);
	}

	public void visit(ASTNode astnode) {
		astnode.accept(this);
		
	}

	public void visit(ExprQuestion exprquestion) {
		visit(exprquestion.getName()); System.out.print(" : ");
		visit(exprquestion.getLabel());
		visit(exprquestion.getType()); System.out.print(" ");
		visit(exprquestion.getExpression());
		System.out.print('\n');
		
	}
	
	public void visit(Statement statement){
		statement.accept(this);
	}

	public void visit(Question question) {
		visit(question.getName()); System.out.print(" : ");
		System.out.print(question.getLabel() +" ");
		visit(question.getType());
		System.out.print('\n');
		
	}

	public void visit(If ifconditional) {
		System.out.print("if ( ");
		visit(ifconditional.getConditional());
		System.out.print(" ) { \n");
		visit(ifconditional.getQuestionSet());
		System.out.print(" } \n");
		
	}

	public void visit(IfElse ifelseconditional) {
		System.out.print("if ");
		visit(ifelseconditional.getConditional());
		System.out.print(" { \n");
		visit(ifelseconditional.getIfQuestionSet());
		System.out.print(" } \n");
		System.out.print("else { \n");
		visit(ifelseconditional.getElseQuestionSet());
		System.out.print("} \n");
	}

	public void visit(Form form) {
		System.out.print("form : \n");
		visit(form.getFormName()); 
		System.out.print("{");
		visit(form.getQuestionSet());
		System.out.print("}");
		
	}

	public void visit(QuestionSet questionset) {
		visit(questionset.single);
		if(questionset.multiple != null){
		visit(questionset.multiple);
		}
		
	}
	
	public void visit(BoolType bool){
		System.out.print(bool.show());
	}

	public void visit(IntType integer) {
		System.out.print(integer.show());
		
	}

	public void visit(StringType string) {
		System.out.print(string.show());
		
	}

	public void visit(MoneyType money) {
		System.out.print(money.show());
		
	}
	
	public void visit(Type type){
		type.accept(this);
	}
	
	public void printbrOpen(){System.out.print("(");}
	public void printbrClose(){System.out.print(")");}
	

}
