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
  : 'form' Ident block { $result = new Form(new Ident($Ident.text), $block.result); }
  ;

block returns [Block result]
@init { List<Stat> statements = new ArrayList<Stat>(); }
  : '{' ( stat { statements.add($stat.result); } )* '}' { $result = new Block(statements); }
  ;

stat returns [Stat result]
  : computed { $result = $computed.result; }
  | question { $result = $question.result; }
  | ifThenElse { $result = $ifThenElse.result; }
  | ifThen { $result = $ifThen.result; }
  | block { $result = $block.result; }
  ;

computed returns [Computed result]
  : Ident ':' Str type '(' orExpr ')' { $result = new Computed(new Ident($Ident.text), $Str.text, $type.result, $orExpr.result); }
  ;

question returns [Question result]
  : Ident ':' Str type { $result = new Question(new Ident($Ident.text), $Str.text, $type.result); }
  ;

type returns [org.uva.sea.ql.ast.types.Type result]
  : 'integer' { $result = new org.uva.sea.ql.ast.types.Int(); }
  | 'string' { $result = new org.uva.sea.ql.ast.types.Str(); }
  | 'boolean' { $result = new org.uva.sea.ql.ast.types.Bool(); }
  ;

ifThenElse returns [IfThenElse result]
  : 'if' '(' orExpr ')' i=stat 'else' e=stat { $result = new IfThenElse($orExpr.result, $i.result, $e.result); }
  ;

ifThen returns [IfThen result]
  : 'if' '(' orExpr ')' stat { $result = new IfThen($orExpr.result, $stat.result); }
  ;

primary returns [Expr result]
  : Int   { $result = new Int(Integer.parseInt($Int.text)); }
  | Bool  { $result = new Bool(Boolean.parseBoolean($Bool.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | Str   { $result = new Str($Str.text); }
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


// Tokens
WS
  : (' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
  ;

COMMENT 
  : '/*' .* '*/' { $channel=HIDDEN; }
  | '//' .* '\n' { $channel=HIDDEN; }
  ;

Int: ('0'..'9')+;
Bool: 	'true' | 'false';
Ident: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
Str: '"' .* '"';