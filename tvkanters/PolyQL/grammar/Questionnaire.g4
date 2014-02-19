grammar Questionnaire;

@header {
    package nl.uva.polyql.antlr4;
    import nl.uva.polyql.model.*;
}


form returns [Form fo]
	@init { $fo = new Form(); } :
	'form' IDENTIFIER '{' (r = formrule {  })+ '}';

formrule returns [Rule r]
	@init{ $r = new Rule(); } : 
	(q = question { $r = $q.q; }) | (is = ifstatement { $r = $is.is; });

question returns [Question q]
	@init {$q = new Question();} : 
	IDENTIFIER { $q.setId($IDENTIFIER.text); } ':' STRING { $q.setContent($STRING.text); } TYPE { $q.setType(Type.fromString($IDENTIFIER.text)); };

ifstatement returns [IfStatement is]
	@init {$is = new IfStatement(); } :
	'if' '(' IDENTIFIER { System.out.println("IF " + $IDENTIFIER.text); } ')' '{' formrule+ '}';


TYPE : ('boolean'|'money');
IDENTIFIER : (LETTER | DIGIT)+;
STRING : '"' (LETTER | DIGIT | PUNCTUATION)+ '?' '"';
LETTER : ('a'..'z'|'A'..'Z');
DIGIT : ('0'..'9');
WS  :   (' '|'\n'|'\r'|'\t')+ {skip();} ;
PUNCTUATION : ('\''|','|'.'|'?'|'!'|' ');
