expr ::= expr add term
expr ::= expr mod term
expr ::= expr + term
expr ::= term

term ::= term * factor
term ::= factor

factor ::= number
factor ::= float