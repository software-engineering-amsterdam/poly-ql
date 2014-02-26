package ql.ast;

/**
 * Interface for all elements
 */
public interface EInterface
{
    void accept(EInterfaceVisitor visitor);
}