package edu.uva.softwarecons.visitor.form;

import edu.uva.softwarecons.model.Form;
import edu.uva.softwarecons.model.question.BasicQuestion;
import edu.uva.softwarecons.model.question.ComputedQuestion;
import edu.uva.softwarecons.model.question.ElseQuestion;
import edu.uva.softwarecons.model.question.IfQuestion;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 2/26/14
 */
public interface FormElementVisitor
{

    void visitForm( Form form );

    void visitComputedQuestion( ComputedQuestion question );

    void visitIfQuestion( IfQuestion question );

    void visitElseQuestion( ElseQuestion question );

    void visitQuestion( BasicQuestion question );


}
