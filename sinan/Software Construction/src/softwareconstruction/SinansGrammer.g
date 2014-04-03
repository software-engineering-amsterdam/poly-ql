grammar SinansGrammer;

@header {
    package softwareconstruction;
    import softwareconstruction.*;
    import softwareconstruction.form.*;
    import softwareconstruction.questions.*;
    import softwareconstruction.literals.*;
    import softwareconstruction.operators.*;
    import softwareconstruction.types.*;
    import java.util.ArrayList;
}

form returns [Form fo] @init {$fo = new Form();}: 'form' IDENTIFIER {$fo.setFormName($IDENTIFIER.text);} '{' (item { $fo.addQuestion($item.gq);})+ '}';

item returns [QuestionInterface gq] @init{}: conditional {$gq = $conditional.cqe;} | question {$gq = $question.qe;};

question returns [Question qe] @init {$qe = new Question();} : IDENTIFIER { $qe.setQuestionName($IDENTIFIER.text); } ':' STRING { $qe.setQuestionContent($STRING.text); } type { $qe.setQuestionType($type.stype);};

conditional returns [ConditionalQuestion cqe] @init {$cqe = new ConditionalQuestion();} : 'if' '(' expression {$cqe.addExpression($expression.exp);}')' '{'  (item { $cqe.addQuestion($item.gq); })+ '}';

expression returns [Expression exp]: 
      INT {System.out.println("Integer Literal found! -> "+ $INT.text); $exp = new IntLiteral(Integer.parseInt($INT.text));}
      | BOOL {System.out.println("Boolean Literal found! -> "+$BOOL.text); $exp = new BoolLiteral(Boolean.parseBoolean($BOOL.text));}
      | STRING {System.out.println("String Literal found! -> "+$STRING.text); $exp = new StringLiteral($STRING.text);}
      | IDENTIFIER {$exp = new Variable($IDENTIFIER.text);}
//    | '!'? IDENTIFIER
//    | expression '*' expression
//    | expression '/' expression
      | l=expression '+' r=expression { System.out.println($l.text); System.out.println($r.text); $exp = new Plus($l.exp, $r.exp); }//System.out.println("Plus Operator found! -> +");}
//      | leftnode '-' rightnode { $exp = new Minus($leftnode.ln, $rightnode.rn); }
//    | expression '||' expression
//    | expression '&&' expression
//    | expression '==' expression
//    | expression '>' expression
//    | expression '<' expression
//    | expression '>=' expression
//    | expression '<=' expression
;
type returns [SuperType stype] @init {}:
    'boolean' {$stype = new BoolType();}| 
    'int'{$stype = new IntType();} | 
    'string' {$stype = new StringType();};

BOOL : 'true' | 'false';
INT : ('0'..'9')+;

IDENTIFIER : LETTER( LETTER | DIGIT)*;
STRING : '"' (LETTER | DIGIT | ' ')+ '"';
LETTER : ('a'..'z'|'A'..'Z'|'?');
DIGIT : ('0'..'9');

OPERATOR: ('+'|'-'|'*'|'/'|'||'|'|'|'&&'|'=='|'!='|'>'|'<'|'>='|'<='|'!');
WS  :   (' '|'\n'|'\t')+ {skip();} ;