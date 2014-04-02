package gui.render;

import gui.component.ComputedWidget;
import gui.component.TypeToWidget;
import gui.component.Widget;
import gui.observers.ComputedQuestionObserver;
import gui.observers.FormSubmission;
import gui.observers.IfElseObserver;
import gui.observers.IfObserver;
import gui.observers.WidgetChangeHandler;
import gui.observers.WidgetObserver;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import ast.expr.Identifier;
import ast.expr.literal.StrLiteral;
import ast.statement.Block;
import ast.statement.ComputedQuestion;
import ast.statement.Form;
import ast.statement.IfStatement;
import ast.statement.IfelseStatement;
import ast.statement.Question;
import ast.statement.Statement;
import ast.statement.StatementList;
import ast.types.Type;
import ast.visitors.StatementVisitor;

public class Renderer implements StatementVisitor<JComponent>{
	
	private State state; 

	public Renderer(State state) {
		this.state = state;
	}
	
	private JPanel createNewPanel(){
		MigLayout layout = new MigLayout("hidemode 2, fillx");
		return new JPanel(layout);
	}

	public JComponent render(final Form form){
		final Renderer renderer = new Renderer(new State());
		JComponent comp = renderer.visit(form);
		return new JScrollPane(comp);
	}

	private void registerObservers(WidgetObserver obs){
		state.addAllObservers(obs);
		obs.evaluate();
	}
	
	private void registerControlChangeHandler(Identifier ident, Widget widget){
		WidgetChangeHandler handler = new WidgetChangeHandler(ident, widget, state);
		state.putObserver(ident, handler);
	}	
	
	private void addLabel(JPanel panel, StrLiteral label){
		panel.add(new JLabel(label.getVal().replace("\"", "")));
	}
	
	private Widget typeToWidget(Type t){	
		TypeToWidget vis = new TypeToWidget();
		return t.accept(vis);
	}
	
	private void addComponent(JPanel panel, Widget comp){
		panel.add(comp.getComponent(), "wrap");
	}
	
	@Override
	public JComponent visit(Form node) {
		JPanel panel = createNewPanel();
		panel.add(node.getStatements().accept(this));
		JButton submit = new JButton("Submit");
		submit.addActionListener(new FormSubmission(node.getId(), state));
		panel.add(submit, "wrap");
		return new JScrollPane(panel);
	}

	@Override
	public JComponent visit(StatementList node) {
		State currentState = state.currentState();
		JPanel panel = createNewPanel();
		Renderer render = new Renderer(currentState);
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
		JPanel panel = createNewPanel();
		Widget comp = typeToWidget(node.getType());
		state.addValue(node.getId(), comp.getValue());
		registerControlChangeHandler(node.getId(), comp);
		addLabel(panel, node.getLabel());
		addComponent(panel, comp);
		return panel;
	}

	@Override
	public JComponent visit(ComputedQuestion node) {
		ComputedWidget comp = new ComputedWidget();
		JPanel panel = createNewPanel();
		registerControlChangeHandler(node.getId(), comp);
		ComputedQuestionObserver obs = new ComputedQuestionObserver(node, comp, state);
		registerObservers(obs);
		addLabel(panel, node.getLabel());
		addComponent(panel, comp);
		return panel;
	}

	@Override
	public JComponent visit(IfStatement node) {
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
	
}
