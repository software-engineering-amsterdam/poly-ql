package gui.observers;

import gui.render.Evaluator;
import gui.render.State;

import javax.swing.JComponent;

import ast.statement.IfStatement;
import ast.value.Bool;
import ast.value.Value;

public class IfObserver extends WidgetObserver{
	
	private final IfStatement ifStat;
	protected JComponent ifPanel;
	private final State state;

	public IfObserver(IfStatement ifStat, JComponent ifComp, State state) {
		super();
		this.ifStat = ifStat;
		this.ifPanel = ifComp;
		this.state = state;		
	}
	
	@Override
	public void evaluate() {
		boolean visible = false;
		Value val = ifStat.getExpr().accept(new Evaluator(state.getEnvValues())); 
		if (val.isDefined()){
			visible = ((Bool)val).getValue();
		}		
		ifPanel.setVisible(visible);	
	}

}
