grammar Newql;

options {
	// antlr will generate java lexer and parser
	language = Java;
}

// Rules
form: 'form' formname '{' qits '}';
formname: FORMNAME;
qits: qit+;
qit: question identifier type;
question: QUESTION;
identifier: IDENTIFIER;
type: TYPE;

// Tokens
FORMNAME: [A-Z]+[a-zA-Z09]*;
QUESTION: '"'[A-Z]+[a-zA-Z0-9 ]*'?"';
IDENTIFIER: [a-z]+[a-zA-z0-9]*':';
TYPE: 'boolean' | 'money';


WS: [\t\r\n ] -> skip;