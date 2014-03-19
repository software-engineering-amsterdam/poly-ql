package gui.render;

import gui.component.ComputedControl;
import gui.component.Control;
import gui.component.TypeToWidget;
import gui.observers.ComputedQuestionObserver;
import gui.observers.ControlChangeHandler;
import gui.observers.ControlObserver;
import gui.observers.IfElseObserver;
import gui.observers.IfObserver;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
	
	private State state; 

	public Renderer(State state) {
		this.state = state;
	}
	
	private JPanel createNewPanel(){
		MigLayout layout = new MigLayout();
		return new JPanel(layout);
	}

	public JComponent render(final Form form){
		System.out.println("start rendering");
		final Renderer renderer = new Renderer(new State());
		JComponent comp = renderer.visit(form);
		comp.add(new JButton("Submit"));
		return new JScrollPane(comp);
	}

	private void registerObservers(ControlObserver obs){
		System.out.println("registerObserver");
		state.addAllObservers(obs);
		System.out.println("observer added to state " + state.getobservables());
		obs.evaluate();
	}
	
	private void registerControlChangeHandler(Identifier ident, Control control){
		System.out.println("registercontrolhandler");
		ControlChangeHandler handler = new ControlChangeHandler(ident, control, state);
		state.putObserver(ident, handler);
		System.out.println("key added to state " + state.getobservables().containsKey(ident));
	}
	
	
	private void addLabel(JPanel panel, String str){
		panel.add(new JLabel(str.replace("\"", "")));
	}
	
	private Control typeToWidget(Type t){	
		TypeToWidget vis = new TypeToWidget();
		return t.accept(vis);
	}
	
	private void addComponent(JPanel panel, Control comp){
		panel.add(comp.getComponent(), "wrap");
	}
	
	@Override
	public JComponent visit(Form node) {
		System.out.println("visit form");
		JPanel panel = createNewPanel();
		panel.add(node.getStatements().accept(this));
		return new JScrollPane(panel);
	}

	@Override
	public JComponent visit(StatementList node) {
		System.out.println("visit statementlist");
		State currentState = state.currentState();
		JPanel panel = createNewPanel();
		Renderer render = new Renderer(currentState);
		System.out.println("StatementList size " + node.getList().size());
		for(Statement s: node.getList()){
			panel.add(s.accept(render), "wrap");
		}
		return panel;
	}

	@Override
	public JComponent visit(Block node) {
		System.out.println("visit block"); 
		return visit(node.getStatements());
	}
	
	@Override
	public JComponent visit(Question node) {
		System.out.println("visit question " + node.getId().getIdentName());
		JPanel panel = createNewPanel();
		Control comp = typeToWidget(node.getType());
		state.addValue(node.getId(), comp.getValue());
		System.out.println("The value of comp is " + comp.getValue());
		registerControlChangeHandler(node.getId(), comp);
		addLabel(panel, node.getLabel().getVal());
		addComponent(panel, comp);
		return panel;
	}

	@Override
	public JComponent visit(ComputedQuestion node) {
		System.out.println("visit computedquestion");
		ComputedControl comp = new ComputedControl();
		JPanel panel = createNewPanel();
//		state.addValue(node.getId(), comp.getValue());
		registerControlChangeHandler(node.getId(), comp);
		ComputedQuestionObserver obs = new ComputedQuestionObserver(node, comp, state);
		registerObservers(obs);
		addLabel(panel, node.getLabel().getVal());
		addComponent(panel, comp);
		return panel;
	}

	@Override
	public JComponent visit(IfStatement node) {
		System.out.println("visit if");
		JPanel panel = createNewPanel();
		JComponent ifComp = node.getStatements().accept(this);
		ifComp.setVisible(false);
		panel.add(ifComp);
		IfObserver obs = new IfObserver(node, ifComp, state);
		registerObservers(obs);
		return panel;
	}

	@Override
	public JComponent visit(IfelseStatement node) {
		System.out.println("visit ifelse");
		JPanel panel = createNewPanel();
		JComponent ifComp = node.getStatements().accept(this);
		JComponent elseComp = node.getElseStatements().accept(this);
		ifComp.setVisible(false);
		elseComp.setVisible(false);
		panel.add(ifComp);
		panel.add(elseComp);
		IfElseObserver obs = new IfElseObserver(node, ifComp, elseComp, state);
		registerObservers(obs);
		return panel;
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
