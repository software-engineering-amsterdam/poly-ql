package org.uva.sea.ql.gui;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import org.apache.commons.io.FileUtils;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.checker.FormChecker;
import org.uva.sea.ql.eval.ValueEnvironment;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;

public class Main {
	public static void main(String[] args) throws ParseError, IOException {
		IParse parser = new ANTLRParser();
		String formString = FileUtils.readFileToString(new File("HouseOwning.ql"));
		Form form = parser.parseForm(formString);
		FormChecker.check(form);
		
		JFrame frame = new JFrame(form.getName().toString());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(Renderer.render(form, new ValueEnvironment()));
		frame.pack();
		frame.setVisible(true);
	}
}
