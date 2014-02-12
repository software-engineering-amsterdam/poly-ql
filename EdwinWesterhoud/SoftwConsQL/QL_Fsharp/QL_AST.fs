// (1) Define AST / syntax
module QL_AST


// QL TYPES
// TODO OF TYPES!
type arithmeticType = 
    | Int       of int
    | Date      of int
    | Decimal   of float
    | Money     of float
type qlType = 
    | Bool              of bool
    | String            of string
    | ArithmeticType    of arithmeticType


// EXPRESSION
type booleanOp = And | Or | Lt | Gt | Le | Ge | Eq | Ne
type booleanExpr =
    | Bool of bool
    | Cond of booleanExpr * booleanOp * booleanExpr

type arithmeticOp = Plus | Minus | Mult | Div
type arithmeticExpr =
    | ArithmeticType of arithmeticType
    | ArithmeticExpr of arithmeticExpr * arithmeticOp * arithmeticExpr

type expression =
    | BooleanExpr       of booleanExpr
    | ArithmeticExpr    of arithmeticExpr
    

type assignment = 
    {   ID          : string;
        Label       : string;
        Type        : qlType;
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