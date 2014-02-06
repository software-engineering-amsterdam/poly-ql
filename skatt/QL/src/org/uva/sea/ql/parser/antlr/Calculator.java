package org.uva.sea.ql.parser.antlr;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
 
public class Calculator
{
  public static void main(String[] args) throws Exception
  {
    Calculator4Lexer lexer = new Calculator4Lexer(new ANTLRFileStream(args[0]));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    Calculator4Parser p = new Calculator4Parser(tokens);
    p.setBuildParseTree(true);
    p.addParseListener(new CalculatorListener());
    ParserRuleContext<Token> t = p.program();
  }
}