package ql.gui.renderer;

import ql.ast.Questionnaire;
import ql.ast.expression.BinaryExpression;
import ql.ast.expression.Id;
import ql.ast.expression.ParenthesesExpression;
import ql.ast.expression.UnaryExpression;
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
import ql.ast.expression.literal.NumberLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.expression.logical.LogicalAnd;
import ql.ast.expression.logical.LogicalOr;
import ql.ast.expression.logical.Not;
import ql.ast.statement.Assignment;
import ql.ast.statement.ComputedAssignment;
import ql.ast.statement.IStatement;
import ql.ast.statement.IfStatement;
import ql.ast.visitor_elements.IElementVisitor;
import ql.gui.InputBuilderVisitor;
import ql.gui.component.Label;
import ql.gui.element.IGuiElement;
import ql.gui.element.QuestionnaireFrame;
import ql.gui.element.expression.ExpressionElement;
import ql.gui.element.widget.ComputedLabelInputPair;
import ql.gui.element.widget.IWidget;
import ql.gui.element.widget.IfElseWidget;
import ql.gui.element.widget.LabelInputPair;
import ql.gui.element.widget.Widget;

/**
 * @author orosu
 */
public class GuiRendererVisitor implements IElementVisitor<IGuiElement>
{
    private final GuiRenderer _guiRenderer;
    private QuestionnaireFrame _questionnaireFrame;

    public GuiRendererVisitor(GuiRenderer guiRenderer)
    {
        this._guiRenderer = guiRenderer;
    }

    @Override
    public QuestionnaireFrame visit(Questionnaire questionnaire)
    {
        this._questionnaireFrame = new QuestionnaireFrame(questionnaire, this._guiRenderer);

        for(IStatement statement: questionnaire.getStatements()) {
            // Visit statements and store label input pairs in the questionnaire frame
            statement.accept(this);
        }

        this._questionnaireFrame.build();
        return this._questionnaireFrame;
    }

    @Override
    public LabelInputPair visit(Assignment assignment)
    {
        return this._addLabelInputPairWidget(assignment);
    }

    @Override
    public ComputedLabelInputPair visit(ComputedAssignment computedAssignment)
    {
        return this._addComputedLabelInputPairWidget(computedAssignment);
    }

    @Override
    public IfElseWidget visit(IfStatement ifStatement)
    {
        IfElseWidget widget = this._createIfElseWidget(ifStatement);

        return widget;
    }

    @Override
    public ExpressionElement visit(Id id)
    {
        ExpressionElement exprWidget = new ExpressionElement(id);
        exprWidget.addId(id);

        return exprWidget;
    }

    @Override
    public ExpressionElement visit(Add addition)
    {
        return _visitBinaryExpression(addition);
    }

    @Override
    public ExpressionElement visit(Divide divivision)
    {
        return _visitBinaryExpression(divivision);
    }

    @Override
    public ExpressionElement visit(Multiply multiplication)
    {
        return _visitBinaryExpression(multiplication);
    }

    @Override
    public ExpressionElement visit(Remainder remainder)
    {
        return _visitBinaryExpression(remainder);
    }

    @Override
    public ExpressionElement visit(Subtract subtraction)
    {
        return _visitBinaryExpression(subtraction);
    }

    @Override
    public ExpressionElement visit(LogicalAnd logicalAnd)
    {
        return _visitBinaryExpression(logicalAnd);
    }

    @Override
    public ExpressionElement visit(LogicalOr logicalOr)
    {
        return _visitBinaryExpression(logicalOr);
    }

    @Override
    public ExpressionElement visit(Equal equal)
    {
        return _visitBinaryExpression(equal);
    }

    @Override
    public ExpressionElement visit(NotEqual notEqual)
    {
        return _visitBinaryExpression(notEqual);
    }

    @Override
    public ExpressionElement visit(GreaterThan greaterThan)
    {
        return _visitBinaryExpression(greaterThan);
    }

    @Override
    public ExpressionElement visit(GreaterThanEqual greaterThanEqual)
    {
        return _visitBinaryExpression(greaterThanEqual);
    }

