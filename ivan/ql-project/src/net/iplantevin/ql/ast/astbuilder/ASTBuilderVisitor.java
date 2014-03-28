package net.iplantevin.ql.ast.astbuilder;

import net.iplantevin.ql.antlr.QLBaseVisitor;
import net.iplantevin.ql.antlr.QLParser;
import net.iplantevin.ql.ast.ASTNode;
import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.expressions.Par;
import net.iplantevin.ql.ast.expressions.literals.Bool;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.expressions.literals.Int;
import net.iplantevin.ql.ast.expressions.literals.Str;
import net.iplantevin.ql.ast.expressions.operators.Add;
import net.iplantevin.ql.ast.expressions.operators.And;
import net.iplantevin.ql.ast.expressions.operators.Binary;
import net.iplantevin.ql.ast.expressions.operators.Div;
import net.iplantevin.ql.ast.expressions.operators.EQ;
import net.iplantevin.ql.ast.expressions.operators.GEQ;
import net.iplantevin.ql.ast.expressions.operators.GT;
import net.iplantevin.ql.ast.expressions.operators.LEQ;
import net.iplantevin.ql.ast.expressions.operators.LT;
import net.iplantevin.ql.ast.expressions.operators.Mul;
import net.iplantevin.ql.ast.expressions.operators.NEQ;
import net.iplantevin.ql.ast.expressions.operators.Neg;
import net.iplantevin.ql.ast.expressions.operators.Not;
import net.iplantevin.ql.ast.expressions.operators.Or;
import net.iplantevin.ql.ast.expressions.operators.Pos;
import net.iplantevin.ql.ast.expressions.operators.Sub;
import net.iplantevin.ql.ast.expressions.operators.Unary;
import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.form.FormCollection;
import net.iplantevin.ql.ast.statements.Block;
import net.iplantevin.ql.ast.statements.Computation;
import net.iplantevin.ql.ast.statements.If;
import net.iplantevin.ql.ast.statements.IfElse;
import net.iplantevin.ql.ast.statements.Question;
import net.iplantevin.ql.ast.statements.Statement;
import net.iplantevin.ql.ast.types.BooleanType;
import net.iplantevin.ql.ast.types.IntegerType;
import net.iplantevin.ql.ast.types.StringType;
import net.iplantevin.ql.ast.types.Type;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;

/**
 * Visitor that creates an custom AST from the antlr tree.
 *
 * @author Ivan
 */
public class ASTBuilderVisitor extends QLBaseVisitor<ASTNode> {
    /**
     *
     */
    private void dieWithOperatorError() {
        System.err.println("No matching operator found!");
        System.exit(1);
    }

    /**
     *
     */
    @Override
    public FormCollection visitForms(@NotNull QLParser.FormsContext ctx) {
        ArrayList<Form> forms = new ArrayList<Form>();
        for (QLParser.FormContext formCtx : ctx.form()) {
            forms.add((Form) formCtx.accept(this));
        }
        return new FormCollection(forms, new LineInfo(ctx));
    }

    /**
     *
     */
    @Override
    public Form visitForm(@NotNull QLParser.FormContext ctx) {
        String name = ctx.ID().getText();
        Block body = (Block) ctx.block().accept(this);
        return new Form(name, body, new LineInfo(ctx));
    }

    /**
     *
     */
    @Override
    public Block visitBlock(@NotNull QLParser.BlockContext ctx) {
        ArrayList<Statement> statements = new ArrayList<Statement>();
        for (QLParser.StatContext statCtx : ctx.stat()) {
            statements.add((Statement) statCtx.accept(this));
        }
        return new Block(statements, new LineInfo(ctx));
    }

    /**
     *
     */
    @Override
    public IfElse visitIfElse(@NotNull QLParser.IfElseContext ctx) {
        Expression condition = (Expression) ctx.expr().accept(this);
        Statement body = (Statement) ctx.stat().get(0).accept(this);
        Statement elseBody = (Statement) ctx.stat().get(1).accept(this);
        return new IfElse(condition, body, elseBody, new LineInfo(ctx));
    }

