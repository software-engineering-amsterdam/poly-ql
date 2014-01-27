grammar QL;
options {backtrack=true; memoize=true;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.stat.*;
import org.uva.sea.ql.ast.form.*;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}


form returns [Form result]
  : 'form' Ident body=block { $result = new Form(new Ident($Ident.text), $body.result); }
  ;
  
block returns [Block result]
@init { List<Stat> stats = new ArrayList<Stat>(); }
  : '{' ( s=stat { stats.add($s.result); } )* '}' { $result = new Block(stats); }
  ;
  
stat returns [Stat result]
  : 'if' '(' c=orExpr ')' tru=stat 'else' fls=stat { $result = new IfThenElse($c.result, $tru.result, $fls.result); }
  | 'if' '(' c=orExpr ')' tru=stat { $result = new IfThen($c.result, $tru.result); }
  | b=block { $result = $b.result; }
  | l=label name=Ident ':' t=type '(' e=orExpr ')' { $result = new Computed($l.result, new Ident($name.text), $t.result, $e.result); }
  | l=label name=Ident ':' t=type { $result = new Answerable($l.result, new Ident($name.text), $t.result); }   
  ;

label returns [Label result]
  : Str { $result = new Label($Str.text); }
  ;
  
type returns [org.uva.sea.ql.ast.types.Type result]
  : 'int' { $result = new org.uva.sea.ql.ast.types.Int(); }
  | 'str' { $result = new org.uva.sea.ql.ast.types.Str(); }
  | 'bool' { $result = new org.uva.sea.ql.ast.types.Bool(); }
  ;
  
primary returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | Str   { $result = new Str($Str.text); }
  | bool  { $result = $bool.result; }
  | '(' x=orExpr ')'{ $result = $x.result; }
  ;
  
bool returns [Expr result]
  : 'true'  { $result = new Bool(true); }
  | 'false' { $result = new Bool(true); }
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
      if ($op.text.equals("<=")) {
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

    
// Tokens
WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

COMMENT 
     : '/*' .* '*/' {$channel=HIDDEN;}
    ;

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;

Str: '"' .* '"';