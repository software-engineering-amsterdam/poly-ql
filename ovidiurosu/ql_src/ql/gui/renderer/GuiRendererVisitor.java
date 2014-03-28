package ql.gui.renderer;

import java.util.Iterator;

import ql.ast.expression.IExpression;
import ql.ast.expression_evaluator.ValueEnvironment;
import ql.ast.statement.Assignment;
import ql.ast.statement.ComputedAssignment;
import ql.ast.statement.IStatement;
import ql.ast.statement.IfStatement;
import ql.ast.visitor_elements.IStatementElementVisitor;
import ql.gui.Label;
import ql.gui.QuestionnaireFrame;
import ql.gui.input_field.IInput;
import ql.gui.input_field.InputBuilderVisitor;
import ql.gui.input_listener.InputListenerLinker;
import ql.gui.widget.ComputedLabelInputPair;
import ql.gui.widget.IWidget;
import ql.gui.widget.IfElse;
import ql.gui.widget.LabelInputPair;

/**
 * @author orosu
 */
public class GuiRendererVisitor implements IStatementElementVisitor<IWidget>
{
    private final QuestionnaireFrame _questionnaireFrame;
    private final ValueEnvironment _valueEnvironment;

    public GuiRendererVisitor(QuestionnaireFrame questionnaireFrame, ValueEnvironment valueEnvironment)
    {
        this._questionnaireFrame = questionnaireFrame;
        this._valueEnvironment = valueEnvironment;
    }

    @Override
    public LabelInputPair visit(Assignment assignment)
    {
        LabelInputPair widget = new LabelInputPair(
            this._questionnaireFrame,
            assignment.getId(),
            this._createLabel(assignment),
            this._createInput(assignment)
        );

        this._addWidget(assignment, widget);
        return widget;
    }

    @Override
    public ComputedLabelInputPair visit(ComputedAssignment computedAssignment)
    {
        ComputedLabelInputPair widget = new ComputedLabelInputPair(
            this._questionnaireFrame,
            computedAssignment.getId(),
            this._createLabel(computedAssignment),
            this._createInput(computedAssignment),
            this._createInputListenerLinker(computedAssignment.getExpression())
        );

        this._addWidget(computedAssignment, widget);
        widget.attachInputListener();
        return widget;
    }

    @Override
    public IfElse visit(IfStatement ifStatement)
    {
        IfElse widget = new IfElse(
            this._createInputListenerLinker(ifStatement.getExpression())
        );

        // Visit if statements
        Iterator<IStatement> ifStatementsIterator = ifStatement.getIfStatementList().iterator();
        while(ifStatementsIterator.hasNext()) {
            widget.addIfWidget(ifStatementsIterator.next().accept(this));
        }

        // Visit else statements
        Iterator<IStatement> elseStatementsIterator = ifStatement.getElseStatementList().iterator();
        while(elseStatementsIterator.hasNext()) {
            widget.addElseWidget(elseStatementsIterator.next().accept(this));
        }

        widget.attachInputListener();

        return widget;
    }

    private Label _createLabel(Assignment assignment)
    {
        return new Label(assignment.getLabel());
    }

    private IInput _createInput(Assignment assignment)
    {
        return assignment.getType().accept(new InputBuilderVisitor(
            this._valueEnvironment,
            assignment.getId())
        );
    }

    private InputListenerLinker _createInputListenerLinker(IExpression expression)
    {
        return new InputListenerLinker(
            this._questionnaireFrame,
            this._valueEnvironment,
            expression
        );
    }

    private void _addWidget(Assignment assignment, LabelInputPair widget)
    {
        this._questionnaireFrame.addLabelInputPair(assignment.getId(), widget);
    }
}
