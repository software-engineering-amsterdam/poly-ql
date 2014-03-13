package gui.render;

import gui.component.Control;
import gui.component.TypeToWidget;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
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

public class Renderer implements Visitor<JComponent>{
	
	private final JPanel panel;
//	private final State state; 

	
	public Renderer() {
		MigLayout layout = new MigLayout();
		this.panel = new JPanel(layout);
//		this.panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	}
	
//	public Renderer(State state) {
//		this.state = state;
//		this.panel = new JPanel();
//	}
//
//	public static JPanel render(Statement s, State state){
//		Renderer r = new Renderer(state);
//		s.accept(r);
//		return r.getPanel();
//		
//	}
	
	
	public static JPanel render(StatementList list){
		Renderer r = new Renderer();
		for(Statement s: list.getList()){
			s.accept(r);
		}
		
		JPanel panel2 = r.getPanel();
		return panel2;
	}
	
	private JPanel getPanel() {
		return panel;
	}
	
	private void addLabel(String str){
		this.panel.add(new JLabel(str.replace("\"", "")));
	}
	
	private Control typeToWidget(Type t, boolean visible){	
		System.out.println("type to widiget");
		TypeToWidget vis = new TypeToWidget();
		return t.accept(vis);
	}
	
	private void addComponent(Control comp){
		System.out.println("add component");
		this.panel.add(comp.getComponent(), "wrap");
	}
	
	private void addPanel(JPanel p){
		this.panel.add(p, "wrap");
	}
	

	@Override
	public JComponent visit(Form node) {
		System.out.println("visit form");
		return render(node.getStatements());
	}

	@Override
	public JComponent visit(StatementList node) {
		System.out.println("visit Statementlist");
		for(Statement s: node.getList()){
			panel.add(s.accept(this), "wrap");
		}
		return panel;
	}

	@Override
	public JComponent visit(Question node) {
		System.out.println("visit question");
		addLabel(node.getLabel().getVal());
		Control comp = typeToWidget(node.getType(), true);
		addComponent(comp);
		return panel;
	}

	@Override
	public JComponent visit(ComputedQuestion node) {
		System.out.println("visit computed question");
		addLabel(node.getLabel().getVal());
		Control comp = typeToWidget(node.getType(), false);
		addComponent(comp);
		return panel;
	}

	@Override
	public JComponent visit(Block node) {
		System.out.println("visit block");
		return visit(node.getStatements());
	}

	@Override
	public JComponent visit(IfStatement node) {
		System.out.println("visit if");
		JPanel ifComp = render(node.getStatements());
		ifComp.setVisible(false);
		addPanel(ifComp);
		return panel;
	}

	@Override
	public JComponent visit(IfelseStatement node) {
		System.out.println("visit ifelse");
		JPanel ifComp = render(node.getStatements());
		JPanel elseComp = render(node.getElseStatements());
		ifComp.setVisible(false);
		elseComp.setVisible(false);
		addPanel(ifComp);
		addPanel(elseComp);		
		return panel;
	}
	
	public JComponent render(final Form form){
		System.out.println("start rendering");
		final Renderer renderer = new Renderer();
		JComponent comp = renderer.visit(form);
		comp.add(new JButton("Submit"));
		return comp;
	}

	@Override
	public JComponent visit(Pos node) {
		return null;
	}

	@Override
	public JComponent visit(Neg node) {
		return null;
	}

	@Override
	public JComponent visit(Not node) {
		return null;
	}

	@Override
	public JComponent visit(Add node) {
		return null;
	}

	@Override
	public JComponent visit(And node) {
		return null;
	}

	@Override
	public JComponent visit(Div node) {
		return null;
	}

	@Override
	public JComponent visit(Eq node) {
		return null;
	}

	@Override
	public JComponent visit(GEq node) {
		return null;
	}

	@Override
	public JComponent visit(GT node) {
		return null;
	}

	@Override
	public JComponent visit(LEq node) {
		return null;
	}

	@Override
	public JComponent visit(LT node) {
		return null;
	}

	@Override
	public JComponent visit(Mul node) {
		return null;
	}

	@Override
	public JComponent visit(NEq node) {
		return null;
	}

	@Override
	public JComponent visit(Or node) {
		return null;
	}

	@Override
	public JComponent visit(Sub node) {
		return null;
	}

	@Override
	public JComponent visit(BoolLiteral node) {
		return null;
	}

	@Override
	public JComponent visit(Identifier node) {
		return null;
	}

	@Override
	public JComponent visit(IntLiteral node) {
		return null;
	}

	@Override
	public JComponent visit(StrLiteral node) {
		return null;
	}

	@Override
	public JComponent visit(BoolType node) {
		return null;
	}

	@Override
	public JComponent visit(IntType node) {
		return null;
	}

	@Override
	public JComponent visit(StrType node) {
		return null;
	}

	

}
