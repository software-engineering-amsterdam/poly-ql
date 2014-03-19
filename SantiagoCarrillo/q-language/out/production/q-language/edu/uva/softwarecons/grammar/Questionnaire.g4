grammar Questionnaire;
import CommonLexerRules; 

questionnaire:   'form' ID '{' question+ '}';

question: ID ':' STRING type                                 # simpleQuestion
    |     ID ':' STRING type '(' expr ')'                    # computedQuestion
	|	  'if' '(' expr ')' '{' question+ '}'   elsestat?    # if
    ;

elsestat: 'else' '{' question+ '}'    # else;
   
type: BOOL_TYPE        # booleanType
	| STRING_TYPE      # stringType
    | INT_TYPE         # intType
    | DATE_TYPE        # dateType
    | DECIMAL_TYPE     # decimalType
	| MONEY_TYPE       # moneyType
	;


expr:   expr (MUL|DIV) expr                         # mulDiv
    |   expr (ADD|SUB) expr                         # addSub
    |   expr (GT|GEq|LT|LEq|Eq|NEq) expr            # compare
    |   NOT expr                                    # not
    |   expr (AND) expr                             # and
    |   expr (OR) expr                              # or
    |   '(' expr ')'                                # parenthesis
    |   BOOLEAN                                     # boolean
    |   INT                                         # integer
    |   STRING                                      # string
    |   ID                                          # id
    ;

  