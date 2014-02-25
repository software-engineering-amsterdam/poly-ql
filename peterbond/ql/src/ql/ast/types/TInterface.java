package ql.ast.types;

import ql.ast.statements.types.STBoolean;
import ql.ast.statements.types.STText;
import ql.ast.statements.types.STMoney;

public interface TInterface {
    public Boolean isCompatible(STBoolean statementType);
    public Boolean isCompatible(STText statementType);
    public Boolean isCompatible(STMoney statementType);
    public String toStr();
}