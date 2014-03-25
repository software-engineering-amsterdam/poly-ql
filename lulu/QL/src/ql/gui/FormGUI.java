package ql.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;
import ql.ast.form.Form;
import ql.parser.antlr.FormParser;

public class FormGUI implements ActionListener{
	private final FormParser parser;
	private final JButton finishButton;
	private final JFrame frame;
	
	public FormGUI() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		parser = new FormParser();
		finishButton = new JButton("Submit this form");
		finishButton.addActionListener(this);
	}

	
	public void showForm(String formSource) throws IOException{
		try {
			Form form = parser.parseForm(formSource);
			if (form.validate()) {
				if(form.getWarning()!=""){
					JOptionPane.showMessageDialog(null, form.getWarning());
				}
				JPanel panel = form.buildForm(frame);
				panel.add(finishButton, "span, growx");
				showPanel(panel, form.getIdent());
			}
			else {
				showPanel(showFormErrorPanel(form), "Errors found!");
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private JPanel showFormErrorPanel(Form form) {
		JPanel panel = new JPanel(new MigLayout());
		panel.add(new JLabel("Errors:"), "span, growx");
		panel.add(new JScrollPane(new JTextArea(form.getError(), 20, 50)), "span, growx");
		return panel;
	}

	private void showPanel(JPanel panel, String title){
		frame.setContentPane(panel);
		frame.setTitle(title);
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
