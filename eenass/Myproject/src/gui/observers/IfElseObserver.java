package gui.observers;

import gui.render.Evaluator;
import gui.render.State;

import javax.swing.JComponent;

import ast.expr.value.Bool;
import ast.expr.value.Value;
import ast.statement.IfelseStatement;

public class IfElseObserver extends WidgetObserver {

	private final IfelseStatement ifelseStat;
	protected JComponent ifPanel;
	protected JComponent elsePanel;
	private final State state;
	
	public IfElseObserver(IfelseStatement ifelseStat, JComponent ifComp, JComponent elseComp, State state) {
		this.state = state;
		this.ifelseStat = ifelseStat;
		this.ifPanel = ifComp;
		this.elsePanel = elseComp;
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
