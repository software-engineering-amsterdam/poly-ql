package ql.ast;

import java.math.BigDecimal;
import java.util.Iterator;

import org.antlr.v4.runtime.misc.NotNull;

import ql.ast.expression.IExpression;
import ql.ast.expression.Id;
import ql.ast.expression.ParenthesesExpression;
import ql.ast.expression.arithmetic.Add;
import ql.ast.expression.arithmetic.Divide;
import ql.ast.expression.arithmetic.Multiply;
import ql.ast.expression.arithmetic.Remainder;
import ql.ast.expression.arithmetic.Subtract;
import ql.ast.expression.arithmetic.UnaryMinus;
import ql.ast.expression.arithmetic.UnaryPlus;
import ql.ast.expression.comparison.Equal;
import ql.ast.expression.comparison.GreaterThan;
import ql.ast.expression.comparison.GreaterThanEqual;
import ql.ast.expression.comparison.LessThan;
import ql.ast.expression.comparison.LessThanEqual;
import ql.ast.expression.comparison.NotEqual;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.DecimalLiteral;
import ql.ast.expression.literal.IEnumElement;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.NumberLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.expression.logical.LogicalAnd;
import ql.ast.expression.logical.LogicalOr;
import ql.ast.expression.logical.Not;
import ql.ast.expression_value.BooleanValue;
import ql.ast.statement.Assignment;
import ql.ast.statement.Block;
import ql.ast.statement.ComputedAssignment;
import ql.ast.statement.IStatement;
import ql.ast.statement.IfStatement;
import ql.ast.statement.StatementList;
import ql.ast.type.BooleanType;
import ql.ast.type.DateType;
import ql.ast.type.DecimalType;
import ql.ast.type.EnumType;
import ql.ast.type.IntegerType;
import ql.ast.type.MoneyType;
import ql.ast.type.RangeType;
import ql.ast.type.StringType;
import ql.ast.type.Type;
import ql.ast.visitor_elements.IElement;
import antlr4_ql.QLBaseVisitor;
import antlr4_ql.QLParser;
import antlr4_ql.QLParser.IfStatementContext;

/**
 * @author orosu
 */
public class AstBuilderVisitor extends QLBaseVisitor<IElement>
{
    public AstBuilderVisitor()
    {
    }

    @Override
    public QuestionnaireList visitForms(@NotNull QLParser.FormsContext ctx)
    {
        QuestionnaireList questionnaireList = new QuestionnaireList();

        for (QLParser.FormContext formContext: ctx.form()) {
            questionnaireList.add(this.visitForm(formContext));
        }
        return questionnaireList;
    }

    @Override
    public Questionnaire visitForm(@NotNull QLParser.FormContext ctx)
    {
        return new Questionnaire(ctx.ID().getText(), visitBlock(ctx.block()));
    }

    @Override
    public Block visitBlock(@NotNull QLParser.BlockContext ctx)
    {
        StatementList statementList = new StatementList();
        for(QLParser.StatementContext statementContext: ctx.statement()) {
            statementList.add((IStatement) statementContext.accept(this));
        }
        return new Block(statementList);
    }

    @Override
    public BooleanType visitBooleanType(@NotNull QLParser.BooleanTypeContext ctx)
    {
        return new BooleanType();
    }

    @Override
    public IntegerType visitIntegerType(@NotNull QLParser.IntegerTypeContext ctx)
    {
        return new IntegerType();
    }

    @Override
    public DecimalType visitDecimalType(@NotNull QLParser.DecimalTypeContext ctx)
    {
        return new DecimalType();
    }

    @Override
    public MoneyType visitMoneyType(@NotNull QLParser.MoneyTypeContext ctx)
    {
        return new MoneyType();
    }

    @Override
    public DateType visitDateType(@NotNull QLParser.DateTypeContext ctx)
    {
        return new DateType();
    }

    @Override
    public StringType visitStringType(@NotNull QLParser.StringTypeContext ctx)
    {
        return new StringType();
    }

    @Override
    public EnumType visitEnumType(@NotNull QLParser.EnumTypeContext ctx)
    {
        return (EnumType) ctx.enumTypeP().accept(this);
    }

