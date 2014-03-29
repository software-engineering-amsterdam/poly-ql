package edu.uva.softwarecons.visitor.form;

import edu.uva.softwarecons.visitor.QuestionnaireElement;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/26/14
 */
public interface FormElement
    extends QuestionnaireElement
{

    void accept( FormElementVisitor visitor );

}