    /**
     *
     */
    @Override
    public If visitIf(@NotNull QLParser.IfContext ctx) {
        Expression condition = (Expression) ctx.expr().accept(this);
        Statement body = (Statement) ctx.stat().accept(this);
        return new If(condition, body, new LineInfo(ctx));
    }

    /**
     *
     */
    @Override
    public Block visitBlockStat(@NotNull QLParser.BlockStatContext ctx) {
        return (Block) ctx.block().accept(this);
    }

    /**
     *
     */
    @Override
    public Computation visitComputation(@NotNull QLParser.ComputationContext ctx) {
        Type type = ((Expression) ctx.type().accept(this)).getType(null);

        LineInfo lineInfo = new LineInfo(ctx.ID().getSymbol().getLine(),
                ctx.ID().getSymbol().getCharPositionInLine());
        ID name = new ID(ctx.ID().getText(), lineInfo);

        lineInfo = new LineInfo(ctx.STR().getSymbol().getLine(),
                ctx.STR().getSymbol().getCharPositionInLine());
        Str label = new Str(ctx.STR().getText(), lineInfo);

        Expression expression = (Expression) ctx.expr().accept(this);
        return new Computation(name, label, type, expression, new LineInfo(ctx));
    }

    /**
     *
     */
    @Override
    public Question visitQuestion(@NotNull QLParser.QuestionContext ctx) {
        Type type = ((Expression) ctx.type().accept(this)).getType(null);

        LineInfo lineInfo = new LineInfo(ctx.ID().getSymbol().getLine(),
                ctx.ID().getSymbol().getCharPositionInLine());
        ID name = new ID(ctx.ID().getText(), lineInfo);

        lineInfo = new LineInfo(ctx.STR().getSymbol().getLine(),
                ctx.STR().getSymbol().getCharPositionInLine());
        Str label = new Str(ctx.STR().getText(), lineInfo);
        return new Question(name, label, type, new LineInfo(ctx));
    }

    /**
     *
     */
    @Override
    public Bool visitBoolType(@NotNull QLParser.BoolTypeContext ctx) {
        return new Bool(true, null);
    }

    /**
     *
     */
    @Override
    public Int visitIntType(@NotNull QLParser.IntTypeContext ctx) {
        return new Int(0, null);
    }

    /**
     *
     */
    @Override
    public Str visitStrType(@NotNull QLParser.StrTypeContext ctx) {
        return new Str("  ", null);
    }

    /**
     *
     */
    @Override
    public Bool visitTrue(@NotNull QLParser.TrueContext ctx) {
        return new Bool(true, new LineInfo(ctx));
    }

    /**
     *
     */
    @Override
    public Bool visitFalse(@NotNull QLParser.FalseContext ctx) {
        return new Bool(false, new LineInfo(ctx));
    }

    /**
     *
     */
    @Override
    public Unary visitUnary(@NotNull QLParser.UnaryContext ctx) {
        Expression expression = (Expression) ctx.expr().accept(this);
        switch (ctx.op.getType()) {
            case QLParser.ADD:
                return new Pos(expression, new LineInfo(ctx.ADD()));
            case QLParser.SUB:
                return new Neg(expression, new LineInfo(ctx.SUB()));
            case QLParser.NOT:
                return new Not(expression, new LineInfo(ctx.NOT()));
        }
        dieWithOperatorError();
        return null;
    }

    /**
     * Note: also division.
     */
    @Override
    public Binary visitMultiplication(@NotNull QLParser.MultiplicationContext ctx) {
        Expression leftExpr = (Expression) ctx.expr().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expr().get(1).accept(this);
        switch (ctx.op.getType()) {
            case QLParser.MUL:
                return new Mul(leftExpr, rightExpr, new LineInfo(ctx.MUL()));
            case QLParser.DIV:
                return new Div(leftExpr, rightExpr, new LineInfo(ctx.DIV()));
        }
        dieWithOperatorError();
        return null;
    }

