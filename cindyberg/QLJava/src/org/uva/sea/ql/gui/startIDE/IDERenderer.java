package org.uva.sea.ql.gui.startIDE;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.gui.questionaire.QuestionaireView;
import org.uva.sea.ql.parser.jacc.ParseException;

import problems.Error;
import problems.Problems;
import problems.Warning;

public class IDERenderer {

	private JPanel mainpanel;
	private JFrame frame;
	private JTextArea input;
	private JList<String> warningList;
	private JList<String> errorList;
	private DefaultListModel<String> warnings;
	private DefaultListModel<String> errors;
	private Form form;
	
	public static JPanel render(JFrame frame){

		IDERenderer IDErenderer = new IDERenderer(frame);
		return IDErenderer.getPanel();
	}
	
	public IDERenderer(JFrame frame)
	{
		this.frame = frame;
		IDEButtons buttons = new IDEButtons(frame,input);
		this.mainpanel = new JPanel();
		mainpanel.setLayout(new MigLayout());
		
		mainpanel.add(buttons.saveButton());
		mainpanel.add(buttons.loadButton(), "wrap");
		inputField();
		typeCheckButton();
		questionaireButton();
		setupLists();
		createList(warningList);
		createList(errorList);
	}

	private void setupLists() {
		warnings = new DefaultListModel<String>();
		warningList = new JList<String>(warnings);
		errors = new DefaultListModel<String>();
		errorList = new JList<String>(errors);
		mainpanel.add(new JLabel("Warnings"), "grow");
		mainpanel.add(new JLabel("Errors"), "span, wrap");
	}

	public JPanel getPanel() {
		return mainpanel;
	}
	
	private void inputField(){
		input = new JTextArea();
		input.setSize(frame.getWidth(), frame.getHeight()/2);
		mainpanel.add(input, "grow, span, wrap, height 50%");
	}
	
	private void typeCheckButton(){
		JButton typeCheckButton = new JButton("Typecheck");
		typeCheckButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				typeCheck();
			}
		});
		mainpanel.add(typeCheckButton, "grow");
	}
	
	private void questionaireButton(){
		JButton continueButton = new JButton("Generate questionaire");
		continueButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				generateQuestionairePressed();
			}
		});
		mainpanel.add(continueButton, "grow, wrap");
	}

	private void generateQuestionairePressed() {
		
		typeCheck();
		if(isEmpty(errors) && isEmpty(warnings)){
			startQuesionaire();
		}
		else {
			JOptionPane.showMessageDialog(frame, "There are errors / warnings in the code", "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}


	private void startQuesionaire() {
		QuestionaireView b = new QuestionaireView(form);
		b.newScreen(form);
	}
	
	private boolean isEmpty(DefaultListModel<String> list){
		return list.isEmpty();
	}

	private void typeCheck() {
		
		StartScreenController controller = new StartScreenController();
        try {
        	
        	warnings.removeAllElements();
        	errors.removeAllElements();
        	form = controller.runTypeChecker(readText());
        	Problems typeProblems = controller.getProblems(form);	
        
        	problemsToList(typeProblems);
        
       
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(frame, "Parse Error", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
		
	}

	private void problemsToList(Problems typeProblems) {
		List<Warning> warnings = typeProblems.getWarnings();
		List<Error> errors = typeProblems.getErrors();
		
		for(Warning w : warnings){
		this.warnings.addElement(w.toString());
		}
		
		for(Error e : errors){
			this.errors.addElement(e.toString());
		}
	}
	
	private void createList(JList<String> list){
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(frame.getWidth()/2-20,frame.getHeight()/2-100)); 
		mainpanel.add(listScroller, "width 50%, height 25%");
	}
	
	
	private String readText() {
		String questionaire = input.getText();
		return questionaire;
	}
}