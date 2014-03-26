package org.uva.sea.ql.gui.startIDE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.gui.questionaire.QuestionaireView;
import org.uva.sea.ql.parser.jacc.ParseException;

import problems.Error;
import problems.Problems;
import problems.Warning;

public class IDEController {
	
	private final JFrame frame;
	private Form form;
	
	public IDEController(JFrame frame){
		this.frame = frame;
	}

	public void typeCheck() {
		
		TypeChecker controller = new TypeChecker();
        try {	
        	IDERenderer.warnings.removeAllElements();
        	IDERenderer.errors.removeAllElements();
        	form = controller.runTypeChecker(readText());
        	Problems typeProblems = controller.getProblems(form);	
        	addProblemsToList(typeProblems);
           
		} catch (ParseException e1) {
			JOptionPane.showMessageDialog(frame, "Parse Error", "Error", JOptionPane.ERROR_MESSAGE);
			}
	}
	
	private void addProblemsToList(Problems problems) {

		for(Warning w : problems.warnings){
			IDERenderer.warnings.addElement(w.toString());
		}
		
		for(Error e : problems.errors){
			IDERenderer.errors.addElement(e.toString());
		}
	}
	
	private String readText() {
		String questionaire = IDERenderer.input.getText();
		return questionaire;
	}
	
    public void generateQuestionairePressed() {		
		typeCheck();
		if(isEmpty(IDERenderer.errors) && isEmpty(IDERenderer.warnings)){
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

	public void saveButtonClicked(String input) {
		BufferedWriter buffwriter = null;
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File("/home/me/Documents"));
	    int retrival = chooser.showSaveDialog(null);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
			try {
					File file = new File(chooser.getSelectedFile()+".dsl");
					file.createNewFile();
				    buffwriter = new BufferedWriter(new FileWriter(chooser.getSelectedFile()+".dsl"));
				    buffwriter.write(input);
				} 
			catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				} 
			catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} 
			catch (IOException e1) {
					e1.printStackTrace();
				} 
			finally {
					try {
						buffwriter.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			} 
		}
	}
		
	public void printFileToField(File file) throws IOException {
		   BufferedReader br = new BufferedReader(new FileReader(file));
		    try {
		        String line = br.readLine();
		        while (line != null) {
		        	IDERenderer.input.append(line + '\n');
		            line = br.readLine();
		        }
		    } finally {
		        br.close();
		    }
		
	}

	public void loadButtonPressed() {
		final JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileFilter() {
	       
			@Override
	        public boolean accept(File f) {
	            if (f.isDirectory()) {
	                return true;
	            }
	            final String name = f.getName();
	            return name.endsWith(".dsl") || name.endsWith(".txt");
	        }

	        @Override
	        public String getDescription() {
	            return "*.dsl,*.txt";
	        }
		});
		
		int returnVal = fc.showOpenDialog(frame);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
		File file = fc.getSelectedFile();
			try {
				printFileToField(file);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} 
		else {
			
		}
	}

}
