package gui.component;

import javax.swing.JComponent;

public class Control {
	
	private final JComponent comp;

	public Control(JComponent comp) {
		this.comp = comp;
	}

	public JComponent getComponent() {
		return comp;
	}

}
