package ql.ast.statements;

import ql.ast.EInterface;
import ql.ast.statements.types.STInterface;

public interface SInterface extends EInterface {
    public STInterface getStatementType();
}