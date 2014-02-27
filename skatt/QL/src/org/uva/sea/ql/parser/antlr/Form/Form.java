package org.uva.sea.ql.parser.antlr.Form;

import javax.swing.JFileChooser;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import Form.*;

public class Form {
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

		FormLexer lexer = new FormLexer(
				new ANTLRFileStream(testFile));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		System.out.println(tokens);
		FormParser p = new FormParser(tokens);
		p.setBuildParseTree(true);
		p.addParseListener(new FormListener());
		ParserRuleContext t = p.form();
	}
}
