package org.uva.sea.ql.parser.antlr.Form2;

import javax.swing.JFileChooser;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

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

		// create lexer and perser
		Form2Lexer lexer = new Form2Lexer(new ANTLRFileStream(testFile));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		Form2Parser p = new Form2Parser(tokens);
		//ParserRuleContext<Token> tree = p.compilationUnit();
		ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
		Form2BaseListener extractor = new Form2BaseListener();

	}
}
