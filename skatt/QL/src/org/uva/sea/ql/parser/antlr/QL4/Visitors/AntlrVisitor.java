package org.uva.sea.ql.parser.antlr.QL4.Visitors;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Conditional;
import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.QLTree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Expression;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.EqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.NeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical.AndExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Logical.OrExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.DivExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.GeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.MinExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.MultExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binary.Mathematical.PlusExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary.BraceExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Unary.NegExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Decimal;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.Number;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.QuestionType;

import QL4.QL4BaseVisitor;
import QL4.QL4Parser;

/**
 * A visitor for the QL4 grammar. Visits a tree parsed by the Antlr4
 * generated QL4parser on the QL4 grammar. Extends the QL4BaseVisitor
 * generated by Antrl4 and implements any function that needs
 * a more sophisticated visit  than depth first
 * @author Sammie Katt
 *
 */
public class AntlrVisitor extends QL4BaseVisitor<QLTree> {

  /**
   * Specifies behavior when visiting the form 
   * it will simply visit its structures and return the tree
   * generated throughout the visiting process
   */
  public Form visitForm(QL4Parser.FormContext ctx) {
	  return new Form((Structures) ctx.structures().accept(this));
  }
  
  /**
   * Returns a structures object, containing its structure in a list
   */
  public QLTree visitStructures(QL4Parser.StructuresContext ctx) {
	  List<QLTree> structures = new ArrayList<QLTree>();

	  for (QL4Parser.StructureContext struct : ctx.structure()) {
		  structures.add(struct.accept(this));
	  }
	  
	  return new Structures(structures);
  }

  /**
   * Returns a conditional object containing the expressions
   * and structures of the if/elseif/else in the context
   */
  public Conditional visitConditional(QL4Parser.ConditionalContext ctx) {

	 // define if/else (if available) conditions and structures
	 Expression ifExpr = (Expression) ctx.ifexpr.accept(this);
	 Structures ifStruc = (Structures) ctx.ifstruc.accept(this);
	 
	 Structures elseStruc = null;
	 if (ctx.elsestruc != null) {
		 elseStruc = (Structures) ctx.elsestruc.accept(this);
	 } 
	 
	 // define elseifConditions and their structs by looping over them in ctx
	 List<Expression > elseifExprs = new ArrayList<Expression >();
	 List<Structures> elseifStrucs = new ArrayList<Structures>();

	 // start i = 1, as first expression is always if
	 for (int i=1; i < ctx.expression().size(); i++) {
		 elseifExprs.add( (Expression) ctx.expression(i).accept(this));
		 elseifStrucs.add( (Structures) ctx.structures(i).accept(this));
	 }
	 
	 return new Conditional(ifExpr, elseifExprs, 
			 ifStruc, elseifStrucs, elseStruc);
  }
  
  /**
   * Returns a question object, containing its content:
   * Type, label, id and value (question.computed is false)
   */
  public Question visitRegQuestion(QL4Parser.RegQuestionContext ctx) {
	  Identifier id = new Identifier(ctx.IDENTIFIER().getText());
	  Label label = new Label(ctx.LABEL().getText());
	  QuestionType type = new QuestionType(ctx.TYPE().getText());
	  
	  return new Question(id, label, type); 
  }
  

  /**
   * Returns a Question object, containing its content:
   * Type, label, id and value (question.computed is true)
   */
  public Question visitCompQuestion(QL4Parser.CompQuestionContext ctx) {
	  Identifier id = new Identifier(ctx.IDENTIFIER().getText());
	  Label label = new Label(ctx.LABEL().getText());
	  QuestionType type = new QuestionType(ctx.TYPE().getText());
	  Expression value = (Expression) ctx.expression().accept(this);
	  
	  return new Question(id, label, type, value); 
  }


  //////////////////////// unary expressions
  public BraceExpr visitBraceExpr(QL4Parser.BraceExprContext ctx) {
	  Expression expr = (Expression) ctx.expression().accept(this);
	  return new BraceExpr(expr);
  }
  
  public NegExpr visitNegExpr(QL4Parser.NegExprContext ctx) {
	  Expression expr = (Expression) ctx.expression().accept(this);
	  return new NegExpr(expr);
  }
  
  //////////////////////// visiting binary math expressions
  
  public MultExpr visitMultExpr(QL4Parser.MultExprContext ctx) {
	  Expression lhs = (Expression) ctx.lhs.accept(this);
	  Expression rhs = (Expression) ctx.rhs.accept(this);
	  
	  return new MultExpr(lhs, rhs);	  
  }
  
  public DivExpr visitDivExpr(QL4Parser.DivExprContext ctx) {
	  Expression lhs = (Expression) ctx.lhs.accept(this);
	  Expression rhs = (Expression) ctx.rhs.accept(this);
	  
	  return new DivExpr(lhs, rhs);	  
  }
  
  public PlusExpr visitPlusExpr(QL4Parser.PlusExprContext ctx) {
	  Expression lhs = (Expression) ctx.lhs.accept(this);
	  Expression rhs = (Expression) ctx.rhs.accept(this);
	  
	  return new PlusExpr(lhs, rhs);	  
  }
  
  public MinExpr visitMinExpr(QL4Parser.MinExprContext ctx) {
	  Expression lhs = (Expression) ctx.lhs.accept(this);
	  Expression rhs = (Expression) ctx.rhs.accept(this);
	  
	  return new MinExpr(lhs, rhs);	  
  }
  
  //////////////////////// visiting binary logical expressions

  public AndExpr visitAndExpr(QL4Parser.AndExprContext ctx) {
	  Expression lhs = (Expression) ctx.lhs.accept(this);
	  Expression rhs = (Expression) ctx.rhs.accept(this);
	  
	  return new AndExpr(lhs, rhs);	  
  }
  
  public OrExpr visitOrExpr(QL4Parser.OrExprContext ctx) {
	  Expression lhs = (Expression) ctx.lhs.accept(this);
	  Expression rhs = (Expression) ctx.rhs.accept(this);
	  
	  return new OrExpr(lhs, rhs);	  
  }
  
  public EqExpr visitEqExpr(QL4Parser.EqExprContext ctx) {
	  Expression lhs = (Expression) ctx.lhs.accept(this);
	  Expression rhs = (Expression) ctx.rhs.accept(this);
	  
	  return new EqExpr(lhs, rhs);	  
  }
  
  public NeqExpr visitNeqExpr(QL4Parser.NeqExprContext ctx) {
	  Expression lhs = (Expression) ctx.lhs.accept(this);
	  Expression rhs = (Expression) ctx.rhs.accept(this);
	  
	  return new NeqExpr(lhs, rhs);	  
  }
  
  public GeqExpr visitGeqExpr(QL4Parser.GeqExprContext ctx) {
	  Expression lhs = (Expression) ctx.lhs.accept(this);
	  Expression rhs = (Expression) ctx.rhs.accept(this);
	  
	  return new GeqExpr(lhs, rhs);	  
  }
  
  //////////////////////// visiting QL4 primitives (bool, int, dec and id)
  
  public Bool visitBool(QL4Parser.BoolContext ctx) {
	  return new Bool(ctx.getText());
  }
  
  public Number visitInt(QL4Parser.IntContext ctx) {
	  return new Number(ctx.getText());
  }
  
  public Decimal visitDec(QL4Parser.DecContext ctx) {
	  return new Decimal(ctx.getText());
  }
  
  public Identifier visitIdent(QL4Parser.IdentContext ctx) {
	  return new Identifier(ctx.getText());
  }
}
