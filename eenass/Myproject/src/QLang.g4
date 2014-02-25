grammar QLang;

@parser::header
{
import ast.expr.Expr;
import ast.expr.IdentLiteral;
import ast.expr.binExpr.*;
import ast.expr.unExpression.*;
import ast.expr.literal.*;
import ast.expr.types.*;
}


unExpr returns [Expr result]
    :  y=primary    {$result = $y.result;}
    |  '+' x=unExpr { $result = new Pos($x.result); }
    |  '-' x=unExpr { $result = new Neg($x.result); }
    |  '!' x=unExpr { $result = new Not($x.result); }

	; 
primary returns [Expr result]
	: '(' x=orExpr ')' { $result = $x.result; }
	| Bool { $result = new BoolLiteral(Boolean.parseBoolean($Bool.text));}
	| Int {$result = new IntLiteral(Integer.parseInt($Int.text));}
	| Ident {$result = new IdentLiteral($Ident.text);}
	| Str {$result = new StrLiteral($Str.text);}
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

type returns [Types result]
    : 'boolean' {$result = new BoolType();}
    | 'string'  {$result = new StrType();}
    | 'integer' {$result = new IntType();}
    ;	
    
// Tokens
WS  :	(' ' | '\t' | '\n' | '\r')
    ;

COMMENT 
     : '/*' (.)*? '*/' | '//' (.)*? | '//' (NewLine)*?
    ;
NewLine: '\n' | '\r\n';

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;

Str: '"' (.)*? '"';

Bool: 'true' | 'false';