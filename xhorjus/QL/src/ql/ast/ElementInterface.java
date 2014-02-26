package ql.ast;

/**
 * Interface for element
 */
public interface ElementInterface {
	void accept(ElementInterfaceVisitor visitor);
}
