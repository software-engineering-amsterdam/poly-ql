package edu.uva.softwarecons.visitor;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/26/14
 */
public interface IFormElement {

    void accept(IFormElementVisitor visitor);

}