    @Override
    public ExpressionElement visit(LessThan lessThan)
    {
        return _visitBinaryExpression(lessThan);
    }

    @Override
    public ExpressionElement visit(LessThanEqual lessThanEqual)
    {
        return _visitBinaryExpression(lessThanEqual);
    }

    @Override
    public ExpressionElement visit(Not not)
    {
        return _visitUnaryExpression(not);
    }

    @Override
    public ExpressionElement visit(UnaryMinus unaryMinus)
    {
        return _visitUnaryExpression(unaryMinus);
    }

    @Override
    public ExpressionElement visit(UnaryPlus unaryPlus)
    {
        return _visitUnaryExpression(unaryPlus);
    }

    @Override
    public ExpressionElement visit(ParenthesesExpression parensExpr)
    {
        return _visitUnaryExpression(parensExpr);
    }

    @Override
    public ExpressionElement visit(BooleanLiteral booleanLiteral)
    {
        return new ExpressionElement(booleanLiteral);
    }

    @Override
    public ExpressionElement visit(NumberLiteral numberLiteral)
    {
        return new ExpressionElement(numberLiteral);
    }

    @Override
    public ExpressionElement visit(StringLiteral stringLiteral)
    {
        return new ExpressionElement(stringLiteral);
    }

    private LabelInputPair _addLabelInputPairWidget(Assignment assignment)
    {
        LabelInputPair widget = new LabelInputPair(
            this._questionnaireFrame,
            assignment.getId(),
            new Label(assignment.getLabel()),
            assignment.getType().accept(new InputBuilderVisitor())
        );

        this._questionnaireFrame.addLabelInputPair(assignment.getId(), widget);
        return widget;
    }

    private ComputedLabelInputPair _addComputedLabelInputPairWidget(
        ComputedAssignment computedAssignment)
    {
        ComputedLabelInputPair widget = new ComputedLabelInputPair(
            this._questionnaireFrame,
            computedAssignment.getId(),
            new Label(computedAssignment.getLabel()),
            computedAssignment.getType().accept(new InputBuilderVisitor()),
            new Widget(
                this._questionnaireFrame,
                (ExpressionElement) computedAssignment.getExpression().accept(this)
            )
        );

        widget.setEnabled(false);
        this._questionnaireFrame.addLabelInputPair(computedAssignment.getId(), widget);

        widget.createAttachInputListener();

        return widget;
    }

    private IfElseWidget _createIfElseWidget(IfStatement ifStatement)
    {
        IfElseWidget widget = new IfElseWidget(
            new Widget(
                this._questionnaireFrame,
                (ExpressionElement) ifStatement.getExpression().accept(this)
            )
        );

        // Visit if statements
        for (IStatement statement: ifStatement.getIfStatements()) {
            widget.addIfWidget((IWidget) statement.accept(this));
        }

        // Visit else statements
        for (IStatement statement: ifStatement.getElseStatements()) {
            widget.addElseWidget((IWidget) statement.accept(this));
        }

        widget.createAttachInputListener();

        return widget;
    }

    private ExpressionElement _visitBinaryExpression(BinaryExpression binaryExpression)
    {
        ExpressionElement exprWidget = new ExpressionElement(binaryExpression);

        ExpressionElement leftExprWidget =
            (ExpressionElement) binaryExpression.getLeftSubExpression().accept(this);
        for (Id id: leftExprWidget.getInvolvedIds()) {
            exprWidget.addId(id);
        }

        ExpressionElement rightExprWidget =
            (ExpressionElement) binaryExpression.getRightSubExpression().accept(this);
        for (Id id: rightExprWidget.getInvolvedIds()) {
            exprWidget.addId(id);
        }

        return exprWidget;
    }

    private ExpressionElement _visitUnaryExpression(UnaryExpression expression)
    {
        ExpressionElement exprWidget = new ExpressionElement(expression);

        ExpressionElement innerExprWidget =
            (ExpressionElement) expression.getExpression().accept(this);
        for (Id id: innerExprWidget.getInvolvedIds()) {
            exprWidget.addId(id);
        }

        return exprWidget;
    }
}
