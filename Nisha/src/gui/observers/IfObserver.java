package gui.observers;

import gui.Evaluation;
import gui.render.State;

import javax.swing.JComponent;

import ast.evaluate.Bool;
import ast.evaluate.Value;
import ast.form.Ifstate;

public class IfObserver extends ControlObserver{

	private final Ifstate ifStat;
	protected JComponent ifPanel;
	private final State state;

	public IfObserver(Ifstate ifStat, JComponent ifComp, State state) {
		super();
		this.ifStat = ifStat;
		this.ifPanel = ifComp;
		this.state = state;		
	}

	@Override
	public void evaluate() {
		Evaluation eval= new Evaluation(state.getEnvValues());
		Value val = ifStat.accept(eval); 
		boolean visible = ((Bool)val).getValue();
		ifPanel.setVisible(visible);	
		
			
		
	}

}
