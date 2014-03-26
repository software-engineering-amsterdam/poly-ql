package edu.uva.softwarecons.visitor.expression;

import edu.uva.softwarecons.model.value.Value;
import edu.uva.softwarecons.visitor.QuestionnaireElement;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/13/14
 */
public interface ExpressionEval
    extends QuestionnaireElement
{

    Value accept( ExpressionEvalVisitor visitor );
}

