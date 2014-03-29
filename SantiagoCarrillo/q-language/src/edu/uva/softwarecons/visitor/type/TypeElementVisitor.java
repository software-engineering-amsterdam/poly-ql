package edu.uva.softwarecons.visitor.type;

import edu.uva.softwarecons.model.type.BooleanType;
import edu.uva.softwarecons.model.type.DateType;
import edu.uva.softwarecons.model.type.DecimalType;
import edu.uva.softwarecons.model.type.IntegerType;
import edu.uva.softwarecons.model.type.MoneyType;
import edu.uva.softwarecons.model.type.StringType;

/**
 * Falconlabs
 *
 * @author Santiago Carrillo
 *         Date: 3/5/14
 */
public interface TypeElementVisitor
{

    void visitBooleanType( BooleanType type );

    void visitDateType( DateType type );

    void visitDecimalType( DecimalType type );

    void visitIntegerType( IntegerType type );

    void visitMoneyType( MoneyType type );

    void visitStringType( StringType type );
}
