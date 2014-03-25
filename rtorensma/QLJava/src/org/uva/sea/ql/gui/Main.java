package org.uva.sea.ql.gui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.commons.io.FileUtils;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.checker.FormChecker;
import org.uva.sea.ql.checker.TypeEnvironment;
import org.uva.sea.ql.eval.ValueEnvironment;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class Main {
	public static void main(String[] args) throws ParseError, IOException {
		IParse parser = new ANTLRParser();
		String formString = FileUtils.readFileToString(new File("HouseOwning.ql"));
		Form form = parser.parseForm(formString);
		List<String> errors = new ArrayList<String>();
		boolean isFormCorrect = FormChecker.check(form, new TypeEnvironment(), errors);
		
		JFrame frame = new JFrame(form.getName().toString());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		if (isFormCorrect && errors.size() == 0) {
			frame.getContentPane().add(Renderer.render(form.getBody(), new ValueEnvironment()));
		}
		else {
			frame.getContentPane().add(new JLabel(errors.toString()));
		}
		
		frame.pack();
		frame.setVisible(true);
	}
}
