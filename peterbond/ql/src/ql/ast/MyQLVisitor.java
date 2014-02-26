package ql.ast;

import org.antlr.v4.runtime.misc.NotNull;

import ql.ast.misc.ParOp;
import ql.ast.operators.*;
import ql.ast.expressions.*;
import antlr4.QLBaseVisitor;
import antlr4.QLParser;
import antlr4.QLParser.AddOpContext;
import antlr4.QLParser.DivOpContext;
import antlr4.QLParser.EqOpContext;
import antlr4.QLParser.GtEqOpContext;
import antlr4.QLParser.LtEqOpContext;
import antlr4.QLParser.LtOpContext;
import antlr4.QLParser.ModOpContext;
import antlr4.QLParser.NegOpContext;
import antlr4.QLParser.NeqOpContext;


/**
 * 
 * @author Peter
 */
public class MyQLVisitor extends QLBaseVisitor {
	
	@Override 
	public LtEqOp visitLtEqOp(@NotNull QLParser.LtEqOpContext ctx) {
		LtEqOpContext parent = (LtEqOpContext) ctx.getParent();
		
        return new LtEqOp( (ExprInterface) parent.expr(0).accept(this),
                           (ExprInterface) parent.expr(1).accept(this)
                         );
	}

	@Override 
	public GtEqOp visitGtEqOp(@NotNull QLParser.GtEqOpContext ctx) { 
		GtEqOpContext parent = (GtEqOpContext) ctx.getParent();
		
		return new GtEqOp( (ExprInterface) parent.expr(0).accept(this),
				           (ExprInterface) parent.expr(1).accept(this)
				         );
	}

	@Override
	public LtOp visitLtOp(@NotNull QLParser.LtOpContext ctx) { 
		LtOpContext parent = (LtOpContext) ctx.getParent();
		
		return new LtOp( (ExprInterface) parent.expr(0).accept(this),
		                 (ExprInterface) parent.expr(1).accept(this)
		               );
	}

	@Override
	public T visitIfElseStat(@NotNull QLParser.IfElseStatContext ctx) {
		return visitChildren(ctx); 
		
	}

	@Override
	public T visitBlock(@NotNull QLParser.BlockContext ctx) {
		return visitChildren(ctx); 
		
	}

	@Override
	public T visitType(@NotNull QLParser.TypeContext ctx) {
		return visitChildren(ctx);
		
	}

	@Override 
	public AddOp visitAddOp(@NotNull QLParser.AddOpContext ctx) {
		AddOpContext parent = (AddOpContext) ctx.getParent();
		
		return new AddOp( (ExprInterface) parent.expr(0).accept(this),
				          (ExprInterface) parent.expr(1).accept(this)
				        );
	}

	@Override
	public T visitQuestionnaire(@NotNull QLParser.QuestionnaireContext ctx) {
		return visitChildren(ctx); 
		
	}


	@Override 
	public ModOp visitModOp(@NotNull QLParser.ModOpContext ctx) {
		ModOpContext parent = (ModOpContext) ctx.getParent();
		
		return new ModOp( (ExprInterface) parent.expr(0).accept(this),
				          (ExprInterface) parent.expr(1).accept(this)
				        ); 
	}

	@Override
	public EqOp visitEqOp(@NotNull QLParser.EqOpContext ctx) {
		EqOpContext parent = (EqOpContext) ctx.getParent();
		
		return new EqOp( (ExprInterface) parent.expr(0).accept(this),
				         (ExprInterface) parent.expr(1).accept(this)
				       ); 
	}


	@Override 
	public T visitIfStat(@NotNull QLParser.IfStatContext ctx) {
		return visitChildren(ctx);
	}


	@Override 
	public T visitQuestion(@NotNull QLParser.QuestionContext ctx) {
		return visitChildren(ctx);
	}

	@Override 
	public Integer visitInt(@NotNull QLParser.IntContext ctx) { 
		return Integer.parseInt(ctx.getText());
	}

	@Override
	public T visitQID(@NotNull QLParser.QIDContext ctx) { 
		return visitChildren(ctx); 
		
	}

	@Override
	public T visitAndOp(@NotNull QLParser.AndOpContext ctx) {
		return visitChildren(ctx);
		
	}

	@Override
	public NeqOp visitNeqOp(@NotNull QLParser.NeqOpContext ctx) {
		NeqOpContext parent = (NeqOpContext) ctx.getParent();
		
		return new NeqOp( (ExprInterface) parent.expr(0).accept(this),
				          (ExprInterface) parent.expr(1).accept(this)
				        ); 
	}

	@Override
	public T visitNegOp(@NotNull QLParser.NegOpContext ctx) { 
		return visitChildren(ctx); 
		
	}

	@Override 
	public T visitQitStat(@NotNull QLParser.QitStatContext ctx) { 
		return visitChildren(ctx); 
		
	}


	@Override 
	public T visitMulOp(@NotNull QLParser.MulOpContext ctx) {
		return visitChildren(ctx); 
		
	}


	@Override
	public T visitSubOp(@NotNull QLParser.SubOpContext ctx) {
		return visitChildren(ctx); 
		}


	@Override 
	public T visitGtOp(@NotNull QLParser.GtOpContext ctx) {
		return visitChildren(ctx);
	
	}

	@Override 
	public ParOp visitParOp(@NotNull QLParser.ParOpContext ctx) { 
		return new ParOp( (ExprInterface) ctx.expr().accept(this));
	}

	@Override
	public T visitOrOp(@NotNull QLParser.OrOpContext ctx) { 
		return visitChildren(ctx);
		
	}


	@Override
	public T visitQitExprStat(@NotNull QLParser.QitExprStatContext ctx) {
		return visitChildren(ctx); 
		
	}


	@Override
	public DivOp visitDivOp(@NotNull QLParser.DivOpContext ctx) { 
		DivOpContext parent = (DivOpContext) ctx.getParent();
		
		return new DivOp( (ExprInterface) parent.expr(0).accept(this),
				          (ExprInterface) parent.expr(1).accept(this)
				        ); 
	}


	@Override
	public T visitIdentifier(@NotNull QLParser.IdentifierContext ctx) {
		return visitChildren(ctx); 
		
	}

	@Override 
	public T visitFormname(@NotNull QLParser.FormnameContext ctx) {
		return visitChildren(ctx);
		
	}
}