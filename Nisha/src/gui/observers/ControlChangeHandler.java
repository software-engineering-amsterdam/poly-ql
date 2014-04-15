package gui.observers;

import java.util.Observable;

import ast.evaluate.Int;
import expr.Ident;
import gui.component.CheckBox;
import gui.component.Control;
import gui.component.TextField;
import gui.render.State;

public class ControlChangeHandler extends Observable implements EventListener {

	private Ident ident;
	private Control control;
	private State state;

	public ControlChangeHandler(Ident ident, Control control, State state) {
		this.ident = ident;
		this.control = control;
		this.state = state;
		control.addListener(this);
	}

	@Override
	public void handleEvent(EventChange e) {
		if(e.getSource().getClass()==CheckBox.class)
		{
			CheckBox cbox= (CheckBox) e.getSource();
			state.getEnvValues().put(ident.id, cbox.getValue());
		}
		else if(((TextField) e.getSource()).getValue().getClass()==Int.class){
		//Int val= (Int) control.getValue();
			state.getEnvValues().put(ident.id, control.getValue());
			setChanged();
			notifyObservers();
		}	
	}

}