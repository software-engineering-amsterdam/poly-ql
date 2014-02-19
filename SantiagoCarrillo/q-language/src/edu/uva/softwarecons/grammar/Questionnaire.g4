grammar Questionnaire;
import CommonLexerRules; 

questionnaire:   'form' ID '{' question+ '}';

question: ID ':' STRING type (expr)?                                    # quest
	|	'if' '(' expr ')' '{' question+ '}'   elsestat?                 # if
    ;

elsestat: 'else' '{' question+ '}'    # ifElse;
   
type: 'boolean'     # bool
	| 'string'      # string
    | 'integer'     # integer
    | 'date'        # date
    | 'decimal'     # decimal
	| 'money'       # money
    | 'currency'    # currency
	;


expr:   expr ('*'|'/') expr                      # MulDiv
    |   expr ('+'|'-') expr                      # AddSub
    |   expr ('>'|'>='|'<'|'<='|'=='|'!=') expr     # compare
    |   '!' expr                                    # not
    |   expr ('&&') expr                            # and
    |   expr ('||') expr                            # or
    |   ID                                          # id
    |   INT                                         # int
    |   '(' expr ')'                                # parens
    ;

  