package nl.uva.polyql.model.expressions.operators;

import java.beans.Expression;

public interface IBooleanOperator {

    boolean performOperation(Expression left, Expression right);
}
