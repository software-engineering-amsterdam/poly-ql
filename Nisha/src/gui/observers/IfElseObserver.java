package gui.observers;

import gui.Evaluation;
import gui.render.State;

import javax.swing.JComponent;

import ast.evaluate.Bool;
import ast.evaluate.Value;
import ast.form.IfElse;

public class IfElseObserver extends ControlObserver {

	private final IfElse ifelseStat;
	protected JComponent ifPanel;
	protected JComponent elsePanel;
	private final State state;

	public IfElseObserver(IfElse ifelseStat, JComponent ifComp, JComponent elseComp, State state) {
		this.state = state;
		this.ifelseStat = ifelseStat;
		this.ifPanel = ifComp;
		this.elsePanel = elseComp;
	}

	@Override
	public void evaluate() {
		Value val = ifelseStat.getExpr().accept(new Evaluation(state.getEnvValues())); 
		boolean visible = ((Bool)val).getValue();
		ifPanel.setVisible(visible);
		if(elsePanel != null){
			elsePanel.setVisible(!visible);
		}

	}

}