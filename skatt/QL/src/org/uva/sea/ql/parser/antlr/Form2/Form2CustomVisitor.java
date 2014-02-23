package org.uva.sea.ql.parser.antlr.Form2;

import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

import Form2.Form2BaseVisitor;
import Form2.Form2Parser;
import Form2.Form2Parser.ElseconditionContext;
import Form2.Form2Parser.ElseifconditionContext;
import Form2.Form2Parser.QuestionContext;
import Form2.Form2Parser.StructuresContext;

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
			QuestionContext qctx = ctx.question();
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
			
			if ((boolean) this.visit(ctx.ifcondition())) {
				if (verbose)
					System.out.println("If statement in structure is true");
				this.visit(ctx.structures(0));	
			} else {
				
				if (verbose)
					System.out.println("If statement in structure is false");
				
				// if the 'if statement' was not true, check for elseif en else statements
				boolean visitElse = true; // whether to visit an optional else statement
				
				// check for each elseif statement if its true, if so visit question
				List<ElseifconditionContext> elifctxs = ctx.elseifcondition();
				if (elifctxs != null) {
					for (int i = 0; i < elifctxs.size(); i++) {
						if (verbose)
							System.out.println("Checking elif statement");
						if ((boolean) this.visit(elifctxs.get(i))) {
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
		return 1 == Integer.parseInt((String) this.visit(ctx.expression()));
	}
	
	public Boolean visitElseifcondition(Form2Parser.ElseifconditionContext ctx) {
		if (verbose)
			System.out.println("Elseif condition visited");
		return 1 == Integer.parseInt((String) this.visit(ctx.expression()));
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
	
	public Integer visitMultExpr(Form2Parser.MultExprContext ctx) {
		if (verbose)
			System.out.println("Mult Expression visited");
		
		return 1;
	}
	
	public Integer visitPlusExpr(Form2Parser.PlusExprContext ctx) {
		if (verbose)
			System.out.println("Plus Expression visited");
		
		return 1;
	}
	
	public Boolean visitNegExpr(Form2Parser.NegExprContext ctx) {
		if (verbose)
			System.out.println("Neg Expression visited");
		
		return false;
	}
	
	public Integer visitLogExpr(Form2Parser.LogExprContext ctx) {
		if (verbose)
			System.out.println("Log Expression visited");
		
		return 1;
	}
	
	public Integer visitCompExpr(Form2Parser.CompExprContext ctx) {
		if (verbose)
			System.out.println("Comp Expression visited");
		
		return 1;
	}
	
	public boolean visitIntExpr(Form2Parser.BoolExprContext ctx) {
		if (verbose)
			System.out.println("Boolean Expression visited");
		
		return true;
	}
	
	public Double visitIntExpr(Form2Parser.DecExprContext ctx) {
		if (verbose)
			System.out.println("Int Expression visited");
		
		return 1.0;
	}
	
	public Integer visitIntExpr(Form2Parser.IntExprContext ctx) {
		if (verbose)
			System.out.println("Int Expression visited");
		
		return 1;
	}
	
	public void visitidentExpr(Form2Parser.IdentExprContext ctx) {
		if (verbose)
			System.out.println("Ident Expression visited");
	}
}
