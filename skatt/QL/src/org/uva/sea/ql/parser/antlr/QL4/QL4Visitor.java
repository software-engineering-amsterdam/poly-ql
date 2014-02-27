package org.uva.sea.ql.parser.antlr.QL4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class QL4Visitor extends QL4BaseVisitor<Value> {

  // Handles the information printed
  boolean verbose = true;
  
  /*
   *  contains all identifiers and their values
   *  Is updated whenever a question is filled in
   *  
   */
  Map<String, Value> variables = new HashMap<String, Value>();
  
  /*
   * contains the questions to be returned
   * questions are added to this list whenever a question is visited
   */
  List<Question> questions = new ArrayList<Question>();
  
  ///////////////////// visiting upper structures
  
  /**
   * Specifies behavior when visiting the form 
   * it will simply visit its structures and return questions
   * generated throughout the visiting process
   * 
   * Upon activation it resets itself by emptying questions
   * 
   * @param ctx is the context of the structures
   * @return dummy value
   */
  public Value visitForm(QL4Parser.FormContext ctx) {
    if (verbose) 
      System.out.println("Checking Form");

    // if applied before, we would want to empty questions
    questions = new ArrayList<Question>();
    
    // visit the rest of the form
    this.visitStructures(ctx.structures());
    return null;
  }
  
  /**
   * Specifies behavior when visiting a workflowStruct. It will evaluate
   * the if/else construction and visit questions of which the dependencies
   * have been evaluated true.
   * 
   * @param ctx is the context of the workflow struct
   * @return dummy null
   */
  public Value visitWorkflowStruct(QL4Parser.WorkflowStructContext ctx) {
    if (verbose) 
      System.out.println("Checking workflow struct");
    
    if ( this.visitIfcondition(ctx.ifcondition()).asBoolean() ) {
      if (verbose) 
        System.out.println("If is correct");
      
      this.visitStructures(ctx.structures(0));
      
    // if was not true, try elseif and eventually else
    } else {
      
      if (verbose) 
        System.out.println("If wrong, checking elseifs");
      
      // Whether to do the else statements
      boolean visitElse = true;
      
      for (int i = 0; i < ctx.elseifcondition().size(); i++) {
        
        if (this.visitElseifcondition(ctx.elseifcondition(i)).asBoolean()) {
          if (verbose) 
            System.out.println("Elseif " + i + " is correct");
          
          visitElse = false;
          this.visitStructures(ctx.structures(i+1));
        }
      }
      
      // if none of the elif statements were true, visit else if present
      if (ctx.elsecondition() != null && visitElse) {
        if (verbose) 
          System.out.println("Found else and no elseifs were correct");
        
        this.visitStructures(ctx.structures(ctx.structures().size()-1));
      }
      
    }
    
    
    return null;
  }
  
  /////////////////////// visiting questions
  /**
   * Specifies behavior when visiting a regQuestionStruct. It will create
   * a question object (without value, if none in memory) and add this to questions.
   * 
   * @param ctx is the context of the structure
   * @return null; dummy 
   */
  public Value visitRegQuestion(QL4Parser.RegQuestionContext ctx) {
    if (verbose) 
      System.out.println("Checking question struct");
    
    // extract information from context
    String ident = ctx.IDENTIFIER().getText();
    String label = ctx.LABEL().getText();
    String type = ctx.TYPE().getText();
    
    // lookup the value from our map
    Value value = variables.get(ident);
    
    // add question to the list
    questions.add(new Question(label, type, value));
    
    return null;
  }

  /**
   * Specifies behavior when visiting a compQuestionStruct. It will create
   * a question object and add this to questions, where the value
   * is automatically calculated if possible
   * 
   * @param ctx is the context of the structure
   * @return null; dummy 
   */
  public Value visitCompQuestion(QL4Parser.CompQuestionContext ctx) {
    if (verbose) 
      System.out.println("Checking computed question");
    
    // extract information from context
    String label = ctx.LABEL().getText();
    String type = ctx.TYPE().getText();
    
    // compute value
    Value value = this.visit(ctx.expression()); 
    
    // add question to list
    questions.add(new Question(label, type, value));
    
    return null;
  }
  
  ///////////////////////// methametical expressions handling
  
  /**
   * Returns the multiplication of the context when visiting
   * the mult expression.
   * @param ctx is the context of the multiplication
   * @return a QLdouble, whose value is the evaluation of the expression
   */
  public Value visitMultExpr(QL4Parser.MultExprContext ctx) {
	  if (verbose) 
		  System.out.println("Visiting mult exp");
	  
	  double evaluation =  this.visit(ctx.expression(0)).asDouble() * 
			  this.visit(ctx.expression(1)).asDouble();
	  
	  return new QLdouble(evaluation);
  }
  
  /**
   * Returns the division of the context when visiting
   * the div expression.
   * @param ctx is the context of the addition
   * @return a QLdouble, whose value is the evaluation of the expression
   */
  public Value visitDivExpr(QL4Parser.DivExprContext ctx) {
	  if (verbose) 
		  System.out.println("Visiting div exp");
	  
	  double evaluation =  this.visit(ctx.expression(0)).asDouble() / 
			  this.visit(ctx.expression(1)).asDouble();
	  
	  return new QLdouble(evaluation);
  }
  
  /**
   * Returns the addition of the context when visiting
   * the plus expression.
   * @param ctx is the context of the addition
   * @return a QLdouble, whose value is the evaluation of the expression
   */
  public Value visitPlusExpr(QL4Parser.PlusExprContext ctx) {
	  if (verbose) 
		  System.out.println("Visiting plus exp");
	  
	  double evaluation =  this.visit(ctx.expression(0)).asDouble() +
			  this.visit(ctx.expression(1)).asDouble();
	  
	  return new QLdouble(evaluation);
  }
  
  /**
   * Returns the subtraction of the context when visiting
   * the plus expression.
   * @param ctx is the context of the subtraction  	
   * @return a QLdouble, whose value is the evaluation of the expression
   */
  public Value visitMinExpr(QL4Parser.MinExprContext ctx) {
	  if (verbose) 
		  System.out.println("Visiting min exp");
	  
	  double evaluation =  this.visit(ctx.expression(0)).asDouble() -
			  this.visit(ctx.expression(1)).asDouble();
	  
	  return new QLdouble(evaluation);
  }
  
  ///////////////////////// logic expressions handling
  
  /**
   * Returns the value of the expression within the wrapper expression
   * (expression) -> valueof(expression)
   * @param is the expression context, in our case ( expression )
   * @return the value of the expression in the brackets
   */
  public Value visitWrapExpr(QL4Parser.WrapExprContext ctx) {
    if (verbose) 
      System.out.println("Visiting wrap expression");
    
    return this.visit(ctx.expression());
  }
  
  /**
   * Returns the evaluation of an equality expression in the 
   * form of a QLboolean
   * TODO: check type
   * @param ctx is the context of the equality expression
   * @return is the evaluation of the equality expression in the form of a QLboolean
   */
  public Value visitEqExpr(QL4Parser.EqExprContext ctx) {
    if (verbose)
      System.out.println("Visiting equality expr");
    
    boolean evaluation = this.visit(ctx.expression(0)).equals(
    		this.visit(ctx.expression(1)));
    
    return new QLboolean(evaluation);
  }
  
  /**
   * Returns the evaluation of an nequality expression in the 
   * form of a QLboolean
   * TODO: check type
   * @param ctx is the context of the nequality expression
   * @return is the evaluation of the nequality expression in the form of a QLboolean
   */
  public Value visitNeqExpr(QL4Parser.NeqExprContext ctx) {
    if (verbose)
      System.out.println("Visiting nequality expr");
    
    boolean evaluation = !this.visit(ctx.expression(0)).equals(
    		this.visit(ctx.expression(1)));
    
    return new QLboolean(evaluation);
  }
  
  /**
   * Returns the evaluation of a greater or equal expression in the form of a QLboolean
   * @param ctx is the context of the greater or equal expression
   * @return is the evaluation of the greater or equal expression in the form of a QLboolean
   */
  public Value visitGeqExpr(QL4Parser.GeqExprContext ctx) {
    if (verbose)
      System.out.println("Visiting greater or equal to expr");
    
    boolean evaluation = (this.visit(ctx.expression(0)).asDouble() 
        >= this.visit(ctx.expression(1)).asDouble());
    
    return new QLboolean(evaluation);
  }
  
  /**
   * Returns the evaluation of a less or equal expression in the form of a QLboolean
   * @param ctx is the context of the less or equal expression
   * @return is the evaluation of the less or equal expression in the form of a QLboolean
   */
  public Value visitLeqExpr(QL4Parser.LeqExprContext ctx) {
    if (verbose)
      System.out.println("Visiting less or equal to expr");
    
    boolean evaluation = (this.visit(ctx.expression(0)).asDouble() 
        <= this.visit(ctx.expression(1)).asDouble());
    
    return new QLboolean(evaluation);
  }
  
  /**
   * Returns the evaluation of a greater than expression in the form of a QLboolean
   * @param ctx is the context of the greater than expression
   * @return is the evaluation of the greater than expression in the form of a QLboolean
   */
  public Value visitGreExpr(QL4Parser.GreExprContext ctx) {
    if (verbose)
      System.out.println("Visiting greater than expr");
    
    boolean evaluation = (this.visit(ctx.expression(0)).asDouble() 
        > this.visit(ctx.expression(1)).asDouble());
    
    return new QLboolean(evaluation);
  }
  
  /**
   * Returns the evaluation of a less expression in the form of a QLboolean
   * @param ctx is the context of the less expression
   * @return is the evaluation of the less expression in the form of a QLboolean
   */
  public Value visitLesExpr(QL4Parser.LesExprContext ctx) {
    if (verbose)
      System.out.println("Visiting less than expr");
    
    boolean evaluation = (this.visit(ctx.expression(0)).asDouble() 
        < this.visit(ctx.expression(1)).asDouble());
    
    return new QLboolean(evaluation);
  }
  
  /**
   * Returns the evaluation of an and expression in the form of a QLboolean
   * @param ctx is the context of the and expression
   * @return is the evaluation of the and expression in the form of a QLboolean
   */
  public Value visitAndExpr(QL4Parser.AndExprContext ctx) {
    if (verbose)
      System.out.println("Visiting and expr");
    
    boolean evaluation = (this.visit(ctx.expression(0)).asBoolean() 
        && this.visit(ctx.expression(1)).asBoolean());
    
    return new QLboolean(evaluation);
  }
  
  /**
   * Returns the evaluation of an or expression in the form of a QLboolean
   * @param ctx is the context of the or expression
   * @return is the evaluation of the or expression in the form of a QLboolean
   */
  public Value visitOrExpr(QL4Parser.OrExprContext ctx) {
    if (verbose)
      System.out.println("Visiting or expr");
    
    boolean evaluation = (this.visit(ctx.expression(0)).asBoolean() 
        || this.visit(ctx.expression(1)).asBoolean());

    System.out.println(evaluation);
    
    return new QLboolean(evaluation);
  }

  /**
   * Returns the negation of the expression in the context 
   * in the form of a QLboolean
   * @param ctx is the context of the neg (!) expression
   * @return a QLboolean whose value is the evaluation of the expression
   */
  public Value visitNegExpr(QL4Parser.NegExprContext ctx) {
	  if (verbose)
		  System.out.println("Visiting ! expr");
	  
	  boolean evaluation = !this.visit(ctx.expression()).asBoolean();
	  
	  return new QLboolean(evaluation);
  }
  /**
   * Creates a QLboolean and returns this
   * @param ctx is the context of the boolean visited
   * @return a QLboolean with the value of the input
   */
  public Value visitBool(QL4Parser.BoolContext ctx) {
    if (verbose) 
      System.out.println("Visiting boolean");
    
    return new QLboolean(ctx.getText());
  }
  
  /**
   * Creates a QLdouble and returns this
   * @param ctx is the context of the dec visited
   * @return a QLdouble with the value of the input
   */
  public Value visitDec(QL4Parser.DecContext ctx) {
    if (verbose) 
      System.out.println("Visiting dec");
    
    return new QLdouble(ctx.getText());
  }
  
  /**
   * Creates a QLint and returns this
   * @param ctx is the context of the int visited
   * @return a QLint with the value of the input
   */
  public Value visitInt(QL4Parser.IntContext ctx) {
    if (verbose) 
      System.out.println("Visiting int");
    
    return new QLinteger(ctx.getText());
  }
  
  /////////////////////////// public get/set functions
  
  /**
   * Getter for the questions accumulated when visiting
   * @return 
   */
  public List<Question> getQuestions() {
    if (verbose) 
      System.out.println("Extracting questions from the visitor");
    
    return questions;
  }
  
}
