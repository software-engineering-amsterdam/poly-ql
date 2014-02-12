grammar SinansGrammer;

@header {
    package softwareconstruction;
    import java.util.HashMap;
}

form : 'form' IDENTIFIER '{' question+ '}' {System.out.println("Form name:"+$IDENTIFIER.text);};

question: IDENTIFIER {System.out.println("Question name: "+$IDENTIFIER.text);} ':' '"' IDENTIFIER+ {System.out.println("Question content: "+$IDENTIFIER.text);} '?' '"' IDENTIFIER {System.out.println("Question type: "+$IDENTIFIER.text + "\n---------------------");};

IDENTIFIER  :   ('a'..'z'|'A'..'Z'|'0'..'9')+ ;
WS  :   (' '|'\n'|'\t')+ {skip();} ;

//form Box1HouseOwning {
//  "Did you sell a house in 2010?" hasSoldHouse: boolean
//  "Did you by a house in 2010?" hasBoughtHouse: boolean
//  "Did you enter a loan for maintenance/reconstruction?"
//hasMaintLoan: boolean
//  if (hasSoldHouse) {
//    "Private debts for the sold house:" privateDebt: money
//    "Price the house was sold for:" sellingPrice: money
//    "Value residue:" valueResidue = sellingPrice - privateDebt
//} }

//@lexer::header{
//    package myantlrproject;
//}

//@members {
///** Map variable name to Integer object holding value */
//HashMap memory = new HashMap();
//}
//
//prog:   stat+ ;
//                
//stat:   expr NEWLINE {System.out.println($expr.value);}
//    |   ID '=' expr NEWLINE
//        {memory.put($ID.text, new Integer($expr.value));}
//    |   NEWLINE
//    ;
//
//expr returns [int value]
//    :   e=multExpr {$value = $e.value;}
//        (   '+' e=multExpr {$value += $e.value;}
//        |   '-' e=multExpr {$value -= $e.value;}
//        )*
//    ;
//
//multExpr returns [int value]
//    :   e=atom {$value = $e.value;} ('*' e=atom {$value *= $e.value;})*
//    ; 
//
//atom returns [int value]
//    :   INT {$value = Integer.parseInt($INT.text);}
//    |   ID
//        {
//        Integer v = (Integer)memory.get($ID.text);
//        if ( v!=null ) $value = v.intValue();
//        else System.err.println("undefined variable "+$ID.text);
//        }
//    |   '(' expr ')' {$value = $expr.value;}
//    ;
//
//ID  :   ('a'..'z'|'A'..'Z')+ ;
//INT :   '0'..'9'+ ;
//NEWLINE:'\r'? '\n' ;
//WS  :   (' '|'\t')+ {skip();} ;
