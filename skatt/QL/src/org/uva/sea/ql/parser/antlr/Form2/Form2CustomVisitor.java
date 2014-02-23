package org.uva.sea.ql.parser.antlr.Form2;

import java.security.InvalidParameterException;
import java.util.List;


import Form2.Form2BaseVisitor;
import Form2.Form2Parser;

public class Form2CustomVisitor extends Form2BaseVisitor {
	
	// set for workflow prints
	boolean verbose = true;
	//////////// code for handling if/else structure
	
	public Object visitStructure(Form2Parser.StructureContext ctx) {
		
		if (verbose)
			System.out.println("Visiting a structure");
		
		// if single child, no workflow conditions apply and simply visit the only child (structures or question)
		if (ctx.getChildCount() == 1) { 
			
			// the question in structure
			Form2Parser.QuestionContext qctx = ctx.question();
			if (qctx != null) { // if no question
				if (verbose) 
					System.out.println("Found a question in structure");
				this.visit(qctx);
			}
			// structure contains structures in stead of question
			else { 
				if (verbose)
					System.out.println("No if statements found in structure");
				this.visit(ctx.structures(0));
			}
		} else { 
			// if workflow is applied, only visit questions which return a true expression
			if (verbose)
				System.out.println("If statement found in structure");
			
			if (convertToBool(this.visit(ctx.ifcondition()))) {
				if (verbose)
					System.out.println("If statement in structure is true");
				this.visit(ctx.structures(0));	
			} else {
				
				if (verbose)
					System.out.println("If statement in structure is false");
				
				// if the 'if statement' was not true, check for elseif en else statements
				boolean visitElse = true; // whether to visit an optional else statement
				
				// check for each elseif statement if its true, if so visit question
				List<Form2Parser.ElseifconditionContext> elifctxs = ctx.elseifcondition();
				if (elifctxs != null) {
					for (int i = 0; i < elifctxs.size(); i++) {
						if (verbose)
							System.out.println("Checking elif statement");
						if (convertToBool(this.visit(elifctxs.get(i)))) {
							// if elseif statement is true
							if (verbose)
								System.out.println("Elif statement is true");
							visitElse = false; // do not check else statement anymore
							this.visit(ctx.structures(i + 1)); // visit the structure of the elseif statement 
							break; // do not check other elseif statements anymore by breaking out of loop
						}
					}
				}
				
				// if no 'elseif' statements were true visit else statement if available
				if (visitElse && (ctx.elsecondition() != null)) {
					if (verbose)
						System.out.println("Else statement is 'true'");
					this.visit(ctx.structures(ctx.structures().size() - 1));
				}
			
			}
		}
		
		return null;
	}
	

	public Boolean visitIfcondition(Form2Parser.IfconditionContext ctx) {
		if (verbose)
			System.out.println("If condition visited");

		return convertToBool(this.visit(ctx.expression()));
	}
	
	public Boolean visitElseifcondition(Form2Parser.ElseifconditionContext ctx) {
		if (verbose)
			System.out.println("Elseif condition visited");
		return convertToBool(this.visit(ctx.expression()));
	}
	
	/////////// Code for handling visited questions
	
	public Object visitQuestion(Form2Parser.QuestionContext ctx) {
		System.out.println("The question " + ctx.IDENTIFIER() + " of type " + ctx.TYPE() + " is:");
		System.out.println(this.visit(ctx.label()));
		return null;
	}
	public Object visitLabel(Form2Parser.LabelContext ctx) {
		return ctx.getText();
	}
	
	/////////// Code for handling expressions 
	
	public Object visitWrapExpr(Form2Parser.WrapExprContext ctx) {
		if (verbose)
			System.out.println("Wrap Expression visited");
		
		return this.visit(ctx.expression());
	}
	
	/**
	 * Returns the mathematical result of the expression, depending on the actual mathematical operator
	 * @param ctx is the context to evaluate 
	 * @return is the evaluation of the expression
	 * @throws invalidparameter if operator is not * or /
	 */
	public Double visitMultExpr(Form2Parser.MultExprContext ctx) {
		if (verbose)
			System.out.println("Mult Expression visited");
		
		// the operator used in the expression (either + or -)
		String op = ctx.getChild(1).getText();
		
		// if + operator
		if (op.equals("*")) {
			if (verbose)
				System.out.println("Mult expression contains *");
			
			return (convertToNumber(this.visit(ctx.expression(0))) *
					convertToNumber(this.visit(ctx.expression(1))));
			
		} else if (op.equals("/")) { // if - operator
			if (verbose)
				System.out.println("Mult expression contains /");
			
			return (convertToNumber(this.visit(ctx.expression(0))) /
					convertToNumber(this.visit(ctx.expression(1))));
			
		} else { // error if neither - or +
			System.err.println("Invalid operator for visitMultExpr...");
			throw new InvalidParameterException();
		}
	}
	
