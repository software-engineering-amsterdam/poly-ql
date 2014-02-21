/**
 * Questionnaire Language (QL)
 * for describing questionnaires characterized by conditional entry fields
 *    and (spreadsheet-like) dependency-directed computation
 * boolean questions produce checkboxes,
 * numeric fields are rendered as text-boxes,
 * computed values are read-only
 */
grammar QL;
import CommonLexerRules;

// The start rule -> begin parsing here
init: (NEWLINE)*? form* (NEWLINE)*?;

form: 'form' ID block;

block: (NEWLINE)*? '{' NEWLINE stat* '}' (NEWLINE)*?;

stat: ID ':' STRING statType NEWLINE              #Assign
    | ID ':' STRING statType '(' expr ')' NEWLINE #ComputAssign
    | 'if' '(' expr ')' block                     #IfStat
    | 'if' '(' expr ')' block 'else' block        #IfElseStat
    ;

// The precedence is given by the order
expr: unaryOp expr                                #Unary
    | expr multiplicativeOp expr                  #Multiplicative
    | expr additiveOp expr                        #Additive
    | expr relationalOp expr                      #Relational
    | expr equalityOp expr                        #Equality
    | expr LA expr                                #LogicalAnd
    | expr LO expr                                #LogicalOr

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
unaryOp: ADD #UP
       | SUB #UM
       | NOT #NOT
       ;

// Multiplicative Operators
multiplicativeOp: MUL #MUL
                | DIV #DIV
                | REM #REM
                ;

// Additive Operators
additiveOp: ADD #ADD
          | SUB #SUB
          ;

// Relational Operators
relationalOp: LT  #LT
            | GT  #GT
            | LTQ #LTQ
            | GTQ #GTQ
            ;

// Equality Operators
equalityOp: EQ  #EQ
          | NEQ #NEQ
          ;

// Boolean Values
boolLiteral: TRUE  #TRUE
           | FALSE #FALSE
           ;

// Number Types
numLiteral: INT #Int
          | DEC #Dec
          ;
