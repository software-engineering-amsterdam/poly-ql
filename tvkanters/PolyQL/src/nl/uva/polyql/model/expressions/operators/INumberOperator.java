package nl.uva.polyql.model.expressions.operators;

import java.beans.Expression;

public interface INumberOperator {

    double performOperation(Expression left, Expression right);
}
