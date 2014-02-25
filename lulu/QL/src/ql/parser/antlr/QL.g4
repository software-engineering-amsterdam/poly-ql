grammar QL;
options {backtrack=true; memoize=true;}

@header
{
package ql.parser.antlr;
import ql.ast.expr.*;
import ql.ast.stat.*;
import ql.ast.form.*;
import ql.ast.form.QuestionType.*;
import ql.ast.expr.ExprType.*;
}

//@lexer::header
//{
//package ql.parser.antlr;
//}

form returns[Form result]
: 'form' Ident f=formItems
{ $result = new Form(new Ident($Ident.text), $f.result); }
;

//(WS | WS COMMENT WS) 

formItems returns [List<FormItems> result]
@init { List<FormItems> formItems = new ArrayList(); }
: '{' NEWLINE
	(q=question {formItems.add($q.result);}
//	| s=stat {formItems.add($s.result);}
	)* 
	'}' NEWLINE
	
{ $result = formItems; } 
;
		

question returns [Question result]
: Ident ':' Str t=type NEWLINE
{ $result = new Question(new Ident($Ident.text), $Str.text, $t.result); }
//| Ident ':' s=str t=type '(' x=orExpr ')' (WS | WS COMMENT WS)
//{ $result = new Question(new Ident($Ident.text), $s.text, $t.result, $x.result); }
;

type returns [Type result]
: 'boolean' { $result = new Bool();}
| 'int' { $result = new Int();}	
| 'string' { $result = new Str();}
;

//stat returns [Statement result]
//: 'if' '(' orExpr ')' formItems	#IFstatement
//;
// 
//    
//unExpr returns [Expr result]
//    :  '+' x=unExpr { $result = new Pos($x.result); }
//    |  '-' x=unExpr { $result = new Neg($x.result); }
//    |  '!' x=unExpr { $result = new Not($x.result); }
//    |  x=primary    { $result = $x.result; }
//    ;    
//
//primary returns [Expr result]
//: Int { $result = new IntExpr(Integer.parseInt($Int.text));}
//| Bool { $result = new BoolExpr(BoolExpr.parseBoolean($Bool.text));}
//| x=str { $result = new StrExpr($x.text); }
//| Ident { $result = new Ident($Ident.text); }
//| '(' x=orExpr ')'{ $result = $x.result;}
//;
//    
//mulExpr returns [Expr result]
//    :   lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
//    { 
//      if ($op.text.equals("*")) {
//        $result = new Mul($result, rhs);
//      }
//      if ($op.text.equals("<=")) {
//        $result = new Div($result, rhs);      
//      }
//    })*
//    ;
//    
//  
//addExpr returns [Expr result]
//    :   lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
//    { 
//      if ($op.text.equals("+")) {
//        $result = new Add($result, rhs);
//      }
//      if ($op.text.equals("-")) {
//        $result = new Sub($result, rhs);      
//      }
//    })*
//    ;
//  
//relExpr returns [Expr result]
//    :   lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
//    { 
//      if ($op.text.equals("<")) {
//        $result = new LT($result, rhs);
//      }
//      if ($op.text.equals("<=")) {
//        $result = new LEq($result, rhs);      
//      }
//      if ($op.text.equals(">")) {
//        $result = new GT($result, rhs);
//      }
//      if ($op.text.equals(">=")) {
//        $result = new GEq($result, rhs);      
//      }
//      if ($op.text.equals("==")) {
//        $result = new Eq($result, rhs);
//      }
//      if ($op.text.equals("!=")) {
//        $result = new NEq($result, rhs);
//      }
//    })*
//    ;
//    
//andExpr returns [Expr result]
//    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, rhs); } )*
//    ;
//    
//
//orExpr returns [Expr result]
//    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, rhs); } )*
//    ;
    
//str returns [String result] 
//: '"' .*? '"' {setText(getText().substring(1,getText().length() - 1)); }
//;

Str: '"' .*? '"' ;
NEWLINE : '\r'? '\n' ;
WS  :	(' ' | '\t' | '\n' | '\r') -> channel(HIDDEN)
    ;

COMMENT : ('/*' .* '*/' | '//' .*?) -> channel(HIDDEN)
    ;

Ident: [a-zA-Z0-9]+;

Int: ('0'..'9')+;
Bool: 'true' | 'false';