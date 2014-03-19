package edu.uva.softwarecons.visitor.form;

import edu.uva.softwarecons.visitor.IQuestionnaireElement;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/26/14
 */
public interface IFormElement
    extends IQuestionnaireElement
{

    void accept( IFormElementVisitor visitor );

}
