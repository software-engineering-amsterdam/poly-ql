package org.uva.sea.ql.gui;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.commons.io.FileUtils;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.checker.FormChecker;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class Main {

	public static void main(String[] args) throws ParseError, IOException {
		IParse parser = new ANTLRParser();
		String formString = FileUtils.readFileToString(new File("HouseOwning.ql"));
		Form form = parser.parseForm(formString);
		List<String> errors = new ArrayList<String>();
		FormChecker.check(form, new HashMap<Ident, Type>(), errors);
		String printErrors = errors.size() + " error(s) gevonden\n";
		for (String error : errors) {
			printErrors += "-   " + error + "\n";
		}
		
		JFrame frame = new JFrame(form.getName().toString());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(box);
		
		JTextArea formtextarea = new JTextArea(formString);
		JTextArea errorstextarea = new JTextArea(printErrors);
		if (errors.size() > 0) {
			errorstextarea.setForeground(Color.RED);
		}
		
		panel.add(formtextarea);
		panel.add(Box.createVerticalStrut(10));
		panel.add(errorstextarea);
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