	/**
	 * Returns the mathematical result of the expression, depending on the actual mathematical operator
	 * @param ctx is the context to evaluate 
	 * @return is the evaluation of the expression
	 * @throws invalidparameter if operator is not + or -
	 */
	public Double visitPlusExpr(Form2Parser.PlusExprContext ctx) {
		if (verbose)
			System.out.println("Plus Expression visited");
		
		// the operator used in the expression (either + or -)
		String op = ctx.getChild(1).getText();
		
		// if + operator
		if (op.equals("+")) {
			if (verbose)
				System.out.println("PLus expression contains +");
			
			return (convertToNumber(this.visit(ctx.expression(0))) + 
					convertToNumber(this.visit(ctx.expression(1))));
			
		} else if (op.equals("-")) { // if - operator
			if (verbose)
				System.out.println("PLus expression contains -");
			
			return (convertToNumber(this.visit(ctx.expression(0))) -
					convertToNumber(this.visit(ctx.expression(1))));
			
		} else { // error if neither - or +
			System.err.println("Invalid operator for visitPlusExpr...");
			throw new InvalidParameterException();
		}
	}
	
	/**
	 * Returns the negative of the expression
	 * @param ctx is the expression to be negated
	 * @return is the negation of the expression
	 */
	public Boolean visitNegExpr(Form2Parser.NegExprContext ctx) {
		if (verbose)
			System.out.println("Neg Expression visited");
		
		return !(convertToBool(this.visit(ctx.expression())));
	}
	
	/**
	 * Returns the logical result of the expression, depending on the actual logical operator
	 * @param ctx is the context to evaluate 
	 * @return is the evaluation of the expression
	 * @throws invalidparameter if operator is not && or ||
	 */
	public Boolean visitLogExpr(Form2Parser.LogExprContext ctx) {
		if (verbose)
			System.out.println("Log Expression visited");
		
		String op = ctx.getChild(1).getText();
		// if && logical expression
		if (op.equals("&&")) {
			if (verbose) 
				System.out.println("Log expression is a &&");
			
			// return the && combination of the two inner expressions
			return convertToBool(this.visit(ctx.expression(0))) && 
					convertToBool(this.visit(ctx.expression(1)));
			
		} else if(op.equals("||")) { // if || logical expression
			if (verbose) 
				System.out.println("Log expression is a ||");
			
			// return the || combination of the two inner expressions
			return convertToBool(this.visit(ctx.expression(0))) || 
					convertToBool(this.visit(ctx.expression(1)));	
		} else { // if somehow this expression does not contain && or ||, throw error
			System.err.println("Invalid log expression...");
            throw new InvalidParameterException();
		}
	}
	
	/**
	 * Returns the compared result of the expression, depending on the actual comparison method
	 * @param ctx is the context to be compared expression
	 * @return is the evaluation of the expression
	 */
	public Integer visitCompExpr(Form2Parser.CompExprContext ctx) {
		if (verbose)
			System.out.println("Comp Expression visited");
		
		// TODO
		System.err.println("Still need to implement the compare expression visitor");
		return 1;
	}
	
	/**
	 * Returns the boolean value of the visited ctx
	 * @param ctx the boolean being visited
	 * @return the value of the boolean (true or false, casted from string)
	 */
	public Boolean visitBoolExpr(Form2Parser.BoolExprContext ctx) {
		if (verbose)
			System.out.println("Boolean Expression visited");
		
		return true;
	}
	
	/**
	 * Returns the value of the double being visited
	 * @param ctx is the double being visited
	 * @return the value of the ctx (cast to double)
	 */
	public Double visitDecExpr(Form2Parser.DecExprContext ctx) {
		if (verbose)
			System.out.println("Int Expression visited");
		
		return Double.valueOf(ctx.getText());
	}

	/**
	 * Returns the integer being visited
	 * @param ctx is the integer being visited
	 * @return the value of ctx cast to int
	 */
	public Integer visitIntExpr(Form2Parser.IntExprContext ctx) {
		if (verbose)
			System.out.println("Int Expression visited");
		
		return Integer.valueOf(ctx.getText());
	}
	
	/**
	 * Returns the value of the identifier being visited, or null if not set yet
	 * @param ctx the identifier
	 * @return the value (object)
	 */
	public Object visitIdentExpr(Form2Parser.IdentExprContext ctx) {
		if (verbose)
			System.out.println("Ident Expression visited");
		
		// TODO: return from a map where al identifiers and their values are stored
		System.err.println("Still need to implement the compare expression visitor");
		return ctx.getText();
	}
	
	///////////////// parsing / casting / converting functions
	/**
	 * Converts any object of an expression to a boolean 
	 * "1", "1.0"  or "true" will return true, the rest will return false
	 * @param obj the object to convert
	 * @return the converted value (boolean)
	 */
	private boolean convertToBool(Object obj) {
		return (obj.toString().equals("true") 
				|| obj.toString().equals("1")
				|| obj.toString().equals("1.0"));
	}
	
	/**
	 * Converts any object of an expression to a integer
	 * @param obj the object to convert
	 * @return the converted value (int)
	 */
	private double convertToNumber(Object obj) {
		return (Double.valueOf(obj.toString()));
	}
}
