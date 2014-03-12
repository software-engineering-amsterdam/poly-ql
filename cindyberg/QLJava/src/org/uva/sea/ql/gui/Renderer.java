package org.uva.sea.ql.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.StatementVisitor;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.statement.ExpressionQuestion;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Questions;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluate.EvaluateExpression;
import org.uva.sea.ql.evaluate.Value;
import org.uva.sea.ql.gui.widget.Control;

public class Renderer implements StatementVisitor {

	JPanel mainpanel;
	State state;
	
	
	public static JPanel render(Statement statement, State state){

		Renderer renderer = new Renderer(state);
		statement.accept(renderer);
		return renderer.getPanel();
	}
	
	public Renderer(State state)
	{
		this.state = state;
		this.mainpanel = new JPanel();
		mainpanel.setLayout(new MigLayout("wrap 2"));
	}

	public JPanel getPanel() {
		return mainpanel;
	}

	private void addLabel(StringLiteral label){
		JLabel questionLabel = new JLabel(label.toString());
		mainpanel.add(questionLabel, "grow");
	}
	
	private void add(Control control){
		mainpanel.add(control.UIElement());
	}
	
	private Control typeToWidget(Question question, boolean isEnabled){
		Control control = question.getType().accept( new TypeToWidget(question.getIdentifier(), state) );
		control.setEnabled(isEnabled);
		return control;
	}
	
	//TODO make Expr question subset of question
	private Control typeToWidget2(ExpressionQuestion question, boolean isEnabled){
		Control control = question.getType().accept( new TypeToWidget(question.getIdentifier(), state) );
		control.setEnabled(isEnabled);
		return control;
	}
	
	private void registerHandler(Question question, Control control){
		state.putObservable(question.getIdentifier(), control);
	}
	
	private void registerExprQuestion(ExpressionQuestion exprquestion, Control control){
		ExpressionObserver exprObserver = new ExpressionObserver(control, state, exprquestion);
		//subscribe
		state.addGlobalObservers(exprObserver);
		//make itself observable
		state.putObservable(exprquestion.getIdentifier(), control);
	}
	

	//private void registerPropagate(ExpressionQuestion exprquestion) {
		// TODO Auto-generated method stub
//	}
	
	public void visit(ExpressionQuestion exprquestion) {
		addLabel(exprquestion.getLabel());
		Control control = typeToWidget2(exprquestion, false);
		registerExprQuestion(exprquestion, control);
		//registerPropagate(exprquestion); //propagate recomputation????
		initValue(exprquestion,control);
		add(control);
		
	}

	private void initValue(ExpressionQuestion exprquestion, Control control) {
		Value value = exprquestion.getExpression().accept(new EvaluateExpression((state.getEnvironment())));
		control.setValue(value);
		
	}

	public void visit(Question question) {
		addLabel(question.getLabel());
		
		Control control = typeToWidget(question, true);
		registerHandler(question,control);
		add(control);
		//if the value is changed in the component change value in environment.
		
	}

	public void visit(IfStatement ifconditional) {
		JPanel trueIf = render(ifconditional.getIfBody(), state);
		registerConditionDeps(ifconditional.getConditional(), trueIf, null);
		trueIf.setVisible(false);
		this.mainpanel.add(trueIf, "span");
	}

	public void visit(IfElseStatement ifelseconditional) {
		//TODO ifstatement check
		
		JPanel trueIf = render(ifelseconditional.getIfBody(), state);
		JPanel falseIf = render(ifelseconditional.getElseBody(),state);
		registerConditionDeps(ifelseconditional.getConditional(), trueIf, falseIf);
		trueIf.setVisible(false);
		falseIf.setVisible(false);
		
		this.mainpanel.add(trueIf, "span");
		this.mainpanel.add(falseIf, "span");
		
	}

	private void registerConditionDeps(Expression conditional, JPanel trueIf,
			JPanel falseIf) {
		ConditionalObserver conditionalObserver = new ConditionalObserver(conditional,state,trueIf,falseIf);
		state.addGlobalObservers(conditionalObserver);
	}

	public void visit(Form form) {
		form.getBody().accept(this);

	}

	public void visit(Questions body) {
		for(Statement s : body){
			s.accept(this);
		}
	}

}
