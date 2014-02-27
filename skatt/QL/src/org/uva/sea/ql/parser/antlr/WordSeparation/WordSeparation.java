package org.uva.sea.ql.parser.antlr.WordSeparation;

import javax.swing.JFileChooser;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import WordSeparation.*;

public class WordSeparation {
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

		WordSeparationLexer lexer = new WordSeparationLexer(
				new ANTLRFileStream(testFile));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		System.out.println(tokens);
		WordSeparationParser p = new WordSeparationParser(tokens);
		p.setBuildParseTree(true);
		p.addParseListener(new WordSeparationListener());
		ParserRuleContext t = p.program();
	}
}
