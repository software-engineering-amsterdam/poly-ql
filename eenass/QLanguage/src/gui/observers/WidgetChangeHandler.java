package gui.observers;

import gui.component.Widget;
import gui.render.State;

import java.util.Observable;

import ast.expr.Identifier;

public class WidgetChangeHandler extends Observable implements EventListener {

	private Identifier ident;
	private Widget widget;
	private State state;
	
	public WidgetChangeHandler(Identifier ident, Widget widget, State state) {
		this.ident = ident;
		this.widget = widget;
		this.state = state;
		widget.addListener(this);
	}

	@Override
	public void handleEvent(EventChange e) {
		state.addValue(ident, widget.getValue());
		setChanged();
		notifyObservers();		
	}

}
