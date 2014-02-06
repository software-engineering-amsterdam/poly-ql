grammar Newql;

options {
	// antlr will generate java lexer and parser
	language = Java;
}

form: 'form' NAME '{' FULLQUESTION+ '}';
FULLQUESTION: QUESTION ID TYPE;
NAME: [a-z]+;
QUESTION: [a-z]+;
ID: [a-z]+;
TYPE: BOOL | INT | MONEY;

MONEY: INT ',' INT INT;
BOOL: [boolean value];
INT: [0-9]+;
WS: [ \t\n]+ -> skip;