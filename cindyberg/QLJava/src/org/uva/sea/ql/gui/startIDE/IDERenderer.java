package org.uva.sea.ql.gui.startIDE;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import net.miginfocom.swing.MigLayout;

public class IDERenderer {

	private JPanel mainpanel;
	private JFrame frame;
	private Controller controller;
	static JTextArea input;
	private JList<String> warningList;
	private JList<String> errorList;
	static DefaultListModel<String> warnings;
	static DefaultListModel<String> errors;
	
	public static JPanel render(JFrame frame){

		IDERenderer IDErenderer = new IDERenderer(frame);
		return IDErenderer.getPanel();
	}
	
	public IDERenderer(JFrame frame)
	{
		this.frame = frame;
		controller = new Controller(frame);
		this.mainpanel = new JPanel();
		mainpanel.setLayout(new MigLayout());
		
		addElements();
	}
	
	private void addElements(){
		inputField();
		add(saveButton(), "");
		add(loadButton(), "wrap");
		add(input, "grow, span, wrap, height 50%");
		add(typeCheckButton(), "grow");
		add(questionaireButton(),"grow, wrap");
		setupLists();
		add(new JLabel("Warnings"), "grow");
		add(new JLabel("Errors"), "span, wrap");
		add(createList(warningList), "width 50%, height 25%");
		add(createList(errorList), "width 50%, height 25%");
		
	}
	private void add(JComponent component, String description){
		mainpanel.add(component, description);
	}
	
	private void setupLists() {
		warnings = new DefaultListModel<String>();
		warningList = new JList<String>(warnings);
		errors = new DefaultListModel<String>();
		errorList = new JList<String>(errors);
	}

	public JPanel getPanel() {
		return mainpanel;
	}
	
	private void inputField(){
		input = new JTextArea();
		input.setSize(frame.getWidth(), frame.getHeight()/2);
	}
	
	private JButton typeCheckButton(){
		JButton typeCheckButton = new JButton("Typecheck");
		typeCheckButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controller.typeCheck();
			}
		});
		return typeCheckButton;
	}
	
	private JButton questionaireButton(){
		JButton continueButton = new JButton("Generate questionaire");
		continueButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controller.generateQuestionairePressed();
			}
		});
		return continueButton;
	}
	
	private JScrollPane createList(JList<String> list){
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(frame.getWidth()/2-20,frame.getHeight()/2-100)); 
		return listScroller;
	}
	
	public JButton loadButton() {
		JButton loadButton = new JButton("Load file");
		loadButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controller.loadButtonPressed();
			}
		});
		
		return loadButton;
	}
	
	public JButton saveButton(){
		JButton saveButton = new JButton("Save file");
		saveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controller.saveButtonClicked(input.getText());
			}
		});
		
		return saveButton;
	}
}