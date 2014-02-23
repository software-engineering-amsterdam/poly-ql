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
	public Object visitExpression(Form2Parser.ExpressionContext ctx) {
		if (verbose)
			System.out.println("Expression visited");
		
		System.err.println(ctx.getChild(0).toString());
		// if expression is wrapped in (), visit the expression inside
		if (ctx.getChild(0).toString() == "(") {
			if (verbose)
				System.out.println("Expression wrapped in ()");
			
			return this.visit(ctx.expression(0));
		} else {
			if (verbose)
				System.out.println("Expression not wrapped in ()");
			
			return ctx.getText();
		}
	}
}
