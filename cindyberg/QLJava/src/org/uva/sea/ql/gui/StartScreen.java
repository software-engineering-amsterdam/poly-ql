package org.uva.sea.ql.gui;

import java.applet.Applet;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JTextField;

import org.uva.sea.ql.parser.jacc.ParseException;
import org.uva.sea.ql.typechecker.Problems;



public class StartScreen extends Applet implements ActionListener{
	
	private final String SOURCE = "C:\\Users\\Cindy\\Documents\\Github\\poly-ql\\cindyberg\\QLJava\\src\\org\\uva\\sea\\ql\\DSLForm.txt";

	private Button startQuiz;
	private JTextField textSource;
	TypeChecker typeChecker ;
	
	public StartScreen(){
		startQuiz = new Button("Start");
		textSource = new JTextField();
		textSource.setText(SOURCE);
		
		this.add(textSource);
		this.add(startQuiz);
		startQuiz.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		
		try {;
			typeChecker = new TypeChecker();
			displayProblems(typeChecker.run(SOURCE));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();

		}
	}
	
	public void displayProblems(Problems problems){
		problems.printErrors();
		problems.printWarnings();
	}
	
	private static final long serialVersionUID = 1L;

}