    @Override
    public EnumType visitStringEnum(@NotNull QLParser.StringEnumContext ctx)
    {
        EnumType enumType = new EnumType();
        String value = ctx.STRING().getText();
        enumType.addElement(new StringLiteral(value.substring(1, value.length()-1)));

        // Check if there are other elements
        if (ctx.enumTypeP() == null) {
            return enumType;
        }

        return this._visitEnumTypeTail(enumType, (EnumType) ctx.enumTypeP().accept(this));
    }

    @Override
    public EnumType visitNumberEnum(@NotNull QLParser.NumberEnumContext ctx)
    {
        EnumType enumType = new EnumType();
        enumType.addElement((NumberLiteral) ctx.numberLiteralP().accept(this));

        // Check if there are other elements
        if (ctx.enumTypeP() == null) {
            return enumType;
        }

        return this._visitEnumTypeTail(enumType, (EnumType) ctx.enumTypeP().accept(this));
    }

    @Override
    public RangeType visitIntegerRangeType(@NotNull QLParser.IntegerRangeTypeContext ctx)
    {
        return new RangeType(
            new IntegerLiteral(Integer.parseInt(ctx.INT(0).getText())),
            new IntegerLiteral(Integer.parseInt(ctx.INT(1).getText()))
        );
    }

    @Override
    public Assignment visitAssignment(@NotNull QLParser.AssignmentContext ctx)
    {
        return new Assignment(
            ctx.ID().getText(),
            ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1),
            (Type) ctx.type().accept(this)
        );
    }

    @Override
    public ComputedAssignment visitComputedAssignment(@NotNull QLParser.ComputedAssignmentContext ctx)
    {
        return new ComputedAssignment(
            ctx.ID().getText(),
            ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1),
            (Type) ctx.type().accept(this),
            (IExpression) ctx.expression().accept(this)
        );
    }

    @Override
    public IfStatement visitIfStatement(@NotNull IfStatementContext ctx)
    {
        return new IfStatement(
            (IExpression) ctx.expression().accept(this),
            visitBlock(ctx.block()),
            new Block(new StatementList())
        );
    }

    @Override
    public IfStatement visitIfElseStatement(@NotNull QLParser.IfElseStatementContext ctx)
    {
        return new IfStatement(
            (IExpression) ctx.expression().accept(this),
            visitBlock(ctx.block(0)),
            visitBlock(ctx.block(1))
        );
    }

    @Override
    public UnaryPlus visitUnaryPlus(@NotNull QLParser.UnaryPlusContext ctx)
    {
        return new UnaryPlus((IExpression) ctx.expression().accept(this));
    }

    @Override
    public UnaryMinus visitUnaryMinus(@NotNull QLParser.UnaryMinusContext ctx)
    {
        return new UnaryMinus((IExpression) ctx.expression().accept(this));
    }

    @Override
    public Not visitNot(@NotNull QLParser.NotContext ctx)
    {
        return new Not((IExpression) ctx.expression().accept(this));
    }

    @Override
    public Multiply visitMultiply(@NotNull QLParser.MultiplyContext ctx)
    {
        return new Multiply(
            (IExpression) ctx.expression(0).accept(this),
            (IExpression) ctx.expression(1).accept(this)
        );
    }

    @Override
    public Divide visitDivide(@NotNull QLParser.DivideContext ctx)
    {
        return new Divide(
            (IExpression) ctx.expression(0).accept(this),
            (IExpression) ctx.expression(1).accept(this)
        );
    }

    @Override
    public Remainder visitRemainder(@NotNull QLParser.RemainderContext ctx)
    {
        return new Remainder(
            (IExpression) ctx.expression(0).accept(this),
            (IExpression) ctx.expression(1).accept(this)
        );
    }

    @Override
    public Add visitAdd(@NotNull QLParser.AddContext ctx)
    {
        return new Add(
            (IExpression) ctx.expression(0).accept(this),
            (IExpression) ctx.expression(1).accept(this)
        );
    }

    @Override
    public Subtract visitSubtract(@NotNull QLParser.SubtractContext ctx)
    {
        return new Subtract(
            (IExpression) ctx.expression(0).accept(this),
            (IExpression) ctx.expression(1).accept(this)
        );
    }

    @Override
    public LessThan visitLessThan(@NotNull QLParser.LessThanContext ctx)
    {
        return new LessThan(
            (IExpression) ctx.expression(0).accept(this),
            (IExpression) ctx.expression(1).accept(this)
        );
    }

    @Override
    public GreaterThan visitGreaterThan(@NotNull QLParser.GreaterThanContext ctx)
    {
        return new GreaterThan(
            (IExpression) ctx.expression(0).accept(this),
            (IExpression) ctx.expression(1).accept(this)
        );
    }

    @Override
    public LessThanEqual visitLessThanEqual(@NotNull QLParser.LessThanEqualContext ctx)
    {
        return new LessThanEqual(
            (IExpression) ctx.expression(0).accept(this),
            (IExpression) ctx.expression(1).accept(this)
        );
    }

    @Override
    public GreaterThanEqual visitGreaterThanEqual(@NotNull QLParser.GreaterThanEqualContext ctx)
    {
        return new GreaterThanEqual(
            (IExpression) ctx.expression(0).accept(this),
            (IExpression) ctx.expression(1).accept(this)
        );
    }

    @Override
    public Equal visitEqual(@NotNull QLParser.EqualContext ctx)
    {
        return new Equal(
            (IExpression) ctx.expression(0).accept(this),
            (IExpression) ctx.expression(1).accept(this)
        );
    }

    @Override
    public NotEqual visitNotEqual(@NotNull QLParser.NotEqualContext ctx)
    {
        return new NotEqual(
            (IExpression) ctx.expression(0).accept(this),
            (IExpression) ctx.expression(1).accept(this)
        );
    }

    @Override
    public LogicalAnd visitLogicalAnd(@NotNull QLParser.LogicalAndContext ctx)
    {
        return new LogicalAnd(
            (IExpression) ctx.expression(0).accept(this),
            (IExpression) ctx.expression(1).accept(this)
        );
    }

    @Override
    public LogicalOr visitLogicalOr(@NotNull QLParser.LogicalOrContext ctx)
    {
        return new LogicalOr(
            (IExpression) ctx.expression(0).accept(this),
            (IExpression) ctx.expression(1).accept(this)
        );
    }

    @Override
    public BooleanLiteral visitBooleanLiteral(@NotNull QLParser.BooleanLiteralContext ctx)
    {
        BooleanValue booleanValue = (BooleanValue) ctx.booleanLiteralP().accept(this);
        return new BooleanLiteral(booleanValue.getValue());
    }

    @Override
    public BooleanValue visitTrue(@NotNull QLParser.TrueContext ctx)
    {
        return new BooleanValue(true);
    }

    @Override
    public BooleanValue visitFalse(@NotNull QLParser.FalseContext ctx)
    {
        return new BooleanValue(false);
    }

    @Override
    public Id visitId(@NotNull QLParser.IdContext ctx)
    {
        return new Id(ctx.ID().getText());
    }

    @Override
    public NumberLiteral visitNumberLiteral(@NotNull QLParser.NumberLiteralContext ctx)
    {
        return (NumberLiteral) ctx.numberLiteralP().accept(this);
    }

    @Override
    public DecimalLiteral visitDecimal(@NotNull QLParser.DecimalContext ctx)
    {
        return new DecimalLiteral(new BigDecimal(ctx.getText()));
    }

    @Override
    public IntegerLiteral visitInteger(@NotNull QLParser.IntegerContext ctx)
    {
        return new IntegerLiteral(Integer.parseInt(ctx.getText()));
    }

    @Override
    public StringLiteral visitString(@NotNull QLParser.StringContext ctx)
    {
        return new StringLiteral(ctx.getText().substring(1, ctx.getText().length()-1));
    }

    @Override
    public ParenthesesExpression visitParentheses(@NotNull QLParser.ParenthesesContext ctx)
    {
        return new ParenthesesExpression((IExpression) ctx.expression().accept(this));
    }

    private EnumType _visitEnumTypeTail(EnumType enumType, EnumType otherEnumType)
    {
        Iterator<IEnumElement> elementsIterator = otherEnumType.getElementsIterator();
        while (elementsIterator.hasNext()) {
            enumType.addElement(elementsIterator.next());
        }
        return enumType;
    }
}
