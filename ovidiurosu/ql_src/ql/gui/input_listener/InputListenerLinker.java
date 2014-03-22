package ql.gui.input_listener;

import java.util.Iterator;

import ql.ast.expression.IExpression;
import ql.ast.expression.Id;
import ql.ast.expression_evaluator.ExpressionIdSetBuilderVisitor;
import ql.ast.expression_evaluator.ValueEnvironment;
import ql.ast.expression_value.NullValue;
import ql.gui.QuestionnaireFrame;
import ql.gui.expression_interpreter.ExpressionInterpreter;
import ql.gui.widget.IWidget;
import ql.gui.widget.LabelInputPair;

/**
 * @author orosu
 */
public class InputListenerLinker
{
    private final QuestionnaireFrame _questionnaireFrame; // used to get label-input pairs
    private final ValueEnvironment _valueEnvironment; // used by expression interpreter
    private final IExpression _expression;
    private ExpressionInterpreter _expressionInterpreter = null;

    public InputListenerLinker(QuestionnaireFrame questionnaireFrame,
        ValueEnvironment valueEnvironment, IExpression expression)
    {
        this._questionnaireFrame = questionnaireFrame;
        this._valueEnvironment = valueEnvironment;
        this._expression = expression;
    }

    public void attachInputListener(IWidget widget)
    {
        ExpressionInterpreter expressionInterpreter = this._createIfNotExists(widget);

        // Loop through all inputs referenced by involved IDs
        Iterator<Id> iterator = this._expression.accept(new ExpressionIdSetBuilderVisitor())
            .iterator();

        while (iterator.hasNext()) {
            Id id = iterator.next();
            if (!this._questionnaireFrame.containsLabelInputPair(id.getValue())) {
                continue;
            }

            LabelInputPair labelInputPair = this._questionnaireFrame
                .getLabelInputPairById(id.getValue());

            labelInputPair.getInput().attachInputListener(expressionInterpreter);
        }
    }

    public boolean hasExpressionInterpreter()
    {
        return this._expressionInterpreter != null;
    }

    public ExpressionInterpreter getExpressionInterpreter()
    {
        return this._expressionInterpreter;
    }

    public boolean evaluateNull()
    {
        if (this.hasExpressionInterpreter() &&
            this.getExpressionInterpreter().evaluate().equals(new NullValue())
        ) {
            return true;
        }
        return false;
    }

    private ExpressionInterpreter _createIfNotExists(IWidget widget)
    {
        if (this.hasExpressionInterpreter()) {
            return this.getExpressionInterpreter();
        }
        return this._createExpressionInterpreter(widget);
    }

    private ExpressionInterpreter _createExpressionInterpreter(IWidget widget)
    {
        this._expressionInterpreter = new ExpressionInterpreter(
            this._questionnaireFrame,
            this._valueEnvironment,
            this._expression,
            widget
        );
        return this._expressionInterpreter;
    }
}
