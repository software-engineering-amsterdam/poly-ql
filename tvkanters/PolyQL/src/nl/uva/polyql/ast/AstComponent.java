package nl.uva.polyql.ast;

/**
 * An interface for components that occur within the AST.
 */
public interface AstComponent {

    void setLineInfo(LineInfo lineInfo);

    LineInfo getLineInfo();

}
