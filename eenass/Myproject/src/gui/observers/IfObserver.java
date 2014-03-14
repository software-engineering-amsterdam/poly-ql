package gui.observers;

import gui.Evaluator;
import gui.render.State;

import javax.swing.JPanel;

import ast.expr.evaluate.Bool;
import ast.expr.evaluate.Value;
import ast.statement.IfStatement;

public class IfObserver extends ControlObserver{
	
	private final IfStatement ifStat;
	protected JPanel ifPanel;
	private final State state;

	public IfObserver(IfStatement ifStat, JPanel ifPanel, State state) {
		super();
		this.ifStat = ifStat;
		this.ifPanel = ifPanel;
		this.state = state;		
	}
	
	@Override
	public void evaluate() {
		Value val = ifStat.getExpr().accept(new Evaluator(state.getEnvValues())); 
		boolean visible = ((Bool)val).getValue();
		ifPanel.setVisible(visible);	
	}

}
