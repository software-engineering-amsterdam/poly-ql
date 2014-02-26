grammar Questionnaire;
import CommonLexerRules; 

questionnaire:   'form' ID '{' question+ '}';

question: ID ':' STRING type                                 # simpleQuestion
    |     ID ':' STRING type (expr)                          # expQuestion
	|	  'if' '(' expr ')' '{' question+ '}'   elsestat?    # if
    ;

elsestat: 'else' '{' question+ '}'    # ifElse;
   
type: BOOL_TYPE        # bool
	| STRING_TYPE      # string
    | INT_TYPE         # integer
    | DATE_TYPE        # date
    | DECIMAL_TYPE     # decimal
	| MONEY_TYPE       # money
	;


expr:   expr (MUL|DIV) expr                         # mulDiv
    |   expr (ADD|SUB) expr                         # addSub
    |   expr (GT|GEq|LT|LEq|Eq|NEq) expr            # compare
    |   NOT expr                                    # not
    |   expr (AND) expr                             # and
    |   expr (OR) expr                              # or
    |   ID                                          # variable
    |   INT                                         # int
    |   '(' expr ')'                                # parenthesis
    ;

  