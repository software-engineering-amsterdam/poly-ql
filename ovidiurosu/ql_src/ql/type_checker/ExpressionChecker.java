package ql.type_checker;

import ql.ast.expression.IExpression;
import ql.ast.expression.Id;
import ql.ast.type.NullType;
import ql.ast.type.Type;
import ql.error.TypeError;

/**
 * @author orosu
 */
public class ExpressionChecker extends Checker
{
    private final IExpression _expression;

    public ExpressionChecker(TypeEnvironment typeEnvironment, IExpression expression)
    {
        this._typeEnvironment = typeEnvironment;
        this._expression = expression;
    }

    /**
     * Check if this Id expression has a type
     */
    public void checkIdHasType()
    {
        Id id = (Id) this._expression;
        if (!(id.getType() instanceof NullType)) {
            return;
        }

        //ERROR There is no assignment with this id
        this._typeEnvironment.addError(
            new TypeError("There is no assignment with id '" + id.getValue() + "'!")
        );
    }

    /**
     * Check if this expression's type is compatible with provided type
     */
    public void checkTypeCompatibility(Type type)
    {
        if(this._expression.getType().compatibleWith(type)) {
            return;
        }

        //ERROR This expression's type is not compatible with provided type
        this._typeEnvironment.addError(
            new TypeError("An expression of type '" + this._expression.getType().toString() +
                "' is not compatible with an expression of type '" +
                type.toString() + "'!")
        );
    }
}
