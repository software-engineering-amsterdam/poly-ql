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
	 *  TODO
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
		
		String label = ctx.LABEL().getText();
		String type = ctx.TYPE().getText();
		
		// TODO: check if value in memory
		
		questions.add(new Question(label, type));
		
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
		
		String label = ctx.LABEL().getText();
		String type = ctx.TYPE().getText();
		Value value = this.visit(ctx.expression()); // TODO
		
		questions.add(new Question(label, type, value));
		return null;
	}
	
	
	///////////////////////// Expressions handling
	
	/**
	 * Returns the value of the exppresion within the wrapper expression
	 * (expression) -> valueof(expression)
	 * @param is the expression context, in our case ( expression )
	 * @return the value of the expression in the brackets
	 */
	public Value visitWrapExpr(QL4Parser.WrapExprContext ctx) {
		if (verbose) 
			System.out.println("Visiting wrap expression");
		
		return this.visit(ctx.expression());
	}
	
	public Value visitAndExpr(QL4Parser.AndExprContext ctx) {
		if (verbose)
			System.out.println("Visiting and expr");
		
		boolean evaluation = this.visit(ctx.expression(0)).asBoolean() 
				&& this.visit(ctx.expression(1)).asBoolean();
		
		return new QLboolean(evaluation);
	}
	
	public Value visitBool(QL4Parser.BoolContext ctx) {
		if (verbose) 
			System.out.println("Visiting boolean");
		
		return new QLboolean(ctx.getText());
	}
	
	/////////////////////////// public helper functions
	
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
