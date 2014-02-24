package ql.ast.visitor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import ql.ast.ID;
import ql.ast.Questionnaire;
import ql.ast.QuestionnaireList;
import ql.ast.expr.IExpr;
import ql.ast.expr.ParensExpr;
import ql.ast.literal.BOOLLiteral;
import ql.ast.literal.NUMLiteral;
import ql.ast.literal.STRINGLiteral;
import ql.ast.op.IOp;
import ql.ast.op.binary.arithmetic.ADD;
import ql.ast.op.binary.arithmetic.DIV;
import ql.ast.op.binary.arithmetic.MUL;
import ql.ast.op.binary.arithmetic.REM;
import ql.ast.op.binary.arithmetic.SUB;
import ql.ast.op.binary.conditional.LA;
import ql.ast.op.binary.conditional.LO;
import ql.ast.op.binary.equality.EQ;
import ql.ast.op.binary.equality.NEQ;
import ql.ast.op.binary.relational.GT;
import ql.ast.op.binary.relational.GTQ;
import ql.ast.op.binary.relational.LT;
import ql.ast.op.binary.relational.LTQ;
import ql.ast.op.unary.NOT;
import ql.ast.op.unary.UM;
import ql.ast.op.unary.UP;
import ql.ast.stat.Assign;
import ql.ast.stat.ComputAssign;
import ql.ast.stat.IStat;
import ql.ast.stat.IfStat;
import ql.ast.stat.type.BOOLEANStatType;
import ql.ast.stat.type.IStatType;
import ql.ast.stat.type.MONEYStatType;
import ql.ast.stat.type.TEXTStatType;
import antlr4_ql.QLBaseVisitor;
import antlr4_ql.QLParser;
import antlr4_ql.QLParser.AdditiveContext;
import antlr4_ql.QLParser.EqualityContext;
import antlr4_ql.QLParser.IfStatContext;
import antlr4_ql.QLParser.MultiplicativeContext;
import antlr4_ql.QLParser.RelationalContext;
import antlr4_ql.QLParser.UnaryContext;

/**
 * Build AST Visitor
 * @author orosu
 */
public class BuildASTVisitor extends QLBaseVisitor<Object>
{
    /**
     * Constructor
     */
    public BuildASTVisitor()
    {
    }

    @Override
    public QuestionnaireList visitInit(@NotNull QLParser.InitContext ctx)
    {
        QuestionnaireList questionnaireList = new QuestionnaireList();

        for (QLParser.FormContext formContext: ctx.form()) {
            questionnaireList.addQuestionnaire(this.visitForm(formContext));
        }
        return questionnaireList;
    }

    @Override
    public Questionnaire visitForm(@NotNull QLParser.FormContext ctx)
    {
        return new Questionnaire(ctx.ID().getText(), visitBlock(ctx.block()));
    }

    @Override
    public List<IStat> visitBlock(@NotNull QLParser.BlockContext ctx)
    {
        List<IStat> statements = new ArrayList<IStat>();
        for(QLParser.StatContext statContext: ctx.stat()) {
            statements.add((IStat) statContext.accept(this));
        }
        return statements;
    }

    @Override
    public BOOLEANStatType visitBOOLEANType(@NotNull QLParser.BOOLEANTypeContext ctx)
    {
        return new BOOLEANStatType();
    }

    @Override
    public MONEYStatType visitMONEYType(@NotNull QLParser.MONEYTypeContext ctx)
    {
        return new MONEYStatType();
    }

    @Override
    public TEXTStatType visitTEXTType(@NotNull QLParser.TEXTTypeContext ctx)
    {
        return new TEXTStatType();
    }

