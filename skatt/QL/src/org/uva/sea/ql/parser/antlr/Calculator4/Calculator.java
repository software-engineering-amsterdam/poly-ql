package org.uva.sea.ql.parser.antlr.Calculator4;

import javax.swing.JFileChooser;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import Calculator4.*;
 
public class Calculator
{
  public static void main(String[] args) throws Exception
  {
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

    Calculator4Lexer lexer = new Calculator4Lexer(new ANTLRFileStream(testFile));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    Calculator4Parser p = new Calculator4Parser(tokens);
    p.setBuildParseTree(true);
    p.addParseListener(new CalculatorListener());
    ParserRuleContext t = p.program();
  }
}