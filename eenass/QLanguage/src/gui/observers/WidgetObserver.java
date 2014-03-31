package gui.observers;

import java.util.Observable;
import java.util.Observer;

public abstract class WidgetObserver implements Observer{

	public abstract void evaluate();
	
	@Override
	public void update(Observable arg0, Object arg1) {
		evaluate();		
	}

}
