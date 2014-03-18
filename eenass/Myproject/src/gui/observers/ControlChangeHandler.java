package gui.observers;

import gui.component.Control;
import gui.render.State;

import java.util.Observable;

import ast.expr.Identifier;

public class ControlChangeHandler extends Observable implements EventListener {

	private Identifier ident;
	private Control control;
	private State state;
	
	public ControlChangeHandler(Identifier ident, Control control, State state) {
		this.ident = ident;
		this.control = control;
		this.state = state;
		control.addListener(this);
	}

	@Override
	public void handleEvent(EventChange e) {
		state.getEnvValues().put(ident, control.getValue());
		setChanged();
		notifyObservers();		
	}

}
