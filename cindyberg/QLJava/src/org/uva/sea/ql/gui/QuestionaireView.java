package org.uva.sea.ql.gui;

import javax.swing.JFrame;

public class QuestionaireView {

	private JFrame frame;
	public QuestionaireView(){
		this.frame =  new JFrame("Questionaire");
	    frame.setSize(700, 500); 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void newScreen(){
		frame.setVisible(true);
		
	}
}
