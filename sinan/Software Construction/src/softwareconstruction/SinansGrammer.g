grammar SinansGrammer;

@header {
    package softwareconstruction;
    import softwareconstruction.*;
    import softwareconstruction.form.*;
    import softwareconstruction.questions.*;
    import softwareconstruction.literals.*;
    import java.util.ArrayList;
}

form returns [Form fo] @init {$fo = new Form();}: 'form' IDENTIFIER {$fo.setFormName($IDENTIFIER.text);} '{' (item { $fo.addQuestion($item.object);})+ '}';

item returns [Object object] @init {$object = new Object();}: conditional {$object = $conditional.cqe;} | question {$object = $question.qe;};

question returns [Question qe] @init {$qe = new Question();} : IDENTIFIER { $qe.setQuestionName($IDENTIFIER.text); } ':' STRING { $qe.setQuestionContent($STRING.text); } TYPE { $qe.setQuestionType($TYPE.text);};

conditional returns [ConditionalQuestion cqe] @init {$cqe = new ConditionalQuestion();} : ifstatement  (item { $cqe.add($item.object); })+ '}';

ifstatement : 'if' '(' expression ')' '{';

expression returns [Expression exp]: 
    INT
    | BOOL {$exp = new BoolLiteral(Boolean.parseBoolean($BOOL.text));}
    | STRING
    | '!'? IDENTIFIER
    | expression '*' expression
    | expression '/' expression
    | expression '+' expression
    | expression '-' expression
    | expression '||' expression
    | expression '&&' expression
    | expression '==' expression
    | expression '>' expression
    | expression '<' expression
    | expression '>=' expression
    | expression '<=' expression
;

TYPE : 'boolean' | 'money';

IDENTIFIER : LETTER( LETTER | DIGIT)*;
STRING : '"' (LETTER | DIGIT | ' ')+ '"';
LETTER : ('a'..'z'|'A'..'Z'|'?');
DIGIT : ('0'..'9');
BOOL : ('true' | 'false');

OPERATOR: ('+'|'-'|'*'|'/'|'||'|'|'|'&&'|'=='|'!='|'>'|'<'|'>='|'<='|'!');
WS  :   (' '|'\n'|'\t')+ {skip();} ;