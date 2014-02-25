grammar QL;
options {backtrack=false; memoize=true; language = Java;}

@parser::header
{
package org.uva.sea.ql.parser.antlr;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.stmt.*;
import org.uva.sea.ql.ast.form.*;
import antlr.ANTLRException;
}

@lexer::header
{
package org.uva.sea.ql.parser.antlr;
}

@parser::members {
	private ArrayList<String> errors = new ArrayList <String> ();
	 
	public List<String> getAllErrors() {
	  return new ArrayList<String>(errors);
	}
	
	public boolean hasErrors() {
	  return !errors.isEmpty();
	}
	 
	public void reportError(RecognitionException e) {
		if ( state.errorRecovery ) {
		  return;
		}
		state.syntaxErrors++;
		state.errorRecovery = true;
    String hdr = getErrorHeader(e);
    String msg = getErrorMessage(e, tokenNames);
		msg = null;
		if ( e instanceof NoViableAltException ) {
			NoViableAltException nvae = (NoViableAltException)e;
			msg = " unexpected token: '"+e.token.getText()+"'";
		} else {
			msg = getErrorMessage(e, tokenNames);
		}
    errors.add(hdr+msg);
	}
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
    | 'decimal' {$result = new Decimal(Float.parseFloat("0")); }
    | 'money' {$result = new Money(Float.parseFloat("0.00")); }
    ;
    
stmt returns [Stmt result]
    : computedQuestion { $result = $computedQuestion.result; }
    | answerableQuestion { $result = $answerableQuestion.result; }
    | conditionalQestion { $result = $conditionalQestion.result; }
    ;
    
conditionalQestion returns [Stmt result]
    : 'if' '(' condition=orExpr ')' '{' block '}' { $result = new ConditionalQuestion($orExpr.result, $block.result); }
    ;
    
computedQuestion returns [Stmt result]
    : Ident ':' Str type '(' computation = orExpr ')' { $result = new ComputedQuestion(new Ident($Ident.text), $Str.text, $type.result, $computation.result); }
    ;
    
answerableQuestion returns [Stmt result]
    : Ident ':' Str type { $result = new AnswerableQuestion(new Ident($Ident.text), $Str.text, $type.result); }
    ;

block returns [Block result]
    @init
    {
      $result = new Block();
    }
    : (stmt { $result.addStmt($stmt.result); })*
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