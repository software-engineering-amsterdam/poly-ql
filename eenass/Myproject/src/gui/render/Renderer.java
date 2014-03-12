package gui.render;

import gui.component.Control;
import gui.component.TypeToWidget;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ast.Visitor;
import ast.expr.Identifier;
import ast.expr.binExpr.Add;
import ast.expr.binExpr.And;
import ast.expr.binExpr.Div;
import ast.expr.binExpr.Eq;
import ast.expr.binExpr.GEq;
import ast.expr.binExpr.GT;
import ast.expr.binExpr.LEq;
import ast.expr.binExpr.LT;
import ast.expr.binExpr.Mul;
import ast.expr.binExpr.NEq;
import ast.expr.binExpr.Or;
import ast.expr.binExpr.Sub;
import ast.expr.literal.BoolLiteral;
import ast.expr.literal.IntLiteral;
import ast.expr.literal.StrLiteral;
import ast.expr.types.BoolType;
import ast.expr.types.IntType;
import ast.expr.types.StrType;
import ast.expr.types.Type;
import ast.expr.unExpression.Neg;
import ast.expr.unExpression.Not;
import ast.expr.unExpression.Pos;
import ast.statement.Block;
import ast.statement.ComputedQuestion;
import ast.statement.Form;
import ast.statement.IfStatement;
import ast.statement.IfelseStatement;
import ast.statement.Question;
import ast.statement.Statement;
import ast.statement.StatementList;

public class Renderer implements Visitor{
	
	private final JPanel panel;
	private final State state; 

	public Renderer(State state) {
		this.state = state;
		this.panel = new JPanel();
	}

	public static JPanel render(Statement s, State state){
		Renderer r = new Renderer(state);
		s.accept(r);
		return r.getPanel();
		
	}
	
	private JPanel getPanel() {
		return panel;
	}
	
	private void addLabel(String str){
		this.panel.add(new JLabel(str));
	}
	
	private Control typeToWidget(Type t, boolean visible){		
		TypeToWidget vis = new TypeToWidget();
		return t.accept(vis);
	}
	@Override
	public Object visit(StatementList node) {
		
		return null;
	}

	@Override
	public Object visit(Question node) {
		
		return null;
	}

	@Override
	public Object visit(ComputedQuestion node) {
		
		return null;
	}

	@Override
	public Object visit(Block node) {
		
		return null;
	}

	@Override
	public Object visit(IfStatement node) {
		
		return null;
	}

	@Override
	public Object visit(IfelseStatement node) {
		
		return null;
	}

	@Override
	public Object visit(Form node) {
		
		return null;
	}

	@Override
	public Object visit(Pos node) {
		return null;
	}

	@Override
	public Object visit(Neg node) {
		return null;
	}

	@Override
	public Object visit(Not node) {
		return null;
	}

	@Override
	public Object visit(Add node) {
		return null;
	}

	@Override
	public Object visit(And node) {
		return null;
	}

	@Override
	public Object visit(Div node) {
		return null;
	}

	@Override
	public Object visit(Eq node) {
		return null;
	}

	@Override
	public Object visit(GEq node) {
		return null;
	}

	@Override
	public Object visit(GT node) {
		return null;
	}

	@Override
	public Object visit(LEq node) {
		return null;
	}

	@Override
	public Object visit(LT node) {
		return null;
	}

	@Override
	public Object visit(Mul node) {
		return null;
	}

	@Override
	public Object visit(NEq node) {
		return null;
	}

	@Override
	public Object visit(Or node) {
		return null;
	}

	@Override
	public Object visit(Sub node) {
		return null;
	}

	@Override
	public Object visit(BoolLiteral node) {
		return null;
	}

	@Override
	public Object visit(Identifier node) {
		return null;
	}

	@Override
	public Object visit(IntLiteral node) {
		return null;
	}

	@Override
	public Object visit(StrLiteral node) {
		return null;
	}

	@Override
	public Object visit(BoolType node) {
		return null;
	}

	@Override
	public Object visit(IntType node) {
		return null;
	}

	@Override
	public Object visit(StrType node) {
		return null;
	}

	

}
