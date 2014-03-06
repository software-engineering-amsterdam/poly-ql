package edu.uva.softwarecons.test;

import edu.uva.softwarecons.model.type.DecimalType;
import edu.uva.softwarecons.model.type.IntegerType;
import edu.uva.softwarecons.model.type.MoneyType;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 3/6/14
 */
public class TypeTest {

    @Test
    public void numericTypeEqualsTest(){
        DecimalType decimalType = new DecimalType(0);
        IntegerType integerType = new IntegerType(0);
        MoneyType moneyType = new MoneyType(new BigDecimal(0));
        assertTrue(decimalType.equals(integerType));
        assertTrue(decimalType.equals(moneyType));
        assertTrue(integerType.equals(moneyType));
    }
}
