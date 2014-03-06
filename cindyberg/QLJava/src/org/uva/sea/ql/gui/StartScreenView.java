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
import org.uva.sea.ql.typechecker.Problems;

public class StartScreenView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static JFrame currentFrame;
	private Container container;
	private JPanel listView;
	private JPanel textView;
	private JPanel buttonView;
	private JTextArea text;
	private JList<String> problemList;
	private DefaultListModel<String> problems;
	private final static String SOURCE = "C:\\Users\\Cindy\\Documents\\Github\\poly-ql\\cindyberg\\QLJava\\src\\org\\uva\\sea\\ql\\DSLForm.txt"; 
	
	public void renderView(){
		
		textView = new JPanel(new FlowLayout());
		listView = new JPanel();
		buttonView = new JPanel();
		problemList = new JList<String>();
		
		createList();	
		createButton();
		createInputfield();

		
		container.add(textView, BorderLayout.NORTH);
		container.add(buttonView,BorderLayout.CENTER);
		container.add(listView, BorderLayout.SOUTH);
			
	}
	
	private void createList(){
		problems = new DefaultListModel<String>();
		problemList = new JList<String>(problems);
		problemList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		problemList.setLayoutOrientation(JList.VERTICAL);
		problemList.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(problemList);
		listScroller.setPreferredSize(new Dimension(currentFrame.getWidth()-20,currentFrame.getHeight()/2-200)); //get the screen height and width
		listView.add(listScroller);
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
                	problems.removeAllElements();
                	Problems typeProblems = controller.runTypeChecker(text.getText());	
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
		List<String> list = problems.getProblems();
		
		for(String s : list){
		this.problems.addElement(s);
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
}
