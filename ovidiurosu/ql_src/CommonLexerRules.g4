// Lexer Grammar
lexer grammar CommonLexerRules;

// Literals
INT: [0-9]+; // integers

DEC : DIGIT+ '.' DIGIT+;
fragment DIGIT: [0-9];

STRING: '"' (ESC|.)*? '"';
fragment ESC : '\\"' | '\\\\'; // 2-char sequences \" and \\

// Type tokens
BOOLEAN: 'boolean';
INTEGER: 'integer';
DECIMAL: 'decimal';
MONEY:   'money';
DATE:    'date';
STRINGT: 'string';

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
LTE: '<=';
GTE: '>=';
LT: '<';
GT: '>';

// Equality
EQ: '==';
NEQ: '!=';

// Conditional
LA: '&&';
LO: '||';

// Skip rules
WHITESPACE: [ \t]+ -> skip;                // remove whitespace
LINE_COMMENT: '//' .*? '\r'? '\n' -> skip; // remove single line comments
MULTILINE_COMMENT: '/*' .*? '*/' -> skip;  // remove multiline comments
NEWLINE: '\r'? '\n' -> skip;               // remove newlines
