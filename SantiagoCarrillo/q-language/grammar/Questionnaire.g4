grammar Questionnaire;
import CommonLexerRules; 

questionnaire:   'form' ID '{' question+ '}';

question: ID ':' STRING type (expr)?
	|	'if' '(' expr ')' '{' question+ '}'
    ;

   
type: 'boolean' 
	| 'string'
    | 'string'
    | 'integer'
    | 'date'
    | 'decimal'
	| 'money'
    | 'currency'
	;


expr:   expr op=('*'|'/') expr   
    |   expr op=('+'|'-') expr 
    |   expr ('>'|'>='|'<'|'<='|'=='|'!=') expr
    |   '!' expr
    |   expr ('&&') expr
    |   expr ('||') expr
    |   ID 
    |   INT                                           
    |   '(' expr ')'    
    ;

  