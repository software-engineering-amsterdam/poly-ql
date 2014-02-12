/** Grammars always start with a grammar header. This grammar is called
 *  ArrayInit and must match the filename: ArrayInit.g4
 */
grammar Test;

questionnare    : 'form ' title ' {' (question)+ '}';
title           : TITLE;
question		: qtitle ASSIGNMENT '"' qcontent '"' qtype;
qtitle          : QUESTIONTITLE;
qcontent        : (.+?);
qtype           : 'boolean' | 'int' | 'string';

TITLE           : [A-Z][a-zA-Z0-9]*;
QUESTIONTITLE   : [a-z][a-zA-Z0-9]*;
ASSIGNMENT      : ':';
WS              : [ \t\r\n]+ -> skip ; 

/* 
form Box1HouseOwning {
 hasSoldHouse: “Did you sell a house in 2010?” boolean
 hasBoughtHouse: “Did you by a house in 2010?” boolean
 hasMaintLoan: “Did you enter a loan for maintenance/reconstruction?” 
boolean
 if (hasSoldHouse) {
 sellingPrice: “Price the house was sold for:” money
 privateDebt: “Private debts for the sold house:” money
 valueResidue: “Value residue:” money(sellingPrice - privateDebt)
 }
}
*/