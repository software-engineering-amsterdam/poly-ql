package edu.uva.softwarecons.model.type;

import java.math.BigDecimal;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/19/14
 */
public class MoneyType extends Type{

    private BigDecimal value;

    @Override
    public BigDecimal getValue() {
        return value;
    }
}
