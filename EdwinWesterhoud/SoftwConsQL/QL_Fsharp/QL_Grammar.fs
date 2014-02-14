module QL_Grammar


// Question types
type qlType = QLBool | QLString | QLInt | QLDate | QLDecimal | QLMoney

// Expression types
// TODO OF TYPES! ~

type exprType =
    | Bool      of bool
    | String    of string
    | Int       of int
    | Date      of float
    | Decimal   of float
    | Money     of float


// EXPRESSION
type booleanOp = And | Or | Lt | Gt | Le | Ge | Eq | Ne
type arithmeticOp = Plus | Minus | Mult | Div
type expression =
    | ID            of string
    | Expr          of exprType
    | Neg           of expression
    | BooleanOp     of expression * booleanOp * expression
    | ArithmeticOp  of expression * arithmeticOp * expression

type assignment = 
    {   ID          : string;
        Label       : string;
        Type        : exprType;
        Expressions : expression }

type question =
    {   ID      : string;
        Label   : string;
        Type    : qlType }

type statement =
    | Assignment    of assignment
    | Question      of question
    | Conditional   of expression * statement list

type questionaire = 
    {   ID          : string;
        Questions   : statement list } // Rename to statements