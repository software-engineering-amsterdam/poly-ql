package ql.ast;

import org.antlr.v4.runtime.misc.NotNull;

import antlr4.*;

/**
 * QLVisitor class 
 * 
 * Visit the ParseTree for the input and return an AST.
 */
public class MyQLVisitor<T> extends QLBaseVisitor<T> {
	@Override 
	public T visitLtEqOp(@NotNull QLParser.LtEqOpContext ctx) {
		return visitChildren(ctx); 
	}

	@Override 
	public T visitGtEqOp(@NotNull QLParser.GtEqOpContext ctx) { 
		return visitChildren(ctx); 
	}

	@Override
	public T visitLtOp(@NotNull QLParser.LtOpContext ctx) { 
		return visitChildren(ctx); 
		
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
	public T visitAddOp(@NotNull QLParser.AddOpContext ctx) {
		return visitChildren(ctx);
		
	}

	@Override
	public T visitQuestionnaire(@NotNull QLParser.QuestionnaireContext ctx) {
		return visitChildren(ctx); 
		
	}


	@Override 
	public T visitModOp(@NotNull QLParser.ModOpContext ctx) {
		return visitChildren(ctx); 
	}

	@Override
	public T visitEqOp(@NotNull QLParser.EqOpContext ctx) {
		return visitChildren(ctx);
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
	public T visitInt(@NotNull QLParser.IntContext ctx) { 
		return visitChildren(ctx);
		
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
	public T visitNeqOp(@NotNull QLParser.NeqOpContext ctx) {
		return visitChildren(ctx); 
		
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
	public T visitParOp(@NotNull QLParser.ParOpContext ctx) { 
		return visitChildren(ctx);
		
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
	public T visitDivOp(@NotNull QLParser.DivOpContext ctx) { 
		return visitChildren(ctx);
		
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