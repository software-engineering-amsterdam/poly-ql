package gui.component;

import gui.observers.EventChange;
import gui.observers.EventListener;
import gui.observers.EventSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;

import ast.value.Value;

public abstract class Widget implements EventSource{
	
	private List<EventListener> eventListeners;
	
	public abstract JComponent getComponent();
	public abstract Value getValue();
	
	public Widget() {
		eventListeners = new ArrayList<EventListener>();
	}

	protected synchronized void publishEventChange(){
		EventChange event = new EventChange(this);
		Iterator<EventListener> itr = eventListeners.iterator();
		while(itr.hasNext()){
			itr.next().handleEvent(event);
		}
	}
	
	public synchronized void addListener(EventListener e){
		eventListeners.add(e);
	}
	
	public synchronized void removeListener(EventListener e){
		eventListeners.remove(e);
	}
}
