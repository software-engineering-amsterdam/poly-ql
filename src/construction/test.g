grammar test;

@header {
package construction;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import construction.Operators.*;
import construction.Types.*;
import construction.QuestionElements.*;
}

//@lexer::header {package construction;}

@members {
/** Map variable name to Integer object holding value */
Map<String,IType> memory = new HashMap<String,IType>();
}

questionaire returns [QuestionForm form] @init {$form = new QuestionForm();}:
    'form' IDENTIFIER {$form.setName(($IDENTIFIER.text));} 
    '{' (item {$form.add($item.question);})+ '}';

item returns [GeneralQuestion question] :
    conditional {$question = $conditional.cq;}
    | computed {$question = $computed.question;}
    | questionentry {$question = $questionentry.question;};
    


questionentry returns [Question question] @init {} :
    IDENTIFIER ':' STRING type
    {$question = new Question($IDENTIFIER.text,$STRING.text.substring(1, $STRING.text.length() - 1),$type.t,$IDENTIFIER.line);};

conditional returns [ConditionalQuestion cq] @init {List<GeneralQuestion> gql = new ArrayList();} :
    'if' '(' exp {$cq = new ConditionalQuestion($exp.ex,($exp.start).getLine());} ')' 
    '{' (item {$cq.addTrueConditionQuestion($item.question);})* '}' 
    ('else' '{' (item {$cq.addFalseConditionQuestion($item.question);})*  '}')*;

computed returns [ComputedQuestion question] @init {} :
    IDENTIFIER ':' STRING type '(' exp  ')'
    {$question = new ComputedQuestion($IDENTIFIER.text,$STRING.text.substring(1, $STRING.text.length() - 1),$type.t,$exp.ex,$IDENTIFIER.line);};
    

type returns [IType t] : 'boolean'{$t = new BoolType();} 
    | 'string' { $t = new StringType();}
    | 'money'{$t = new IntType();}
    | IDENTIFIER { $t = new ErrorType($IDENTIFIER.line);};

exp returns [Expression ex]
    : INT { $ex = new IntLiteral(Integer.parseInt($INT.text),$INT.line);}
    | BOOL { $ex = new BoolLiteral(Boolean.parseBoolean($BOOL.text),$BOOL.line);}
    | STRING { $ex = new StringLiteral($STRING.text,$STRING.line);}
    | IDENTIFIER { $ex = new Variable($IDENTIFIER.text,$IDENTIFIER.line);}                    
    | '-' exp 
    | 'not' exp 
    | exp '^' exp
    | exp '%' exp 
    | l=exp '*' r=exp {$ex = new Multiplication($l.ex,$r.ex,($l.start).getLine());}  
    | l=exp '/' r=exp {$ex = new Division($l.ex,$r.ex,($l.start).getLine());}  
    | l=exp '-' r=exp {$ex = new Minus($l.ex,$r.ex,($l.start).getLine());}  
    | l=exp '+' r=exp {$ex = new Plus($l.ex,$r.ex,($l.start).getLine());}
    | l=exp '<' r=exp {$ex = new SmallerThan($l.ex,$r.ex,($l.start).getLine());}
    | l=exp '<=' r=exp {$ex = new SmallerThanEquals($l.ex,$r.ex,($l.start).getLine());}
    | l=exp '>' r=exp {$ex = new GreaterThan($l.ex,$r.ex,($l.start).getLine());}
    | l=exp '>=' r=exp {$ex = new GreaterThanEquals($l.ex,$r.ex,($l.start).getLine());}
    | l=exp '==' r=exp {$ex = new Equals($l.ex,$r.ex,($l.start).getLine());} 
    | exp '~=' exp 
    | l=exp 'and' r=exp {$ex = new And($l.ex,$r.ex,($l.start).getLine());} 
    | l=exp 'or' r=exp {$ex = new Or($l.ex,$r.ex,($l.start).getLine());} 
    | '(' e=exp ')' {$ex = $e.ex;};

BOOL : 'true' | 'false';

INT :   ('0'..'9')+ ;
IDENTIFIER  :   ('a'..'z'|'A'..'Z'|'0'..'9')+ ;
STRING      :  '"' ('a'..'z'|'A'..'Z'|'0'..'9'|' ')+ '"';

WS  :   (' '|'\t'|'\n'|'\r')+ {skip();} ;
