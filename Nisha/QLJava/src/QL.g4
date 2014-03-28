grammar QL;

@header {
	package antlr4;
	import ast.form.*;
	import ast.type.*;
	import ast.literals.*;
	import expr.conditional.*;
	import expr.operation.*;
	import expr.relational.*;
	import expr.unary.*;
	import expr.Expr;
	import expr.Ident;
	
	
}

forms returns [Form result]
                       : 'form' Ident  '{' NEWLINE s= statements NEWLINE'}' {$result= new Form(new Ident($Ident.text), (StatementList)$s.result); }
                       ;


statements returns [StatementList result]
	: s1=statement {$result = new StatementList();
					$result.addStatement($s1.result);}
	| sts=statements s=statement {$result = $sts.result; 	
									$sts.result.addStatement($s.result);}
	;									

statement returns [Statement result]
     : q=question {$result = $q.result;}
     |x= ifstatement{$result= $x.result;}
     |y= ifelsestate{$result= $y.result;}
     ;   
     
question returns [Statement result] 
     : Ident ':' Str v1=valuetype NEWLINE {$result = new Question(new Ident($Ident.text), new StrLiteral($Str.text), $v1.result);}                                        
     | Ident ':' Str v2=valuetype'(' e1= orExpr ')' NEWLINE {$result = new Computedquest (new Ident($Ident.text), new StrLiteral($Str.text), $v2.result, $e1.result);}
     ;
     
ifstatement returns [Statement result]
        : 'if' '(' expr=orExpr ')' '{' NEWLINE s=statements '}' {$result = new Ifstate($s.result, $expr.result);}
        ;
          
ifelsestate returns [Statement result]
         : 'if' '(' expr=orExpr ')' '{' NEWLINE s1=statements '}' NEWLINE 'else' '{' NEWLINE s2=statements NEWLINE '}' {$result = new IfElse($s1.result, $expr.result, $s2.result);}
         ;  
   
unExpr returns [Expr result]		
    :  '+' x=unExpr { $result = new Pos($x.result); }
    |  '-' x=unExpr { $result = new Neg($x.result); }
    |  '!' x=unExpr { $result = new Not($x.result); }
    |  r=primary    { $result = $r.result; }
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

primary returns [Expr result]
  :Bool { $result = new BoolLiteral(Boolean.parseBoolean($Bool.text));}
  | Int   { $result = new IntLiteral(Integer.parseInt($Int.text)); }
  | Ident { $result = new Ident($Ident.text); }
  | Str {$result = new StrLiteral($Str.text);}
  | '(' x=orExpr ')'{ $result = $x.result; }
  ;

valuetype returns [Type result]
          : 'boolean' {$result = new Booltype();}
          | 'integer' {$result = new Inttype(); }
          |'string'  {$result = new Strtype();}
          ;
    
// Tokens
WS  :	(' ' | '\t' | '\n' | '\r') -> channel(HIDDEN)
    ;

COMMENT 
     : ('/*' (.)*? '*/' | '//' (.)*? '//')-> channel(HIDDEN)
    ;
    
 Bool: 'true' | 'false';

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;

Str: '"' (.)*? '"';

 
NEWLINE : '\r'? '\n' ;
     
 
 	      