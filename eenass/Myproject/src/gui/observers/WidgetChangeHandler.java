package gui.observers;

import gui.component.Widget;
import gui.render.State;

import java.util.Observable;

import ast.expr.Identifier;

public class WidgetChangeHandler extends Observable implements EventListener {

	private Identifier ident;
	private Widget control;
	private State state;
	
	public WidgetChangeHandler(Identifier ident, Widget control, State state) {
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
