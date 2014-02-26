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
//                if(leftOperand instanceof IntegerType && rightOperand instanceof IntegerType)
//                    return  new IntegerType((Double) leftOperand.getValue() + (Double) rightOperand.getValue());
//                else if(leftOperand instanceof MoneyType && rightOperand instanceof MoneyType)
//                    return  new IntegerType((Float) leftOperand.getValue() + (Float) rightOperand.getValue());
        }

        return null;
    }


}
