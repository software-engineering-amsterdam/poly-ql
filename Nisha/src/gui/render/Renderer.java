package gui.render;

import expr.Ident;
import expr.conditional.And;
import expr.conditional.Or;
import expr.operation.Add;
import expr.operation.Div;
import expr.operation.Mul;
import expr.operation.Sub;
import expr.relational.Eq;
import expr.relational.GEq;
import expr.relational.GT;
import expr.relational.LEq;
import expr.relational.LT;
import expr.relational.NEq;
import expr.unary.Neg;
import expr.unary.Not;
import expr.unary.Pos;
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
import ast.ASTNode;
import ast.Visitor;
import ast.form.Block;
import ast.form.Computedquest;
import ast.form.Form;
import ast.form.IfElse;
import ast.form.Ifstate;
import ast.form.Question;
import ast.form.Statement;
import ast.form.StatementList;
import ast.literals.BoolLiteral;
import ast.literals.IntLiteral;
import ast.literals.StrLiteral;
import ast.type.Booltype;
import ast.type.Inttype;
import ast.type.Strtype;
import ast.type.Type;


public class Renderer implements Visitor<JComponent>{

	private State state; 
	private final JPanel panel;
	private Form form;

	public static JPanel render(ASTNode node, State states, Form form)
	{
		Renderer r= new Renderer(states, form);
		node.accept(r);
		return r.getPanel();
	}
	
	private JPanel getPanel(){
		return panel;
	}
	
	public Renderer(State state, Form form) {
		this.state = state;
		this.form=form;
		this.panel=new JPanel();
	}

	public JPanel createNewPanel(){
		MigLayout layout = new MigLayout();
		return new JPanel(layout);
	}

	public JComponent render(final Form form){
		this.form=form;
		final Renderer renderer = new Renderer(new State(), form);
		JComponent comp = renderer.visit(form);
		comp.add(new JButton("Submit"));
		return new JScrollPane(comp);
	}

	public void registerObservers(ControlObserver obs){
		state.addAllObservers(obs);
		
		//obs.evaluate();
		//System.out.println("obs evaluate " + state.addAllObservers(obs) );
	}

	public void registerControlChangeHandler(Ident ident, Control control){
		ControlChangeHandler handler = new ControlChangeHandler(ident, control, state);
		state.putObserver(ident, handler);
	}


	public void addLabel(String str){
		panel.add(new JLabel(str.replace("\"", "")));
	}

	public Control typeToWidget(Type t, String description, Ident id, Form form, State state, Boolean bool){	
		panel.setVisible(bool);
		TypeToWidget vis = new TypeToWidget(description, id, form, state);
		return t.accept(vis);
	}

	public void addComponent(Control comp){
		panel.add(comp.getComponent(), "wrap");
	}

	@Override
	public JComponent visit(Form node) {
		JPanel panel = createNewPanel();
		panel.add(node.getStatements().accept(this));
		return new JScrollPane(panel);
	}

	@Override
	public JComponent visit(StatementList node) {
		State currentState = state.currentState();
		//JPanel panel = createNewPanel();
		Renderer render = new Renderer(currentState, form);
		for(Statement s: node.getList()){
			panel.add(s.accept(render), "wrap");
		}
		return panel;
	}

	@Override
	public JComponent visit(Block node) {
		return visit(node.getStatements());
	}

	@Override
	public JComponent visit(Question node) {
		Control comp = typeToWidget(node.getType(),node.getDescription(),node.getId(),form, state, true);
		registerControlChangeHandler(node.getId(), comp);
		state.addValue(node.getId(), comp.getValue());
		addComponent(comp);
		return panel;
	}

	@Override
	public JComponent visit(Computedquest node) {
		ComputedControl comp = new ComputedControl();
		JPanel panel = createNewPanel();
		registerControlChangeHandler(node.getId(), comp);
		ComputedQuestionObserver obs = new ComputedQuestionObserver(node, comp, state);
		registerObservers(obs);
		addLabel(node.getStatement().getValue());
		addComponent( comp);
		return panel;
	}

	@Override
	public JComponent visit(Ifstate node) {
		JPanel panel = createNewPanel();
		JComponent ifComp = node.getStatements().accept(this);
		ifComp.setVisible(false);
		panel.add(ifComp);
		IfObserver obs = new IfObserver(node, ifComp, state);
		registerObservers(obs);
		return panel;
	}

	@Override
	public JComponent visit(IfElse node) {
		JPanel panel = createNewPanel();
		JComponent ifComp = node.getStatements().accept(this);
		JComponent elseComp = node.getStatement1().accept(this);
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
	public JComponent visit(Ident node) {
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
	public JComponent visit(Booltype node) {
		return null;
	}

	@Override
	public JComponent visit(Inttype node) {
		return null;
	}

	@Override
	public JComponent visit(Strtype node) {
		return null;
	}
	

}