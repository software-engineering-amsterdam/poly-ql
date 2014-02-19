module QL_Grammar
open System

// Exception type for error reporting
type public ParseErrorExceptionMessage(message : string, line : int, column : int) = 
    member public x.Message = message
    member public x.Line    = line
    member public x.Column  = column
exception ParseErrorException of ParseErrorExceptionMessage

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
        Expression  : expression }

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
        Statements  : statement list }
    override m.ToString() = sprintf "%+A" m