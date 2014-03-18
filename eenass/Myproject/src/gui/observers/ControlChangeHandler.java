package gui.observers;

import gui.component.Control;

import java.util.Map;
import java.util.Observable;

import ast.expr.Identifier;
import ast.expr.evaluate.Value;

public class ControlChangeHandler extends Observable implements EventListener {

	private Identifier ident;
	private Control control;
	private Map<Identifier, Value> environment;
	
	public ControlChangeHandler(Identifier ident, Control control, Map<Identifier, Value> environment) {
		this.ident = ident;
		this.control = control;
		this.environment = environment;
		control.addListener(this);
	}

	@Override
	public void handleEvent(EventChange e) {
		environment.put(ident, control.getValue());
		setChanged();
		notifyObservers();		
	}

}