    @Override
    public Assign visitAssign(@NotNull QLParser.AssignContext ctx)
    {
        return new Assign(
            ctx.ID().getText(),
            ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1),
            (IStatType) ctx.statType().accept(this)
        );
    }

    @Override
    public ComputAssign visitComputAssign(@NotNull QLParser.ComputAssignContext ctx)
    {
        return new ComputAssign(
            ctx.ID().getText(),
            ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1),
            (IStatType) ctx.statType().accept(this),
            (IExpr) ctx.expr().accept(this)
        );
    }

    @Override
    public IfStat visitIfStat(@NotNull IfStatContext ctx)
    {
        return new IfStat(
            (IExpr) ctx.expr().accept(this),
            visitBlock(ctx.block()),
            new ArrayList<IStat>()
        );
    }

    @Override
    public IfStat visitIfElseStat(@NotNull QLParser.IfElseStatContext ctx)
    {
        return new IfStat(
            (IExpr) ctx.expr().accept(this),
            visitBlock(ctx.block(0)),
            visitBlock(ctx.block(1))
        );
    }

    @Override
    public IOp visitUnary(@NotNull QLParser.UnaryContext ctx)
    {
        return (IOp) ctx.unaryOp().accept(this);
    }

    @Override
    public UP visitUP(@NotNull QLParser.UPContext ctx)
    {
        return new UP((IExpr) ((UnaryContext) ctx.getParent()).expr().accept(this));
    }

    @Override
    public UM visitUM(@NotNull QLParser.UMContext ctx)
    {
        return new UM((IExpr) ((UnaryContext) ctx.getParent()).expr().accept(this));
    }

    @Override
    public NOT visitNOT(@NotNull QLParser.NOTContext ctx)
    {
        return new NOT((IExpr) ((UnaryContext) ctx.getParent()).expr().accept(this));
    }

    @Override
    public IOp visitMultiplicative(@NotNull QLParser.MultiplicativeContext ctx)
    {
        return (IOp) ctx.multiplicativeOp().accept(this);
    }

    @Override
    public MUL visitMUL(@NotNull QLParser.MULContext ctx)
    {
        MultiplicativeContext parent = (MultiplicativeContext) ctx.getParent();
        return new MUL(
            (IExpr) parent.expr(0).accept(this),
            (IExpr) parent.expr(1).accept(this)
        );
    }

    @Override
    public DIV visitDIV(@NotNull QLParser.DIVContext ctx)
    {
        MultiplicativeContext parent = (MultiplicativeContext) ctx.getParent();
        return new DIV(
            (IExpr) parent.expr(0).accept(this),
            (IExpr) parent.expr(1).accept(this)
        );
    }

    @Override
    public REM visitREM(@NotNull QLParser.REMContext ctx)
    {
        MultiplicativeContext parent = (MultiplicativeContext) ctx.getParent();
        return new REM(
            (IExpr) parent.expr(0).accept(this),
            (IExpr) parent.expr(1).accept(this)
        );
    }

    @Override
    public IOp visitAdditive(@NotNull QLParser.AdditiveContext ctx)
    {
        return (IOp) ctx.additiveOp().accept(this);
    }

    @Override
    public ADD visitADD(@NotNull QLParser.ADDContext ctx)
    {
        AdditiveContext parent = (AdditiveContext) ctx.getParent();
        return new ADD(
            (IExpr) parent.expr(0).accept(this),
            (IExpr) parent.expr(1).accept(this)
        );
    }

    @Override
    public SUB visitSUB(@NotNull QLParser.SUBContext ctx)
    {
        AdditiveContext parent = (AdditiveContext) ctx.getParent();
        return new SUB(
            (IExpr) parent.expr(0).accept(this),
            (IExpr) parent.expr(1).accept(this)
        );
    }

    @Override
    public IOp visitRelational(@NotNull QLParser.RelationalContext ctx)
    {
        return (IOp) ctx.relationalOp().accept(this);
    }

    @Override
    public LT visitLT(@NotNull QLParser.LTContext ctx)
    {
        RelationalContext parent = (RelationalContext) ctx.getParent();
        return new LT(
            (IExpr) parent.expr(0).accept(this),
            (IExpr) parent.expr(1).accept(this)
        );
    }

    @Override
    public GT visitGT(@NotNull QLParser.GTContext ctx)
    {
        RelationalContext parent = (RelationalContext) ctx.getParent();
        return new GT(
            (IExpr) parent.expr(0).accept(this),
            (IExpr) parent.expr(1).accept(this)
        );
    }

    @Override
    public LTQ visitLTQ(@NotNull QLParser.LTQContext ctx)
    {
        RelationalContext parent = (RelationalContext) ctx.getParent();
        return new LTQ(
            (IExpr) parent.expr(0).accept(this),
            (IExpr) parent.expr(1).accept(this)
        );
    }

    @Override
    public GTQ visitGTQ(@NotNull QLParser.GTQContext ctx)
    {
        RelationalContext parent = (RelationalContext) ctx.getParent();
        return new GTQ(
            (IExpr) parent.expr(0).accept(this),
            (IExpr) parent.expr(1).accept(this)
        );
    }

    @Override
    public IOp visitEquality(@NotNull QLParser.EqualityContext ctx)
    {
        return (IOp) ctx.equalityOp().accept(this);
    }

    @Override
    public EQ visitEQ(@NotNull QLParser.EQContext ctx)
    {
        EqualityContext parent = (EqualityContext) ctx.getParent();
        return new EQ(
            (IExpr) parent.expr(0).accept(this),
            (IExpr) parent.expr(1).accept(this)
        );
    }

    @Override
    public NEQ visitNEQ(@NotNull QLParser.NEQContext ctx)
    {
        EqualityContext parent = (EqualityContext) ctx.getParent();
        return new NEQ(
            (IExpr) parent.expr(0).accept(this),
            (IExpr) parent.expr(1).accept(this)
        );
    }

    @Override
    public LA visitLogicalAnd(@NotNull QLParser.LogicalAndContext ctx)
    {
        return new LA((IExpr) ctx.expr(0).accept(this), (IExpr) ctx.expr(1).accept(this));
    }

    @Override
    public LO visitLogicalOr(@NotNull QLParser.LogicalOrContext ctx)
    {
        return new LO((IExpr) ctx.expr(0).accept(this), (IExpr) ctx.expr(1).accept(this));
    }

    @Override
    public BOOLLiteral visitBool(@NotNull QLParser.BoolContext ctx)
    {
        return new BOOLLiteral((Boolean) ctx.boolLiteral().accept(this));
    }

    @Override
    public Boolean visitTRUE(@NotNull QLParser.TRUEContext ctx)
    {
        return true;
    }

    @Override
    public Boolean visitFALSE(@NotNull QLParser.FALSEContext ctx)
    {
        return false;
    }

    @Override
    public ID visitId(@NotNull QLParser.IdContext ctx)
    {
        return new ID(ctx.ID().getText());
    }

    @Override
    public NUMLiteral visitNum(@NotNull QLParser.NumContext ctx)
    {
        return new NUMLiteral((Number) ctx.numLiteral().accept(this));
    }

    @Override
    public BigDecimal visitDec(@NotNull QLParser.DecContext ctx)
    {
        return new BigDecimal(ctx.getText());
    }

    @Override
    public Integer visitInt(@NotNull QLParser.IntContext ctx)
    {
        return Integer.parseInt(ctx.getText());
    }

    @Override
    public STRINGLiteral visitString(@NotNull QLParser.StringContext ctx)
    {
        return new STRINGLiteral(ctx.getText().substring(1, ctx.getText().length()-1));
    }

    @Override
    public ParensExpr visitParens(@NotNull QLParser.ParensContext ctx)
    {
        return new ParensExpr((IExpr) ctx.expr().accept(this));
    }
}
