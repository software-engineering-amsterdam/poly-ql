grammar Newql;

options {
	// antlr will generate java lexer and parser
	language = Java;
}

r : 'hello' ID;
ID : [a-z]+;
WS: [ \t\r\n]+ -> skip;