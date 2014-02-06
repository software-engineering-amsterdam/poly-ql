grammar Newql;

options {
	// antlr will generate java lexer and parser
	language = Java;
}

form: 'form ' NAME '{' FULLQUESTION+ '}';
hallon: FULLQUESTION+;
FULLQUESTION: QUESTION ID TYPE;
NAME: [A-Z]+[a-zA-Z]+;
QUESTION: STRING+;
ID: [a-z]+[a-zA-Z]*':';
TYPE: 'boolean' | 'money' | 'string';

MONEY: INT ',' INT INT;
BOOL: 'true' | 'false';
INT: [0-9]+;
STRING: [a-zA-Z0-9\?.!;,(): ];
WS: [ \r\t\n]+ -> skip;