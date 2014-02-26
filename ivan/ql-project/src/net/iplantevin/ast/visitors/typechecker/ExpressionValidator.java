package net.iplantevin.ast.visitors.typechecker;

import net.iplantevin.ast.expressions.Expression;
import net.iplantevin.ast.expressions.operators.Binary;
import net.iplantevin.ast.expressions.operators.Unary;
import net.iplantevin.ast.statements.Computation;
import net.iplantevin.ast.types.*;
import net.iplantevin.ast.visitors.IQLASTVisitor;
import net.iplantevin.exceptions.ExceptionCollection;
import net.iplantevin.exceptions.QLTypeException;
import net.iplantevin.exceptions.QLUndefinedException;

/**
 * @author Ivan
 */
public class ExpressionValidator {
    private final ExceptionCollection exceptionCollection;
    private final TypeEnvironment typeEnvironment;
    private final IQLASTVisitor visitor;
    private final UndefinedType UNDEFINED = new UndefinedType();

    public ExpressionValidator(ExceptionCollection exceptionCollection, TypeEnvironment typeEnvironment, IQLASTVisitor visitor) {
        this.exceptionCollection = exceptionCollection;
        this.typeEnvironment = typeEnvironment;
        this.visitor = visitor;
    }

    public void checkExpectedType(Expression expression, Type expectedType) {
        Type actualType = expression.getType(typeEnvironment);
        if (actualType.equals(UNDEFINED)) {
            String message = "the expression below is undefined!";
            QLUndefinedException undefinedException = new QLUndefinedException(
                    message,
                    expression
            );
            exceptionCollection.addException(undefinedException);
        }
        // NOTE: undefined values result in both QLUndefinedException AND
        // QLTypeException!
        if (!actualType.isCompatibleToType(expectedType)) {
            String message = "the type of the expression below is not compatible " +
                    "with the expected type!";
            QLTypeException typeException = new QLTypeException(
                    message,
                    expression,
                    expectedType,
                    expression.getType(typeEnvironment)
            );
            exceptionCollection.addException(typeException);
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
        visitBinary(expression);
    }

    public void checkEquality(Binary expression) {
        checkExpectedType(expression.getLeftExpr(),
                expression.getRightExpr().getType(typeEnvironment));
        visitBinary(expression);
    }

    public void checkNumeric(Binary expression) {
        checkExpectedType(expression.getLeftExpr(), new IntegerType());
        checkExpectedType(expression.getRightExpr(), new IntegerType());
        visitBinary(expression);
    }

    public void checkUnary(Unary expression) {
        checkExpectedType(expression.getExpression(), expression.getType(typeEnvironment));
        expression.getExpression().accept(visitor);
    }

    private void visitBinary(Binary expression) {
        expression.getLeftExpr().accept(visitor);
        expression.getRightExpr().accept(visitor);
    }
}
