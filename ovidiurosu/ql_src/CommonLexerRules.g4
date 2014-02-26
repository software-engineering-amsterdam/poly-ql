// Lexer Grammar
lexer grammar CommonLexerRules;

// Literals
INT: [0-9]+; // integers

DEC : DIGIT+ '.' DIGIT+;
fragment DIGIT: [0-9];

STRING: '"' (ESC|.)*? '"';
fragment ESC : '\\"' | '\\\\'; // 2-char sequences \" and \\

NEWLINE: '\r'? '\n'; // newlines

// Types
BOOLEAN: 'boolean';
MONEY:   'money';
TEXT:    'text';

// Boolean Values
TRUE: 'true';
FALSE: 'false';

//Attention!!! Begins with an alphabetic character or an underscore character
ID: [a-zA-Z_]+ [a-zA-Z_0-9]*; // identifiers

// Unary Operators
// Unary plus -> ADD
// Unary minus -> SUB
NOT: '!'; // Logical complement

// Binary Operators
// Arithmetic
MUL: '*';
DIV: '/';
REM: '%';
ADD: '+';
SUB: '-';

// Relational
LT: '<';
GT: '>';
LTQ: '<=';
GTQ: '>=';

// Equality
EQ: '==';
NEQ: '!=';

// Conditional
LA: '&&';
LO: '||';

// Skip rules
WS: [ \t]+ -> skip;                     // remove whitespace
LINE_COMMENT: '//' .*? NEWLINE -> skip; // remove single line comments
COMMENT: '/*' .*? '*/' -> skip;         // remove multiline comments
