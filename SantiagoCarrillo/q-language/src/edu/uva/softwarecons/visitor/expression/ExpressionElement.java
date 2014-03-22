package edu.uva.softwarecons.visitor.expression;

import edu.uva.softwarecons.model.type.Type;
import edu.uva.softwarecons.visitor.QuestionnaireElement;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/5/14
 */
public interface ExpressionElement
    extends QuestionnaireElement
{

    Type accept( ExpressionElementVisitor visitor );
}
