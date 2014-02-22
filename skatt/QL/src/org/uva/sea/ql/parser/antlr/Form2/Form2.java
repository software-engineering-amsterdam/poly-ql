package org.uva.sea.ql.parser.antlr.Form2;

import javax.swing.JFileChooser;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

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
		Form2Parser parser = new Form2Parser(new CommonTokenStream(lexer));
		
		// generate tree and visitor
		ParseTree tree = parser.form();
		Form2Visitor visitor = new Form2CustomVisitor();
		visitor.visit(tree);
	}
}
