package edu.uva.softwarecons.model.operation;

/**
 * Falconlabs
 * User: sancarbar
 * Date: 2/20/14
 */
public enum Operator {

    //Arithmetic operators
    ADD     ("+"),
    SUB     ("-"),
    DIV     ("/"),
    MUL     ("*"),

    //Boolean operators
    AND     ("&&"),
    OR      ("||"),
    NOT     ("!"),

    //Comparison operators
    LT      ("<"),
    LEq		("<="),
    GT		(">"),
    GEq		(">="),
    Eq  	("=="),
    NEq 	("!=");


    private final String symbol;   // operation symbol


    Operator(String symbol) {
        this.symbol = symbol;
    }


    public String getSymbol() {
        return symbol;
    }
}
