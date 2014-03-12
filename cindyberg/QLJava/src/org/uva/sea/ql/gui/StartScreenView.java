package org.uva.sea.ql.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import org.uva.sea.ql.parser.jacc.ParseException;

import problems.Problems;
import problems.Warning;
import problems.Error;

public class StartScreenView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static JFrame currentFrame;
	private Container container;
	private JPanel listView;
	private JPanel textView;
	private JPanel buttonView;
	private JTextArea text;
	private JList<String> warningList;
	private JList<String> errorList;
	private DefaultListModel<String> warnings;
	private DefaultListModel<String> errors;
	private final static String SOURCE = "C:\\Users\\Cindy\\Documents\\Github\\poly-ql\\cindyberg\\QLJava\\src\\org\\uva\\sea\\ql\\DSLForm.txt"; 
	
	public void renderView(){
		
		textView = new JPanel(new FlowLayout());
		listView = new JPanel();
		buttonView = new JPanel();
		warningList = new JList<String>();
		errorList = new JList<String>();
		
		createWarningList();
		createErrorList();
		createButton();
		createInputfield();

		
		container.add(textView, BorderLayout.NORTH);
		container.add(buttonView,BorderLayout.CENTER);
		container.add(listView, BorderLayout.SOUTH);
			
	}
	
	private void createWarningList(){
		warnings = new DefaultListModel<String>();
		warningList = new JList<String>(warnings);
		warningList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		warningList.setLayoutOrientation(JList.VERTICAL);
		warningList.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(warningList);
		listScroller.setPreferredSize(new Dimension(currentFrame.getWidth()/2-20,currentFrame.getHeight()/2-100)); 
		listView.add(listScroller,BorderLayout.EAST);
	}
	
	private void createErrorList(){
		errors = new DefaultListModel<String>();
		errorList = new JList<String>(errors);
		errorList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		errorList.setLayoutOrientation(JList.VERTICAL);
		errorList.setVisibleRowCount(-1);
		JScrollPane listScrollerError = new JScrollPane(errorList);
		listScrollerError.setPreferredSize(new Dimension(currentFrame.getWidth()/2-20,currentFrame.getHeight()/2-100)); 
		listView.add(listScrollerError, BorderLayout.WEST);
	}
	
	private void createInputfield(){
		text = new JTextArea();
		text.setText(SOURCE);
		text.setPreferredSize(new Dimension(currentFrame.getWidth()-20,currentFrame.getHeight()/2));
		textView.add(text);
	}
	private void createButton(){
		JButton button = new JButton("typecheck");
		button.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
                StartScreenController controller = new StartScreenController();
                try {
                	warnings.removeAllElements();
                	errors.removeAllElements();
                	Problems typeProblems = controller.runTypeChecker(readText());	
                	if(typeProblems.hasProblems()){
                		QuestionaireView b = new QuestionaireView();
                		b.newScreen();
                	}
                	else{
                		problemsToList(typeProblems);
                	}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
            }
        }); 
		buttonView.add(button);
	}
	
	private void problemsToList(Problems problems) {
		List<Warning> warnings = problems.getWarnings();
		List<Error> errors = problems.getErrors();
		
		for(Warning w : warnings){
		this.warnings.addElement(w.getString());
		}
		
		for(Error e : errors){
			this.errors.addElement(e.getString());
		}
		
		
	}
	
	public StartScreenView(){
		currentFrame = new JFrame("Questionaire");
		currentFrame.setSize(800, 600); 
		currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = new Container();
	    container = currentFrame.getContentPane();
	    currentFrame.setVisible(true); 
	}
	
	private String readText(){
		String questionaire = text.getText();
		return questionaire;
	}
}
