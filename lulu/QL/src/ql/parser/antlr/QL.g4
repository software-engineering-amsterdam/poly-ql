grammar QL;
//options {backtrack=true; memoize=true;}

@header
{
package ql.parser.antlr;
import ql.ast.expr.*;
import ql.ast.form.stat.*;
import ql.ast.form.*;
import ql.ast.type.*;
import ql.ast.expr.exprType.*;
import ql.ast.expr.operation.*;
import ql.ast.expr.operation.add.*;
import ql.ast.expr.operation.andor.*;
import ql.ast.expr.operation.mul.*;
import ql.ast.expr.operation.rel.*;
import ql.ast.expr.operation.un.*;
}

//@lexer::header
//{
//package ql.parser.antlr;
//}

form returns[Form result]
: 'form' Ident f=formItems
{ $result = new Form(new Ident($Ident.text), $f.result); }
;

formItems returns [List<FormItems> result]
@init { List<FormItems> formItems = new ArrayList(); }
: '{'
	(q=question {formItems.add($q.result);}
	| s=stat {formItems.add($s.result);}
	)* 
	'}'
	
{ $result = formItems; } 
;
		

question returns [Question result]
: Ident ':' Str t=type
{ $result = new Question(new Ident($Ident.text), $Str.text, $t.result); }
| Ident ':' Str t=type '(' x=orExpr ')'
{ $result = new ComputedQuestion(new Ident($Ident.text), $Str.text, $t.result, $x.result); }
;

type returns [Type result]
: 'boolean' { $result = new BoolType();}
| 'int' { $result = new IntType();}	
| 'string' { $result = new StrType();}
;

stat returns [Statement result]
: 'if' '(' or=orExpr ')' ifBody=formItems
{ $result = new IfStatement($or.result, $ifBody.result); }
| 'if' '(' or=orExpr ')' ifBody=formItems
  'else' elseBody=formItems 
{ $result = new IfElseStatement($or.result, $ifBody.result, $elseBody.result); }
;
 
    

unExpr returns [Expr result]
    :  '+' x=unExpr { $result = new Pos($x.result); }
    |  '-' x=unExpr { $result = new Neg($x.result); }
    |  '!' x=unExpr { $result = new Not($x.result); }
    |  r=expr    { $result = $r.result; }
    ;    

expr returns [Expr result]
: Int { $result = new IntExpr(Integer.parseInt($Int.text));}
| Bool { $result = new BoolExpr(Boolean.parseBoolean($Bool.text));}
| Str { $result = new StrExpr($Str.text); }
| Ident { $result = new Ident($Ident.text); }
| '(' x=orExpr ')'{ $result = $x.result;}
;
   
mulExpr returns [Expr result]
    :   lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
    { 
      if ($op.text.equals("*")) {
        $result = new Mul($result, $rhs.result);
      }
      if ($op.text.equals("/")) {
        $result = new Div($result, $rhs.result);      
      }
    })*
    ;
  
addExpr returns [Expr result]
    :   lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
    { 
      if ($op.text.equals("+")) {
        $result = new Add($result, $rhs.result);
      }
      if ($op.text.equals("-")) {
        $result = new Sub($result, $rhs.result);      
      }
    })*
    ;
  
relExpr returns [Expr result]
    :   lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
    { 
      if ($op.text.equals("<")) {
        $result = new LT($result, $rhs.result);
      }
      if ($op.text.equals("<=")) {
        $result = new LEq($result, $rhs.result);      
      }
      if ($op.text.equals(">")) {
        $result = new GT($result, $rhs.result);
      }
      if ($op.text.equals(">=")) {
        $result = new GEq($result, $rhs.result);      
      }
      if ($op.text.equals("==")) {
        $result = new Eq($result, $rhs.result);
      }
      if ($op.text.equals("!=")) {
        $result = new NEq($result, $rhs.result);
      }
    })*
    ;
    
andExpr returns [Expr result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, $rhs.result); } )*
    ;
    

orExpr returns [Expr result]
    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, $rhs.result); } )*
    ;
    
//str returns [String result] 
//: '"' .*? '"' {setText(getText().substring(1,getText().length() - 1)); }
//;

Str: '"' .*? '"' ;

WS  :	(' ' | '\t' | '\n' | '\r') -> channel(HIDDEN)
    ;

COMMENT : ('/*' .*? '*/' | '//'.*? '\n') -> channel(HIDDEN)
    ;

Int: ('0'..'9')+;
Bool: 'true' | 'false';
Ident: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;