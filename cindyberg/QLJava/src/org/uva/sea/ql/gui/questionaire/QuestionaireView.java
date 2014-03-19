package org.uva.sea.ql.gui.questionaire;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.statement.Form;

public class QuestionaireView {

	private JFrame frame;
	private JPanel mainpanel;
	//private Form form;
	
	public QuestionaireView(Form form){
		this.frame =  new JFrame("Questionaire");
	    frame.setSize(700, 500); 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void newScreen(Form form){
		mainpanel = Renderer.render(form, new State());
		frame.add(mainpanel);
		frame.setVisible(true);
	}
}
