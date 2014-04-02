grammar QLang;

@parser::header
{
import ast.expr.Expr;
import ast.expr.Identifier;
import ast.expr.binExpr.*;
import ast.expr.unExpr.*;
import ast.expr.literal.*;
import ast.types.*;
import ast.statement.*;
}

init returns[Form result]
	: f=form {$result=$f.result;}
	;

form returns [Form result]
	: 'form' Ident '{' s=statements '}' {$result = new Form(new Identifier($Ident.text), (StatementList)$s.result);}
	;

statements returns [StatementList result]
	: s=statement {$result = new StatementList();
					$result.addStatement($s.result);}
	| sts=statements s=statement {$result = $sts.result; 	
									$sts.result.addStatement($s.result);}
	;											
statement returns [Statement result]
	: q=question {$result = $q.result;}
	| istate=ifstatement {$result = $istate.result;}
	| iestate=ifelsestatement{$result = $iestate.result;}
	;
	
question returns [Statement result]
	: Ident ':' Str t=type {$result = new Question(new Identifier($Ident.text), new StrLiteral($Str.text), $t.result);} 
	| Ident ':' Str t=type expr=orExpr {$result = new ComputedQuestion(new Identifier($Ident.text), new StrLiteral($Str.text), $t.result, $expr.result);} 
	;

ifstatement returns [Statement result]
	: 'if' '(' expr=orExpr ')' '{' sts=statements '}' {$result = new IfStatement($sts.result, $expr.result);}
	;
	
ifelsestatement returns [Statement result]
	: 'if' '(' expr=orExpr ')' '{' sts1=statements '}' 'else' '{' sts2=statements '}' {$result = new IfelseStatement($sts1.result, $expr.result, $sts2.result);}
	;			
		
	
type returns [Type result]
    : 'boolean' {$result = new BoolType();}
    | 'string'  {$result = new StrType();}
    | 'integer' {$result = new IntType();}
    ;	

unExpr returns [Expr result]
    :  '+' x=unExpr { $result = new Pos($x.result); }
    |  '-' x=unExpr { $result = new Neg($x.result); }
    |  '!' x=unExpr { $result = new Not($x.result); }
    | y=primary    {$result = $y.result;}
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
	: Bool { $result = new BoolLiteral(Boolean.parseBoolean($Bool.text));}
	| Int {$result = new IntLiteral(Integer.parseInt($Int.text));}
	| Ident {$result = new Identifier($Ident.text);}
	| Str {$result = new StrLiteral($Str.text);}
	| '(' x=orExpr ')' { $result = $x.result; }
	;    

    
// Tokens
WS: [ \t\r\n]+ -> skip ;

COMMENT 
     : '/*' (.)*? '*/' | '//' (.)*? | '//' (NewLine)*?
    ;
NewLine: '\r'?'\n'| '\n' ;

Bool: 'true' | 'false';

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Int: ('0'..'9')+;

Str: '"' (.)*? '"';

