package edu.uva.softwarecons.visitor.expression;

import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.visitor.IQuestionnaireElement;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public interface IExpressionEval
    extends IQuestionnaireElement
{

    Value accept( IExpressionEvalVisitor visitor );
}

