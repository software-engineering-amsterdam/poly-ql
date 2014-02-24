grammar Sample;

options {
  language = Java;
}

@header {
  package a.b.c;
}

@lexer::header {
  package a.b.c;
}

//test
// Rules
rule: 'form' IDENT '{' form '}' ;
form: statement*;
statement: question | if_block;
question: IDENT COLONS string (type | type'('expression')');	
string: '"' .* '"';
type: BOOLEAN | MONEY;
if_block: 'if' (expression) '{' statement* '}';
expression: orExpr; 

primary returns [Expr result]
  : INT   { $result = new Int(Integer.parseInt($Int.text)); }
  | IDENT { $result = new Ident($Ident.text); }
  | '(' x=orExpr ')'{ $result = $x.result; }
  ;
    
unExpr returns [Expr result]
    :  '+' x=unExpr { $result = new Pos($x.result); }
    |  '-' x=unExpr { $result = new Neg($x.result); }
    |  '!' x=unExpr { $result = new Not($x.result); }
    |  x=primary    { $result = $x.result; }
    ;    
    
mulExpr returns [Expr result]
    :   lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
    { 
      if ($op.text.equals("*")) {
        $result = new Mul($result, rhs);
      }
      if ($op.text.equals("/")) {       
        $result = new Div($result, rhs);      
      }
    })*
    ;
    
  
addExpr returns [Expr result]
    :   lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
    { 
      if ($op.text.equals("+")) {
        $result = new Add($result, rhs);
      }
      if ($op.text.equals("-")) {
        $result = new Sub($result, rhs);      
      }
    })*
    ;
  
relExpr returns [Expr result]
    :   lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
    { 
      if ($op.text.equals("<")) {
        $result = new LT($result, rhs);
      }
      if ($op.text.equals("<=")) {
        $result = new LEq($result, rhs);      
      }
      if ($op.text.equals(">")) {
        $result = new GT($result, rhs);
      }
      if ($op.text.equals(">=")) {
        $result = new GEq($result, rhs);      
      }
      if ($op.text.equals("==")) {
        $result = new Eq($result, rhs);
      }
      if ($op.text.equals("!=")) {
        $result = new NEq($result, rhs);
      }
    })*
    ;
    
andExpr returns [Expr result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
    ;
    

orExpr returns [Expr result]
    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
    ;

//atom returns [int value]
//    :   INT {$value = Integer.parseInt($INT.text);}
//    |   ID  {
//        				Integer v = (Integer)memory.get($ID.text);
//        				if ( v!=null ) $value = v.intValue();
//        					else System.err.println("undefined question"+$ID.text);
//            }
//    ;



// Tokens
WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT      : '/*' .* '*/' {$channel=HIDDEN;}
             | '//' .* '\n' {$channel=HIDDEN;}
             ;
BOOLEAN: 'boolean';
MONEY: 'money';
INT: ('0'..'9')+;
IDENT:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
COLONS : ':';