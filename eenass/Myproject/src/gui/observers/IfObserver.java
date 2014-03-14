package gui.observers;

import gui.Evaluator;
import gui.component.Control;
import gui.render.State;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import ast.expr.evaluate.Bool;
import ast.expr.evaluate.Value;
import ast.statement.IfStatement;

public class IfObserver extends ControlObserver{
	
	private final State state;
	private final IfStatement ifStat;
	protected Control ifPanel;
	
	public IfObserver(State state, IfStatement ifStat, Control ifPanel) {
		super();
		this.state = state;
		this.ifStat = ifStat;
		this.ifPanel = ifPanel;
		
	}
	
	@Override
	public void evaluate() {
		Value val = ifStat.getExpr().accept(new Evaluator(state.getEnvValues())); 
		boolean visible = ((Bool)val).getValue();
		ifPanel.getComponent().setVisible(visible);	
	}

}
