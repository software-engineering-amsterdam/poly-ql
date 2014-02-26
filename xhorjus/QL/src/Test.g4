/** Grammars always start with a grammar header. This grammar is called
 *  ArrayInit and must match the filename: ArrayInit.g4
 */
grammar Test;

@header {
	package antlr4;
}

//questionnare : expr;
questionnare    : form*;
form            : 'form' ID block;
block           : '{' statement* '}'; 

statement       : 'if' LP expr RP block                # StatementIf
				| 'if' '(' expr ')' block 'else' block # StatementIfElse
				| QUESTIONTITLE ':' STRING qtype       # StatementAssignment 
				;
				
qtype           : 'boolean' # StatementBoolean
                | 'money'   # StatementMoney
                | 'string'  # StatementString
                ;

intLit          : INT     # Integer
                | DECIMAL # Decimal
                ;
                
boolLit         : 'true'  # LiteralTrue
                | 'false' # LiteralFalse
                ;

expr            : '!' expr       # Neg
                | '(' expr ')'   # Parentheses
				| expr '*' expr  # Mul
                | expr '/' expr  # Div
                | expr '+' expr  # Add
                | expr '-' expr  # Sub
                | expr '%' expr  # Mod
                | expr '>' expr  # Gt
                | expr '<' expr  # Lt
                | expr '>=' expr # GtEq
                | expr '<=' expr # LtEq
                | expr '==' expr # Eq
                | expr '!=' expr # Neq
                | expr '&&' expr # And
                | expr '||' expr # Or            
                | intLit         # LiteralInt
                | boolLit        # LiteralBool
                | QUESTIONTITLE  # Id
                ;

INT             : [0-9]+;
DECIMAL         : INT '.' INT;
STRING          : '"' (SLASHES|.)*? '"';
ID              : [A-Z][a-zA-Z0-9_]*;
QUESTIONTITLE   : [a-z][a-zA-Z0-9_]*;
ASSIGNMENT      : ':';
LP              : '(';
RP              : ')'; 
SLASHES         : '\\"' | '\\\\';
WS              : [ \t\r\n]+ -> skip;

/* From http://stackoverflow.com/questions/14778570/antlr-4-channel-hidden-and-options */
COMMENT
    :   ( '//' ~[\r\n]* '\r'? '\n'
        | '/*' .*? '*/'
        ) -> skip;