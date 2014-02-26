package edu.uva.softwarecons.model.expression.arithmetic;

import com.sun.tools.corba.se.idl.constExpr.BinaryExpr;
import com.sun.tools.corba.se.idl.constExpr.EvaluationException;
import edu.uva.softwarecons.model.expression.BinaryExpression;
import edu.uva.softwarecons.model.expression.Expression;
import edu.uva.softwarecons.model.operation.Operator;
import edu.uva.softwarecons.model.type.Type;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public class DivExpression extends BinaryExpression {

    public DivExpression(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
        operator = Operator.DIV;
    }




    @Override
    public Type eval() {
        return null;
    }
}
