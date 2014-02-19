grammar QL;
options {backtrack=false; memoize=true;}

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

primary returns [Expr result]
    : Bool {
        if($Bool.text.equals("true")){
          $result = new Bool(true);
        }else{
          $result = new Bool(false);
        }
      }
    | Decimal {$result = new Decimal(Float.parseFloat($Decimal.text));}
    | Int {$result = new Int(Integer.parseInt($Int.text));}
    | Str {$result = new Str($Str.text);}
    | Ident {$result = new Ident($Ident.text);}
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
    
type returns [Expr result]
    : 'boolean' {$result = new Bool(false); }
    | 'string' {$result = new Str(""); }
    | 'integer' {$result = new Int(0); }
//    | 'date'
    | 'decimal' {$result = new Decimal(Float.parseFloat("0,00")); }
    | 'money' {$result = new Money(Float.parseFloat("0,00")); }
    ;
    
statement returns [Statement result]
    : conditionalQestion { $result = $conditionalQestion.result; }
    | computedQuestion { $result = $computedQuestion.result; }
    | answerableQuestion { $result = $answerableQuestion.result; }
    ;
    
answerableQuestion returns [Statement result]
    : Ident ':' Str type { $result = new AnswerableQuestion(new Ident($Ident.text), $Str.text, $type.result); }
    ;

computedQuestion returns [Statement result]
    : Ident ':' Str type '(' addExpr ')' { $result = new ComputedQuestion(new Ident($Ident.text), $Str.text, $type.result, $addExpr.result); }
    ;
    
conditionalQestion returns [Statement result]
    : 'if' '(' condition=orExpr ')' '{' block '}' { $result = new ConditionalQuestion($orExpr.result, $block.result); }
    ;
    
block returns [Block result]
    @init
    {
      $result = new Block();
    }
    : (statement { $result.addStmt($statement.result); })*
    ;
    
form returns [Form result]
    : 'form' Ident '{' block '}' { $result = new Form(new Ident($Ident.text), $block.result); }
    ;
    
// Tokens
WS  :	(' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;

SLComment
    : '//'(.)*('\r')*'\n' {$channel=HIDDEN;}
    ;
  
 MLCOMMENT 
    : '/*' .* '*/' {$channel=HIDDEN;}
    ;

Bool
    : 'true'
    | 'false'
    ;
    
Ident
    :   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

Str
    : '"' .* '"'
    ;

Int
    : ('0'..'9')+
    ;
    
Decimal
    : Int ',' Int
    ;