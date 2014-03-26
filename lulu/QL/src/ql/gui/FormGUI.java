package ql.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;
import ql.ast.form.Form;
import ql.parser.antlr.FormParser;

public class FormGUI implements ActionListener{
	private final FormParser parser;
	private final JButton selectFormButton;
	private final JButton backButton;
	private final JFrame frame;
	
	public FormGUI() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		parser = new FormParser();
		backButton = new JButton("Back to menu");
		selectFormButton = new JButton("Select");
		backButton.addActionListener(this);
		selectFormButton.addActionListener(this);		
	}

	public void showMenu(){
		JPanel panel = new JPanel(new MigLayout());
		panel.add(new JLabel("Press the button below to select a form file:"), "span, growx");
		panel.add(selectFormButton, "span, growx");
		showPanel(panel,"Select Form");
	}
	
	public void selectFile(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter(new FileNameExtensionFilter("Questionnair file (*.ql)", "ql"));
		int returnVal = fileChooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			if (fileChooser.getSelectedFile().getPath().toLowerCase().endsWith(".ql")) {
				showForm(getFileText(fileChooser.getSelectedFile().getPath()));
			}else {
				JOptionPane.showMessageDialog(null, "It should be .ql file!");
			}
		}
	}
	
	private String getFileText(String url) {
		try {
			return FileUtils.readFileToString(new File(url));
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public void showForm(String formSource){
		try {
			Form form = parser.parseForm(formSource);
			if (form.validate()) {
				JPanel panel = form.buildForm(frame);
				panel.add(backButton, "span, growx");
				showPanel(panel, form.getIdent());
				if(form.getWarning()!=""){
					JOptionPane.showMessageDialog(panel, form.getWarning());
				}				
			}else {
				showPanel(showFormErrorPanel(form), "Errors found!");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private JPanel showFormErrorPanel(Form form) {
		JPanel panel = new JPanel(new MigLayout());
		panel.add(new JLabel("Errors:"), "span, growx");
		panel.add(new JScrollPane(new JTextArea(form.getError(), 10, 40)), "span, growx");
		panel.add(new JLabel("Warnings:"), "span, growx");
		panel.add(new JScrollPane(new JTextArea(form.getWarning(), 10, 40)), "span, growx");
		return panel;
	}

	private void showPanel(JPanel panel, String title){
		frame.setContentPane(panel);
		frame.setTitle(title);
		frame.setSize(500,500);
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == selectFormButton)
			selectFile();
		if (e.getSource() == backButton) {
			showMenu();
		}		
	}
}
