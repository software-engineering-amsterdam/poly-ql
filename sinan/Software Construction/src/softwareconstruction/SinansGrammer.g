grammar SinansGrammer;

@header {
    package softwareconstruction;
    import softwareconstruction.*;
    import softwareconstruction.form.*;
    import softwareconstruction.questions.*;
    import softwareconstruction.literals.*;
    import softwareconstruction.operators.*;
    import java.util.ArrayList;
}

form returns [Form fo] @init {$fo = new Form();}: 'form' IDENTIFIER {$fo.setFormName($IDENTIFIER.text);} '{' (item { $fo.addQuestion($item.object);})+ '}';

item returns [Object object] @init {$object = new Object();}: conditional {$object = $conditional.cqe;} | question {$object = $question.qe;};

question returns [Question qe] @init {$qe = new Question();} : IDENTIFIER { $qe.setQuestionName($IDENTIFIER.text); } ':' STRING { $qe.setQuestionContent($STRING.text); } TYPE { $qe.setQuestionType($TYPE.text);};

conditional returns [ConditionalQuestion cqe] @init {$cqe = new ConditionalQuestion();} : 'if' '(' expression {$cqe.addExpression($expression.text);}')' '{'  (item { $cqe.addQuestion($item.object); })+ '}';

expression returns [Expression exp]: 
//      INT {System.out.println("Integer Literal found! -> "+ $INT.text); $exp = new IntLiteral(Integer.parseInt($INT.text));}
//      | BOOL {System.out.println("Boolean Literal found! -> "+$BOOL.text); $exp = new BoolLiteral(Boolean.parseBoolean($BOOL.text));}
//      | STRING {System.out.println("String Literal found! -> "+$STRING.text); $exp = new StringLiteral($STRING.text);}
//      | '!'? IDENTIFIER
//    | expression '*' expression
//    | expression '/' expression
      | leftnode '+' rightnode {  System.out.println("Plus Operator found! -> +");}
//    | expression '-' expression
//    | expression '||' expression
//    | expression '&&' expression
//    | expression '==' expression
//    | expression '>' expression
//    | expression '<' expression
//    | expression '>=' expression
//    | expression '<=' expression
;

leftnode returns [LeftNode ln]: 
      INT {System.out.println("Integer Literal found! -> "+ $INT.text); $ln = new LeftNode(Integer.parseInt($INT.text));}
      | BOOL {System.out.println("Boolean Literal found! -> "+$BOOL.text); $ln = new LeftNode(Boolean.parseBoolean($BOOL.text));}
      | STRING {System.out.println("String Literal found! -> "+$STRING.text); $ln = new LeftNode($STRING.text);}
      | '!'? IDENTIFIER
;

rightnode returns [RightNode rn]: 
      INT {System.out.println("Integer Literal found! -> "+ $INT.text); $rn = new RightNode(Integer.parseInt($INT.text));}
      | BOOL {System.out.println("Boolean Literal found! -> "+$BOOL.text); $rn = new RightNode(Boolean.parseBoolean($BOOL.text));}
      | STRING {System.out.println("String Literal found! -> "+$STRING.text); $rn = new RightNode($STRING.text);}
      | '!'? IDENTIFIER
      | expression
;



//leftnode returns [Expression exp]: 
//      INT {System.out.println("Integer Literal found! -> "+ $INT.text); $exp = new IntLiteral(Integer.parseInt($INT.text));}
//      | BOOL {System.out.println("Boolean Literal found! -> "+$BOOL.text); $exp = new BoolLiteral(Boolean.parseBoolean($BOOL.text));}
//      | STRING {System.out.println("String Literal found! -> "+$STRING.text); $exp = new StringLiteral($STRING.text);}
//      | '!'? IDENTIFIER
//;
//
//rightnode returns [Expression exp]: 
//      INT {System.out.println("Integer Literal found! -> "+ $INT.text); $exp = new IntLiteral(Integer.parseInt($INT.text));}
//      | BOOL {System.out.println("Boolean Literal found! -> "+$BOOL.text); $exp = new BoolLiteral(Boolean.parseBoolean($BOOL.text));}
//      | STRING {System.out.println("String Literal found! -> "+$STRING.text); $exp = new StringLiteral($STRING.text);}
//      | '!'? IDENTIFIER
//      | expression
//;

BOOL : 'true' | 'false';
TYPE : 'boolean' | 'money';
INT : ('0'..'9')+;

IDENTIFIER : LETTER( LETTER | DIGIT)*;
STRING : '"' (LETTER | DIGIT | ' ')+ '"';
LETTER : ('a'..'z'|'A'..'Z'|'?');
DIGIT : ('0'..'9');

OPERATOR: ('+'|'-'|'*'|'/'|'||'|'|'|'&&'|'=='|'!='|'>'|'<'|'>='|'<='|'!');
WS  :   (' '|'\n'|'\t')+ {skip();} ;