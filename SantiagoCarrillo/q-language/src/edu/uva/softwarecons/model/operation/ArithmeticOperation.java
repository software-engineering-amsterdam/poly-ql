package edu.uva.softwarecons.model.operation;

import edu.uva.softwarecons.model.type.Type;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public class ArithmeticOperation extends Operation {

    @Override
    public Type eval(Type leftOperand, Type rightOperand, Operator operator) {

        switch (operator){
            case ADD:
//                if(leftExpression instanceof IntegerType && rightExpression instanceof IntegerType)
//                    return  new IntegerType((Double) leftExpression.getValue() + (Double) rightExpression.getValue());
//                else if(leftExpression instanceof MoneyType && rightExpression instanceof MoneyType)
//                    return  new IntegerType((Float) leftExpression.getValue() + (Float) rightExpression.getValue());
        }

        return null;
    }


}
