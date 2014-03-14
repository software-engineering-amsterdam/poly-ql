package gui.observers;

import gui.Evaluator;
import gui.component.Control;
import gui.render.State;

import java.util.Observable;
import java.util.Observer;

import ast.expr.evaluate.Bool;
import ast.expr.evaluate.Value;
import ast.statement.IfelseStatement;

public class IfElseObserver extends ControlObserver {

	private final State state;
	private final IfelseStatement ifelseStat;
	protected Control ifPanel;
	protected Control elsePanel;
	
	public IfElseObserver(State state, IfelseStatement ifelseStat, Control ifPanel, Control elsePanel) {
		this.state = state;
		this.ifelseStat = ifelseStat;
		this.ifPanel = ifPanel;
		this.elsePanel = elsePanel;
	}

	@Override
	public void evaluate() {
		Value val = ifelseStat.getExpr().accept(new Evaluator(state.getEnvValues())); 
		boolean visible = ((Bool)val).getValue();
		ifPanel.getComponent().setVisible(visible);
		if(elsePanel.getComponent() != null){
			elsePanel.getComponent().setVisible(!visible);
		}
		
	}

}
