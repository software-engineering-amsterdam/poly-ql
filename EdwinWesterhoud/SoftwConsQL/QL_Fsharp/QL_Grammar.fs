module QL_Grammar


// Question types
type qlType = QLBool | QLString | QLInt | QLDate | QLDecimal | QLMoney

// Expression types
// TODO OF TYPES! ~
type arithmeticType = 
    | Int       of int
    | Date      of float
    | Decimal   of float
    | Money     of float
type expType = 
    | Bool              of bool
    | String            of string
    | Arithmetic        of arithmeticType


// EXPRESSION
type booleanOp = And | Or | Lt | Gt | Le | Ge | Eq | Ne
type booleanExpr =
    | BoolVal of bool
    | Neg of booleanExpr
    | Cond of booleanExpr * booleanOp * booleanExpr

type arithmeticOp = Plus | Minus | Mult | Div
type arithmeticExpr =
    | ArithmeticType of arithmeticType
    | ArithmeticOp of arithmeticExpr * arithmeticOp * arithmeticExpr

type expression =
    | BooleanExpr       of booleanExpr
    | ArithmeticExpr    of arithmeticExpr
    

type assignment = 
    {   ID          : string;
        Label       : string;
        Type        : expType;
        Expressions : expression }

type question =
    {   ID      : string;
        Label   : string;
        Type    : qlType }

type statement =
    | Assignment    of assignment
    | Question      of question
    | Conditional   of booleanExpr * statement list

type questionaire = 
    {   ID          : string;
        Questions   : statement list }