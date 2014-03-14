package gui.observers;

import gui.Evaluator;
import gui.component.Control;
import gui.render.State;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import ast.expr.evaluate.Bool;
import ast.expr.evaluate.Value;
import ast.statement.IfStatement;
import ast.statement.IfelseStatement;

public class IfElseObserver extends ControlObserver {

	private final IfelseStatement ifelseStat;
	protected JPanel ifPanel;
	protected JPanel elsePanel;
	private final State state;
	
	public IfElseObserver(IfelseStatement ifelseStat, JPanel ifPanel, JPanel elsePanel, State state) {
		this.state = state;
		this.ifelseStat = ifelseStat;
		this.ifPanel = ifPanel;
		this.elsePanel = elsePanel;
	}

	@Override
	public void evaluate() {
		Value val = ifelseStat.getExpr().accept(new Evaluator(state.getEnvValues())); 
		boolean visible = ((Bool)val).getValue();
		ifPanel.setVisible(visible);
		if(elsePanel != null){
			elsePanel.setVisible(!visible);
		}
		
	}

}
