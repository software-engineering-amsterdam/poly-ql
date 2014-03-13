package nl.uva.polyql.ast;

public interface AstComponent {

    void setLineInfo(LineInfo lineInfo);

    LineInfo getLineInfo();

}
