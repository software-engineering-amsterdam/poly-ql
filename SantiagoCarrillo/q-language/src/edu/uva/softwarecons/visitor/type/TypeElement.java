package edu.uva.softwarecons.visitor.type;

import edu.uva.softwarecons.visitor.QuestionnaireElement;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/5/14
 */
public interface TypeElement
    extends QuestionnaireElement
{

    void accept( TypeElementVisitor visitor );
}
