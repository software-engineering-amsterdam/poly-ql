// CSV.g  
grammar FormGrammar; 

@header{import main.nl.uva.parser.elements.*;}
import SimpleType;

forms returns [List<ParserForm> data] 
@init {$data = new ArrayList<ParserForm>();}
	:(f=form {$data.add($f.f);})+ EOF  
  ;

// The start rule -> begin parsing here
//init returns [ ParserForm f ]: 
//(LINEEND)*? initForm=form{$f = new ParserForm($initForm.text)} (LINEEND)*?;

form returns [ParserForm f]: 
'form' ID block {$f = new ParserForm($ID.text);};

block: (LINEEND)*? '{' LINEEND stat* '}' (LINEEND)*?;

stat: ID ':' STRING statType LINEEND              #Assign
    | ID ':' STRING statType '(' expr ')' LINEEND #ComputAssign
    | 'if' '(' expr ')' block                     #IfStat
    | 'if' '(' expr ')' block 'else' block        #IfElseStat
    ;

// The precedence is given by the order
expr: unaryOp expr                                #Unary
    | expr multiplicativeOp expr                  #Multiplicative
    | expr additiveOp expr                        #Additive
    | expr relationalOp expr                      #Relational
    | expr equalityOp expr                        #Equality
    | expr AND expr                               #LogicalAnd
    | expr OR expr                                #LogicalOr

    | boolLiteral                                 #Bool
    | ID                                          #Id
    | numLiteral                                  #Num
    | STRING                                      #String

    | '(' expr ')'                                #Parens
    ;

// Statement types
statType: BOOLEAN #BOOLEANType // becomes JCheckBox
        | MONEY   #MONEYType   // becomes JTextField
        | TEXT    #TEXTType    // becomes JTextField
        ;

// Unary Operators
unaryOp: ADD 
       | SUB 
       | NOT 
       ;

// Multiplicative Operators
multiplicativeOp: MUL 
                | DIV 
                | MOD 
                ;

// Additive Operators
additiveOp: ADD
          | SUB
          ;

// Relational Operators
relationalOp: LOWER_THAN
            | GRATER_THAN
            | LOWER_EQUAL_THAN
            | GRATER_EQUAL_THAN
            ;

// Equality Operators
equalityOp: EQUAL
          | NOT_EQUAL
          ;

// Boolean Values
boolLiteral: TRUE  
           | FALSE 
           ;

// Number Types
numLiteral: INTEGER
          | DOUBLE
          ;