    /**
     * Note: also subtraction.
     */
    @Override
    public Binary visitAddition(@NotNull QLParser.AdditionContext ctx) {
        Expression leftExpr = (Expression) ctx.expr().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expr().get(1).accept(this);
        switch (ctx.op.getType()) {
            case QLParser.ADD:
                return new Add(leftExpr, rightExpr, new LineInfo(ctx.ADD()));
            case QLParser.SUB:
                return new Sub(leftExpr, rightExpr, new LineInfo(ctx.SUB()));
        }
        dieWithOperatorError();
        return null;
    }

    /**
     * Note: all relational operators!
     */
    @Override
    public Binary visitRelational(@NotNull QLParser.RelationalContext ctx) {
        Expression leftExpr = (Expression) ctx.expr().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expr().get(1).accept(this);
        switch (ctx.op.getType()) {
            case QLParser.LT:
                return new LT(leftExpr, rightExpr, new LineInfo(ctx.LT()));
            case QLParser.GT:
                return new GT(leftExpr, rightExpr, new LineInfo(ctx.GT()));
            case QLParser.LEQ:
                return new LEQ(leftExpr, rightExpr, new LineInfo(ctx.LEQ()));
            case QLParser.GEQ:
                return new GEQ(leftExpr, rightExpr, new LineInfo(ctx.GEQ()));
        }
        dieWithOperatorError();
        return null;
    }

    /**
     * Note: also NEQ.
     */
    @Override
    public Binary visitEquality(@NotNull QLParser.EqualityContext ctx) {
        Expression leftExpr = (Expression) ctx.expr().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expr().get(1).accept(this);
        switch (ctx.op.getType()) {
            case QLParser.EQ:
                return new EQ(leftExpr, rightExpr, new LineInfo(ctx.EQ()));
            case QLParser.NEQ:
                return new NEQ(leftExpr, rightExpr, new LineInfo(ctx.NEQ()));
        }
        dieWithOperatorError();
        return null;
    }

    /**
     *
     */
    @Override
    public And visitLogicalAnd(@NotNull QLParser.LogicalAndContext ctx) {
        Expression leftExpr = (Expression) ctx.expr().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expr().get(1).accept(this);
        return new And(leftExpr, rightExpr, new LineInfo(ctx.AND()));
    }

    /**
     *
     */
    @Override
    public Or visitLogicalOr(@NotNull QLParser.LogicalOrContext ctx) {
        Expression leftExpr = (Expression) ctx.expr().get(0).accept(this);
        Expression rightExpr = (Expression) ctx.expr().get(1).accept(this);
        return new Or(leftExpr, rightExpr, new LineInfo(ctx.OR()));
    }

    /**
     *
     */
    @Override
    public Bool visitBoolean(@NotNull QLParser.BooleanContext ctx) {
        return (Bool) ctx.bool().accept(this);
    }

    /**
     *
     */
    @Override
    public ID visitIdentifier(@NotNull QLParser.IdentifierContext ctx) {
        return new ID(ctx.ID().getText(), new LineInfo(ctx));
    }

    /**
     *
     */
    @Override
    public Int visitInteger(@NotNull QLParser.IntegerContext ctx) {
        String stringValue = ctx.INT().getText();
        return new Int(Integer.valueOf(stringValue), new LineInfo(ctx));
    }

    /**
     *
     */
    @Override
    public Str visitString(@NotNull QLParser.StringContext ctx) {
        return new Str(ctx.STR().getText(), new LineInfo(ctx));
    }

    /**
     *
     */
    @Override
    public Par visitParantheses(@NotNull QLParser.ParanthesesContext ctx) {
        return new Par((Expression) ctx.expr().accept(this), new LineInfo(ctx));
    }
}