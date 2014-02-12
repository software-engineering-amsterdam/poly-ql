grammar Newql;

options {
	// antlr will generate java lexer and parser
	language = Java;
}

// Rules
form: 'form' formname '{' qits '}';
qits: qit+;
qit: question identifier type | 'if('condition'){'qit'}';
formname: FORMNAME;
question: QUESTION;
identifier: IDENTIFIER;
type: TYPE;
condition: CONDITION;

// Tokens
FORMNAME: [A-Z]+[a-zA-Z09]*;
QUESTION: '"'[A-Z]+[a-zA-Z0-9 ]*'?"';
IDENTIFIER: [a-z]+[a-zA-Z0-9]*':';
TYPE: 'boolean' | 'money';
CONDITION: [a-z]+[a-zA-Z0-9]*;

WS: [\t\r\n ] -> skip;