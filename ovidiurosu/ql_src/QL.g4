/**
 * Grammar of Questionnaire Language (QL)
 * for describing questionnaires characterized by conditional entry fields
 *    and (spreadsheet-like) dependency-directed computation
 * boolean questions produce check-boxes,
 * numeric fields are rendered as text-boxes,
 * computed values are read-only
 */
grammar QL;
import CommonLexerRules;

// The start rule -> begin parsing here
forms: form* ;

form: 'form' ID block;

block: '{' statement* '}';

statement
    : ID ':' STRING type                         #Assignment
    | ID ':' STRING type '(' expression ')'      #ComputedAssignment
    | 'if' '(' expression ')' block              #IfStatement
    | 'if' '(' expression ')' block 'else' block #IfElseStatement
    ;

// Rule for testing -> to be able to call expression from outside
expression_test: expression;

// The precedence is given by the order
expression
    // Unary
    : ADD expression            #UnaryPlus
    | SUB expression            #UnaryMinus
    | NOT expression            #Not

    // Multiplicative
    | expression MUL expression #Multiply
    | expression DIV expression #Divide
    | expression REM expression #Remainder

    // Additive
    | expression ADD expression #Add
    | expression SUB expression #Subtract

    // Relational
    | expression LT  expression #LessThan
    | expression GT  expression #GreaterThan
    | expression LTE expression #LessThanEqual
    | expression GTE expression #GreaterThanEqual

    // Equality
    | expression EQ  expression #Equal
    | expression NEQ expression #NotEqual

    // Logical
    | expression LA expression  #LogicalAnd
    | expression LO expression  #LogicalOr

    | booleanLiteralP           #BooleanLiteral
    | ID                        #Id
    | numberLiteralP            #NumberLiteral
    | STRING                    #String

    | '(' expression ')'        #Parentheses
    ;

// Statement types
type: BOOLEAN #BooleanType // becomes JCheckBox
    | INTEGER #IntegerType // becomes JTextField
    | DECIMAL #DecimalType // becomes JTextField
    | MONEY   #MoneyType   // becomes JTextField
    | DATE    #DateType    // becomes JCalendar
    | STRINGT #StringType  // becomes JTextField

    // Optional: Computed
    | '(' enumTypeP ')' #EnumType         // becomes JList
    | INT '..' INT      #IntegerRangeType // becomes JList
    ;

// Boolean Values
booleanLiteralP
    : TRUE  #True
    | FALSE #False
    ;

// Number Types
numberLiteralP
    : INT #Integer
    | DEC #Decimal
    ;

// Enum Type
enumTypeP
    : STRING (',' enumTypeP)?         #StringEnum
    | numberLiteralP (',' enumTypeP)? #NumberEnum
    ;
