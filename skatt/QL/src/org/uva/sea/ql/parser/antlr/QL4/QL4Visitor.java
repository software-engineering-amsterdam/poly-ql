package org.uva.sea.ql.parser.antlr.QL4;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Conditional;
import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Form;
import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Question;
import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Structures;
import org.uva.sea.ql.parser.antlr.QL4.AST.QL4Tree;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.QL4BraceExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair.QL4AndExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair.QL4DivExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair.QL4EqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair.QL4GeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair.QL4MinExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair.QL4MultExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair.QL4NeqExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair.QL4OrExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Expression.Binair.QL4PlusExpr;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.QL4Bool;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.QL4Identifier;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.QL4Label;
import org.uva.sea.ql.parser.antlr.QL4.AST.Value.QL4Type;

import QL4.QL4BaseVisitor;
import QL4.QL4Parser;
import QL4.QL4Parser.EqExprContext;

/**
 * A visitor for the QL4 grammar. Visits a tree parsed by the Antlr4
 * generated QL4parser on the QL4 grammar. Extends the QL4BaseVisitor
 * generated by Antrl4 and implements any function that needs
 * a more sophisticated visit  than depth first
 * @author Sammie Katt
 *
 */
public class QL4Visitor extends QL4BaseVisitor<QL4Tree> {

  /**
   * Specifies behavior when visiting the form 
   * it will simply visit its structures and return the tree
   * generated throughout the visiting process
   */
  public QL4Form visitForm(QL4Parser.FormContext ctx) {
	  return new QL4Form(ctx.structures().accept(this));
  }
  
  /**
   * Returns a structures object, containing its structure in a list
   */
  public QL4Tree visitStructures(QL4Parser.StructuresContext ctx) {
	  List<QL4Tree> structures = new ArrayList<QL4Tree>();

	  for (QL4Parser.StructureContext struct : ctx.structure()) {
		  structures.add(struct.accept(this));
	  }
	  
	  return new QL4Structures(structures);
  }

  /**
   * Returns a conditional object containing the expressions
   * and structures of the if/elseif/else in the context
   */
  public QL4Conditional visitConditional(QL4Parser.ConditionalContext ctx) {

	 // define if/else (if available) conditions and structures
	 QL4Tree ifExpr = ctx.ifexpr.accept(this);
	 QL4Tree ifStruc = ctx.ifstruc.accept(this);
	 
	 QL4Tree elseStruc = null;
	 if (ctx.elsestruc != null) {
		 elseStruc = ctx.elsestruc.accept(this);
	 } 
	 
	 // define elseifConditions and their structs by looping over them in ctx
	 List<QL4Tree> elseifExprs = new ArrayList<QL4Tree>();
	 List<QL4Tree> elseifStrucs = new ArrayList<QL4Tree>();

	 // start i = 1, as first expression is always if
	 for (int i=1; i < ctx.expression().size(); i++) {
		 elseifExprs.add(ctx.expression(i).accept(this));
		 elseifStrucs.add(ctx.structures(i).accept(this));
	 }
	 
	 return new QL4Conditional(ifExpr, elseifExprs, 
			 ifStruc, elseifStrucs, elseStruc);
  }
  
  /**
   * Returns a question object, containing its content:
   * Type, label, id and value (question.computed is false)
   */
  public QL4Question visitRegQuestion(QL4Parser.RegQuestionContext ctx) {
	  QL4Tree id = new QL4Identifier(ctx.IDENTIFIER().getText());
	  QL4Tree label = new QL4Label(ctx.LABEL().getText());
	  QL4Tree type = new QL4Type(ctx.TYPE().getText());
	  
	  return new QL4Question(id, label, type); 
  }
  

  /**
   * Returns a Question object, containing its content:
   * Type, label, id and value (question.computed is true)
   */
  public QL4Question visitCompQuestion(QL4Parser.CompQuestionContext ctx) {
	  QL4Tree id = new QL4Identifier(ctx.IDENTIFIER().getText());
	  QL4Tree label = new QL4Label(ctx.LABEL().getText());
	  QL4Tree type = new QL4Type(ctx.TYPE().getText());
	  QL4Tree value = ctx.expression().accept(this);
	  
	  return new QL4Question(id, label, type, value); 
  }

  //////////////////////// visiting binair math expressions
  public QL4BraceExpr visitBraceExpr(QL4Parser.BraceExprContext ctx) {
	  return new QL4BraceExpr(ctx.expression().accept(this));
  }
  
  public QL4MultExpr visitMultExpr(QL4Parser.MultExprContext ctx) {
	  QL4Tree lhs = ctx.lhs.accept(this);
	  QL4Tree rhs = ctx.rhs.accept(this);
	  
	  return new QL4MultExpr(lhs, rhs);	  
  }
  
  public QL4DivExpr visitDivExpr(QL4Parser.DivExprContext ctx) {
	  QL4Tree lhs = ctx.lhs.accept(this);
	  QL4Tree rhs = ctx.rhs.accept(this);
	  
	  return new QL4DivExpr(lhs, rhs);	  
  }
  
  public QL4PlusExpr visitPlusExpr(QL4Parser.PlusExprContext ctx) {
	  QL4Tree lhs = ctx.lhs.accept(this);
	  QL4Tree rhs = ctx.rhs.accept(this);
	  
	  return new QL4PlusExpr(lhs, rhs);	  
  }
  
  public QL4MinExpr visitMinExpr(QL4Parser.MinExprContext ctx) {
	  QL4Tree lhs = ctx.lhs.accept(this);
	  QL4Tree rhs = ctx.rhs.accept(this);
	  
	  return new QL4MinExpr(lhs, rhs);	  
  }
  
  //////////////////////// visiting binair logical expressions

  public QL4AndExpr visitAndExpr(QL4Parser.AndExprContext ctx) {
	  QL4Tree lhs = ctx.lhs.accept(this);
	  QL4Tree rhs = ctx.rhs.accept(this);
	  
	  return new QL4AndExpr(lhs, rhs);	  
  }
  
  public QL4OrExpr visitOrExpr(QL4Parser.OrExprContext ctx) {
	  QL4Tree lhs = ctx.lhs.accept(this);
	  QL4Tree rhs = ctx.rhs.accept(this);
	  
	  return new QL4OrExpr(lhs, rhs);	  
  }
  
  public QL4EqExpr visitEqExpr(QL4Parser.EqExprContext ctx) {
	  QL4Tree lhs = ctx.lhs.accept(this);
	  QL4Tree rhs = ctx.rhs.accept(this);
	  
	  return new QL4EqExpr(lhs, rhs);	  
  }
  
  public QL4NeqExpr visitNeqExpr(QL4Parser.NeqExprContext ctx) {
	  QL4Tree lhs = ctx.lhs.accept(this);
	  QL4Tree rhs = ctx.rhs.accept(this);
	  
	  return new QL4NeqExpr(lhs, rhs);	  
  }
  
  public QL4GeqExpr visitGeqExpr(QL4Parser.GeqExprContext ctx) {
	  QL4Tree lhs = ctx.lhs.accept(this);
	  QL4Tree rhs = ctx.rhs.accept(this);
	  
	  return new QL4GeqExpr(lhs, rhs);	  
  }
  
  //////////////////////// visiting QL4 primitives (bool, string etc)
  
  public QL4Bool visitBool(QL4Parser.BoolContext ctx) {
	  return new QL4Bool(ctx.getText());
  }
}
