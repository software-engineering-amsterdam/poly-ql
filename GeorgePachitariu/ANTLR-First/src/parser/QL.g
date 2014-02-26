grammar QL;

options {
  language = Java;
  output=AST;
  ASTLabelType=CommonTree;
}

@lexer::header {
  package parser;
}

@header {
  package parser;

  import expr.*;
  import expr.arithmeticExpr.*;
  import expr.conditionalExpr.*;
  import expr.relationalExpr.*;
  import expr.signExpr.*;
  import expr.syntacticExpr.*;
  import expr.types.*;
  import java.util.LinkedList;
}


// Rules
form returns [Form result]
  : 'form' IDENT '{' 
    {  
      List<Statement> list = new LinkedList<Statement>(); 
    } 
    (statement {
      list.add($statement.result);
      }
    )*
  '}' 
  { 
    $result=new Form (new Ident($IDENT.text), list); 
  };
statement returns [Statement result]
  : x=question {$result=$x.result;}
  | x=if_block {$result=$x.result;}
  ;

question returns [Question result]
  : IDENT COLONS STRING questiontype {
    $result = new Question (new Ident($IDENT.text),
     new QuestionBody($STRING.text), $questiontype.result); 
    } 
  ('('expression')' {
    $result = new Question (new Ident($IDENT.text),new QuestionBody($STRING.text), 
     $questiontype.result, $expression.result); 
    }
  )? 
  ';';  

if_block returns [IfBlock result]
  : 'if' (x=expression) '{' 
  {  
    List<Statement> list = new LinkedList<Statement>();  
  }
  ( 
    y=statement
    {
      list.add($y.result);
    }
  )* '}'
  { 
    $result = new IfBlock(new BooleanExpr($x.result), list);
  }
  (
    ELSE '{'
    {  
      List<Statement> list2 = new LinkedList<Statement>();  
    }
    (
      y=statement
      {
        list2.add($y.result);
      }
    )* 
    { 
      $result = new IfBlock(new BooleanExpr($x.result), list, list2);
    }
    '}'
  )?
  ;

expression returns [Expression result]
  : x=orExpr { $result = $x.result; }
  ;

primary returns [Expression result]
  : INT   { $result = new Int(Integer.parseInt($INT.text)); }
  | IDENT { $result = new Ident($IDENT.text); }
  | BOOLEAN { $result = new Bool(Boolean.parseBoolean($BOOLEAN.text)); } //
  | '(' x=orExpr ')'{ $result = $x.result; }            
  ;
    
unExpr returns [Expression result]
    :  '+' x=primary { $result = new Pos($x.result); }  
    |  '-' x=primary { $result = new Neg($x.result); }  
    |  '!' x=primary { $result = new Not($x.result); } 
    |  x=primary    { $result = $x.result; }
    ;    
    
mulExpr returns [Expression result]
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
    
  
addExpr returns [Expression result]
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
  
relExpr returns [Expression result]
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
    
andExpr returns [Expression result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new And($result, $rhs.result); } )*
    ;
    

orExpr returns [Expression result]
    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new Or($result, $rhs.result); } )*
    ;

questiontype  returns [Type result]
  : 'boolean' { $result = new Bool(); }
  | 'money'   { $result = new Money(); }
  | 'integer' { $result = new Int(); }
  ;
  
  // Tokens
WS  : (' ' | '\t' | '\n' | '\r') { $channel=HIDDEN; }
    ;


COMMENT      : '/*' .* '*/' {$channel=HIDDEN;}
             | '//' .* '\n' {$channel=HIDDEN;}
             ;

STRING: '"' (~'"')* '"';
BOOLEAN: 'true' | 'false';
ELSE: 'else';
INT: ('0'..'9')+;
IDENT:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
COLONS : ':';
