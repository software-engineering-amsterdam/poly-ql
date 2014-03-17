package ql.gui.element.widget;

import ql.ast.expression.Id;
import ql.ast.expression.value.NullValue;
import ql.gui.element.IGuiElement;
import ql.gui.element.QuestionnaireFrame;
import ql.gui.element.expression.ExpressionElement;
import ql.gui.element.expression.ExpressionEvaluator;
import ql.gui.element.expression.ValueInterpreterVisitor;
import ql.gui.listener.InputListener;

/**
 * @author orosu
 */
public class Widget implements IGuiElement
{
    private final QuestionnaireFrame _questionnaireFrame;
    private final ExpressionElement _expressionElement;
    private InputListener _inputListener = null;

    public Widget(QuestionnaireFrame questionnaireFrame,
        ExpressionElement expressionElement)
    {
        this._questionnaireFrame = questionnaireFrame;
        this._expressionElement = expressionElement;
    }

    public QuestionnaireFrame getQuestionnaireFrame()
    {
        return this._questionnaireFrame;
    }

    public ExpressionElement getExpressionElement()
    {
        return this._expressionElement;
    }

    public void createAttachInputListener(IWidget widget)
    {
        InputListener inputListener = this.createIfNotExists(widget);

        // Loop through all inputs referenced by involved IDs
        for (Id id: this._expressionElement.getInvolvedIds()) {
            if (!this._questionnaireFrame.containsLabelInputPair(id.getValue())) {
                continue;
            }

            LabelInputPair labelInputPair = this._questionnaireFrame
                .getLabelInputPairById(id.getValue());

            labelInputPair.input.attachInputListener(inputListener);
        }
    }

    public boolean hasInputListener()
    {
        return this._inputListener != null;
    }

    public InputListener getInputListener()
    {
        return this._inputListener;
    }

    public InputListener createIfNotExists(IWidget widget)
    {
        if (this.hasInputListener()) {
            return this.getInputListener();
        }
        return this._createInputListener(widget);
    }

    public boolean evaluateNull()
    {
        if (this.hasInputListener() &&
            this.getInputListener().evaluateExpression().equals(new NullValue())
        ) {
            return true;
        }
        return false;
    }

    private InputListener _createInputListener(IWidget widget)
    {
        this._inputListener = new InputListener(
            new ExpressionEvaluator(
                this._questionnaireFrame,
                this._expressionElement.getExpression()
            ),
            new ValueInterpreterVisitor(widget)
        );
        return this._inputListener;
    }
}
