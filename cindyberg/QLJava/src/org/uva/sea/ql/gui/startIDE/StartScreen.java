package org.uva.sea.ql.gui.startIDE;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartScreen {

	private final JFrame frame;
	private JPanel mainpanel;
	
	public StartScreen(){
		this.frame =  new JFrame("Questionaire IDE"); 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void newScreen(){
		mainpanel = IDERenderer.render(frame);
		
		frame.add(mainpanel);
		frame.setSize(500,700);
		frame.setVisible(true);
	}
}
