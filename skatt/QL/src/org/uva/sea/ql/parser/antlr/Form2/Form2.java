package org.uva.sea.ql.parser.antlr.Form2;

import javax.swing.JFileChooser;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import Form2.*;

public class Form2 {
	public static void main(String[] args) throws Exception {

		String testFile = "";
		// set test input
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Please choose the master file");
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			testFile = chooser.getSelectedFile().getAbsolutePath();
		} else {
			System.exit(0);
		}

		Form2Lexer lexer = new Form2Lexer(
				new ANTLRFileStream(testFile));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		System.out.println(tokens);
		Form2Parser p = new Form2Parser(tokens);
		p.setBuildParseTree(true);
		p.addParseListener(new Form2Listener());
		ParserRuleContext t = p.form();
	}
}
