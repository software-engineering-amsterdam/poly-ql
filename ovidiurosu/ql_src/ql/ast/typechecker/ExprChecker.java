package ql.ast.typechecker;

import ql.ast.expr.IExpr;
import ql.ast.stat.type.IStatType;
import ql.ast.type.IType;
import ql.exc.ErrorExc;


/**
 * Expression Checker
 * @author orosu
 */
public class ExprChecker implements IChecker
{
    /**
     * AST Type Checker Visitor
     */
    private final TypeCheckerVisitor _visitor;

    /**
     * Expression
     */
    private final IExpr _expr;

    /**
     * Constructor
     */
    public ExprChecker(TypeCheckerVisitor visitor, IExpr expr)
    {
        this._visitor = visitor;
        this._expr = expr;
    }

    /**
     * Check if the statement type is compatible with the expression type
     * @param statType
     */
    public void checkStatTypeCompatibility(IStatType statType)
    {
        if (this._expr.getType().getClass().equals(statType.getType().getClass())) {
            return;
        }

        //ERROR The expression type is not compatible with the statement type
        this._visitor.addExc(
            new ErrorExc("The expression type ('" + this._expr.getType().toStr() +
                "') is not compatible with the statement type ('" +
                statType.toStr() + "')!")
        );
    }

    /**
     * Check if the expression type is compatible with the expression type
     * @param type
     */
    public void checkTypeCompatibility(IType type)
    {
        if(this._expr.getType().getClass().equals(type.getClass())) {
            return;
        }

        //ERROR The expression type is not compatible with the expression type
        this._visitor.addExc(
            new ErrorExc("The expression type ('" + this._expr.getType().toStr() +
                "') is not compatible with the expression type ('" +
                type.toStr() + "')!")
        );
    }
}
