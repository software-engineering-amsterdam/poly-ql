package ql.gui.element.expression;

import ql.ast.expression.IExpression;
import ql.ast.expression.value.IValue;
import ql.gui.element.QuestionnaireFrame;

/**
 * @author orosu
 */
public class ExpressionEvaluator
{
    private final IExpression _expression;
    private final ExpressionEvaluatorVisitor _expressionEvaluatorVisitor;
    public ExpressionEvaluator(QuestionnaireFrame questionnaireFrame, IExpression expression)
    {
        this._expression = expression;
        this._expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(questionnaireFrame);
    }

    public IValue evaluate()
    {
        return this._expression.accept(this._expressionEvaluatorVisitor);
    }
}
