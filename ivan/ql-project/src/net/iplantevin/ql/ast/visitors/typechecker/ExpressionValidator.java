package net.iplantevin.ql.ast.visitors.typechecker;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.expressions.operators.Binary;
import net.iplantevin.ql.ast.expressions.operators.Unary;
import net.iplantevin.ql.ast.statements.Computation;
import net.iplantevin.ql.ast.types.*;
import net.iplantevin.ql.ast.visitors.IQLASTVisitor;
import net.iplantevin.ql.errors.ErrorCollection;
import net.iplantevin.ql.errors.TypeError;
import net.iplantevin.ql.errors.UndefinedError;

/**
 * @author Ivan
 */
// TODO: integrate with TypeCheckerVisitor
public class ExpressionValidator {
    private final ErrorCollection errorCollection;
    private final TypeEnvironment typeEnvironment;
    private final IQLASTVisitor visitor;
    private final UndefinedType UNDEFINED = new UndefinedType();

    public ExpressionValidator(ErrorCollection errorCollection, TypeEnvironment typeEnvironment, IQLASTVisitor visitor) {
        this.errorCollection = errorCollection;
        this.typeEnvironment = typeEnvironment;
        this.visitor = visitor;
    }

    public void checkExpectedType(Expression expression, Type expectedType) {
        Type actualType = expression.getType(typeEnvironment);
        if (actualType.equals(UNDEFINED)) {
            String message = "the expression below is undefined!";
            UndefinedError undefinedException = new UndefinedError(
                    message,
                    expression
            );
            errorCollection.addException(undefinedException);
        }
        // NOTE: undefined values result in both UndefinedError AND
        // TypeError!
        if (!actualType.isCompatibleToType(expectedType)) {
            String message = "the type of the expression below is not compatible " +
                    "with the expected type!";
            TypeError typeException = new TypeError(
                    message,
                    expression,
                    expectedType,
                    expression.getType(typeEnvironment)
            );
            errorCollection.addException(typeException);
        }
    }

    public void checkComputation(Computation computation) {
        Expression expression = computation.getExpression();
        Type expectedType = computation.getType();
        checkExpectedType(expression, expectedType);
        expression.accept(visitor);
    }

    public void checkCondition(Expression expression) {
        checkExpectedType(expression, new BooleanType());
        expression.accept(visitor);
    }

    public void checkComparison(Binary expression) {
        checkNumeric(expression);
    }

    public void checkLogical(Binary expression) {
        checkExpectedType(expression.getLeftExpr(), new BooleanType());
        checkExpectedType(expression.getRightExpr(), new BooleanType());
        checkBinary(expression);
    }

    public void checkEquality(Binary expression) {
        checkExpectedType(expression.getLeftExpr(),
                expression.getRightExpr().getType(typeEnvironment));
        checkBinary(expression);
    }

    public void checkNumeric(Binary expression) {
        checkExpectedType(expression.getLeftExpr(), new IntegerType());
        checkExpectedType(expression.getRightExpr(), new IntegerType());
        checkBinary(expression);
    }

    public void checkUnary(Unary expression) {
        checkExpectedType(expression.getExpression(), expression.getType(typeEnvironment));
        expression.getExpression().accept(visitor);
    }

    private void checkBinary(Binary expression) {
        expression.getLeftExpr().accept(visitor);
        expression.getRightExpr().accept(visitor);
    }
}
