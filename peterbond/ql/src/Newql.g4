grammar Newql;

options {
	// antlr will generate java lexer and parser
	language = Java;
}

// Rules
form: 'form' formname '{' block+ '}';
block: qit | ifstat;
qit: '"'question'"' identifier ASS type;
ifstat: 'if('condition') {' block '}'
      | 'if('condition') {' block '}' 'else {' block '}';
formname: FORMNAME;
question: QUESTION;
identifier: IDENTIFIER;
type: BOOLEAN | MONEY | TEXT;
condition: condition binop condition | identifier;
binop: EQ | NEQ | ADD | SUB | MUL | DIV | MOD | NOT | AND | OR;

// Tokens
FORMNAME: [A-Z][a-zA-Z0-9]*;
QUESTION: [A-Z][a-zA-Z0-9\\? ]*;
IDENTIFIER: [a-z][a-zA-Z0-9]*;
CONDITION: [a-z][a-zA-Z0-9]*;

// Assignment
ASS: ':';

// Types
BOOLEAN: 'boolean';
MONEY: 'money';
TEXT: 'text';

// Binops
EQ: '==';
NEQ: '!=';
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
MOD: '%';
NOT: '!';
AND: '&&';
OR: '||';

WS: [ \n\t\r]+ -> skip;
