package ql.ast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import ql.ast.expression.ExpressionInterface;
import ql.ast.expression.ExpressionParentheses;
import ql.ast.literal.LiteralBool;
import ql.ast.literal.LiteralInt;
import ql.ast.operator.OperatorAdd;
import ql.ast.operator.OperatorAnd;
import ql.ast.operator.OperatorDiv;
import ql.ast.operator.OperatorEq;
import ql.ast.operator.OperatorGt;
import ql.ast.operator.OperatorGtEq;
import ql.ast.operator.OperatorLt;
import ql.ast.operator.OperatorLtEq;
import ql.ast.operator.OperatorMod;
import ql.ast.operator.OperatorMul;
import ql.ast.operator.OperatorNeg;
import ql.ast.operator.OperatorNeq;
import ql.ast.operator.OperatorOr;
import ql.ast.operator.OperatorSub;
import ql.ast.statement.StatementAssignment;
import ql.ast.statement.StatementBoolean;
import ql.ast.statement.StatementExpressionAssignment;
import ql.ast.statement.StatementIf;
import ql.ast.statement.StatementInterface;
import ql.ast.statement.StatementMoney;
import ql.ast.statement.StatementString;
import ql.ast.statement.StatementTypeInterface;
import antlr4.TestBaseVisitor;
import antlr4.TestParser;

/**
 *  ASTVisitor class.
 *  
 *  Visits a given parse tree, and generates an AST.
 */
public class ASTVisitor extends TestBaseVisitor<Object> {
	/* Constructor */
	public ASTVisitor() { }

	/* Visit a questionnare item */
	@Override public Questionnare visitQuestionnare(@NotNull TestParser.QuestionnareContext ctx) {
		Questionnare questionnare = new Questionnare();

		/* For every 'form' object in the questionnare, add it to the Questionnare */
		for(TestParser.FormContext frm : ctx.form()) {
			questionnare.add(this.visitForm(frm));
		}

		return questionnare;
	}

	/* Visit a form rule */
	@Override public Form visitForm(@NotNull TestParser.FormContext ctx) {
		return new Form(ctx.ID().getText(), visitBlock(ctx.block()));
	}

	/* Visit a block rule */
	@Override public List<StatementInterface> visitBlock(@NotNull TestParser.BlockContext ctx) {
		List<StatementInterface> statements = new ArrayList<StatementInterface>();

		/* Add all statements into a list */
		for(TestParser.StatementContext stat : ctx.statement()) {
			statements.add((StatementInterface)stat.accept(this));
		}

		return statements;
	}

	/* Visit the negation operator */
	@Override public OperatorNeg visitNeg(@NotNull TestParser.NegContext ctx) {
		return new OperatorNeg((ExpressionInterface) ctx.expr().accept(this));
	}

	/* Visit Parentheses */
	@Override public ExpressionParentheses visitParentheses(@NotNull TestParser.ParenthesesContext ctx) { 
		return new ExpressionParentheses((ExpressionInterface) ctx.expr().accept(this));
	}

	/* Visit If statement */
	@Override public StatementIf visitStatementIf(@NotNull TestParser.StatementIfContext ctx) {
		return new StatementIf(
				(ExpressionInterface) ctx.expr().accept(this),
				visitBlock(ctx.block()),
				new ArrayList<StatementInterface>() /* Empty, because no 'else' */
				);
	}

	/* Visit an if-else statement operator */
	@Override public StatementIf visitStatementIfElse(@NotNull TestParser.StatementIfElseContext ctx) { 
		return new StatementIf(
				(ExpressionInterface) ctx.expr().accept(this),
				visitBlock(ctx.block(1)),
				visitBlock(ctx.block(1))
				);
	}


	/* Visit a question assignment */
	@Override public StatementAssignment visitStatementAssignment(@NotNull TestParser.StatementAssignmentContext ctx) {
		String contents = ctx.STRING().getText();

		return new StatementAssignment(
				ctx.QUESTIONTITLE().getText(),
				contents.substring(1, contents.length() - 1), // Remove the first and last char ("),
				(StatementTypeInterface) ctx.qtype().accept(this)
				);
	}

	/* Visit a question assignment with an expression */
	@Override public StatementExpressionAssignment visitStatementExpressionAssignment(@NotNull TestParser.StatementExpressionAssignmentContext ctx) {
		String contents = ctx.STRING().getText();
		
		return new StatementExpressionAssignment(
				ctx.QUESTIONTITLE().getText(),
				contents.substring(1, contents.length() - 1), // Remove the first and last char ("),
				(StatementTypeInterface) ctx.qtype().accept(this),
				(ExpressionInterface) ctx.expr().accept(this)
				);				
	}
	
	/* Visit a boolean statement */
	@Override public StatementBoolean visitStatementBoolean(@NotNull TestParser.StatementBooleanContext ctx) {
		return new StatementBoolean();		
	}

	/* Visit a string statement */
	@Override public StatementString visitStatementString(@NotNull TestParser.StatementStringContext ctx) { 
		return new StatementString();
	}

	/* Visit a money statement */
	@Override public StatementMoney visitStatementMoney(@NotNull TestParser.StatementMoneyContext ctx) { 
		return new StatementMoney();
	}

	/* Visit a logical AND operator */
	@Override public OperatorAnd visitAnd(@NotNull TestParser.AndContext ctx) { 
		return new OperatorAnd(
				(ExpressionInterface) ctx.expr(0).accept(this),
				(ExpressionInterface) ctx.expr(1).accept(this)
				);		
	}

	/* Visit a logical OR operator*/
	@Override public OperatorOr visitOr(@NotNull TestParser.OrContext ctx) { 
		return new OperatorOr(
				(ExpressionInterface) ctx.expr(0).accept(this),
				(ExpressionInterface) ctx.expr(1).accept(this)
				);
	}

	/* Visit less than operator */
	@Override public OperatorLt visitLt(@NotNull TestParser.LtContext ctx) { 
		return new OperatorLt(
				(ExpressionInterface) ctx.expr(0).accept(this), 
				(ExpressionInterface) ctx.expr(1).accept(this) 				
				);
	}

	/* Visit less than or equal operator */
	@Override public OperatorLtEq visitLtEq(@NotNull TestParser.LtEqContext ctx) { 
		return new OperatorLtEq(
				(ExpressionInterface) ctx.expr(0).accept(this), 
				(ExpressionInterface) ctx.expr(1).accept(this) 
				);				
	}

	/* Visit greater than operator */
	@Override public OperatorGt visitGt(@NotNull TestParser.GtContext ctx) {
		return new OperatorGt(
				(ExpressionInterface) ctx.expr(0).accept(this), 
				(ExpressionInterface) ctx.expr(1).accept(this) 				
				);		
	}

	/* Visit the greater than or equal operator */
	@Override public Object visitGtEq(@NotNull TestParser.GtEqContext ctx) { 
		return new OperatorGtEq(
				(ExpressionInterface) ctx.expr(0).accept(this), 
				(ExpressionInterface) ctx.expr(1).accept(this) 				
				);		
	}

	/* Visit not equal operator */
	@Override public OperatorNeq visitNeq(@NotNull TestParser.NeqContext ctx) { 
		return new OperatorNeq(
				(ExpressionInterface) ctx.expr(0).accept(this), 
				(ExpressionInterface) ctx.expr(1).accept(this) 				
				);
	}

	/* Visit an equal to operator */
	@Override public OperatorEq visitEq(@NotNull TestParser.EqContext ctx) { 
		return new OperatorEq(
				(ExpressionInterface) ctx.expr(0).accept(this), 
				(ExpressionInterface) ctx.expr(1).accept(this) 				
				);
	}

	/* Visit a modulo statement */
	@Override public OperatorMod visitMod(@NotNull TestParser.ModContext ctx) { 
		return new OperatorMod( 
				(ExpressionInterface) ctx.expr(0).accept(this), 
				(ExpressionInterface) ctx.expr(1).accept(this) 
				);		
	}

	/* Visit the addition operator */
	@Override public OperatorAdd visitAdd(@NotNull TestParser.AddContext ctx) { 
		return new OperatorAdd( 
				(ExpressionInterface) ctx.expr(0).accept(this), 
				(ExpressionInterface) ctx.expr(1).accept(this) 
				);
	}

	/* Visit the subtraction operator */
	@Override public OperatorSub visitSub(@NotNull TestParser.SubContext ctx) { 
		return new OperatorSub( 
				(ExpressionInterface) ctx.expr(0).accept(this), 
				(ExpressionInterface) ctx.expr(1).accept(this) 
				);
	}

	/* Visit a division statement */
	@Override public OperatorDiv visitDiv(@NotNull TestParser.DivContext ctx) {
		return new OperatorDiv( 
				(ExpressionInterface) ctx.expr(0).accept(this), 
				(ExpressionInterface) ctx.expr(1).accept(this) 
				);
	}

	/* Visit a multiply operator */
	@Override public OperatorMul visitMul(@NotNull TestParser.MulContext ctx) { 
		return new OperatorMul( 
				(ExpressionInterface) ctx.expr(0).accept(this), 
				(ExpressionInterface) ctx.expr(1).accept(this) 
				);
	}

	/* Visit decimal literal */
	@Override public BigDecimal visitDecimal(@NotNull TestParser.DecimalContext ctx) { 
		return new BigDecimal(ctx.getText());
	}

	/* Visit an integer literal */
	@Override public Integer visitInteger(@NotNull TestParser.IntegerContext ctx) { 
		return Integer.parseInt(ctx.getText());		
	}

	/* Visit the 'false' literal */ 
	@Override public Boolean visitLiteralFalse(@NotNull TestParser.LiteralFalseContext ctx) { 
		return false; 
	}


	/* Visit a bool literal */
	@Override public LiteralBool visitLiteralBool(@NotNull TestParser.LiteralBoolContext ctx) {
		return new LiteralBool((Boolean) ctx.boolLit().accept(this));
	}

	/* Visit an integer literal */
	@Override public LiteralInt visitLiteralInt(@NotNull TestParser.LiteralIntContext ctx) {
		return new LiteralInt((Integer) ctx.intLit().accept(this));
	}

	/* Visit the 'true' literal */
	@Override public Boolean visitLiteralTrue(@NotNull TestParser.LiteralTrueContext ctx) { 
		return false;		
	}
}
