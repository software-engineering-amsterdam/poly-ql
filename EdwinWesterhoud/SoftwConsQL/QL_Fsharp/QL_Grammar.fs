module QL_Grammar
open System

// Question types
type qlType = QLBool | QLString | QLInt | QLDecimal

// Literals
type literal =
    | Bool      of bool
    | String    of string
    | Int       of int
    | Decimal   of float

// Expression
type booleanOp = And | Or | Lt | Gt | Le | Ge | Eq | Ne
type arithmeticOp = Plus | Minus | Mult | Div
type expression =
    | ID            of string
    | Literal       of literal
    | Neg           of expression
    | BooleanOp     of expression * booleanOp * expression
    | ArithmeticOp  of expression * arithmeticOp * expression
    | TypeError     of expression * string // TODO: make errors list parameter in type checker

type statement =
    | Assignment    of string * string * expression
    | Question      of string * string * qlType
    | Conditional   of expression * statement list

type questionaire = 
    {   ID          : string;
        Statements  : statement list }
    override m.ToString() = sprintf "%+A" m


type public Position(line, column) =
    member public x.Line = line
    member public x.Column = column

// Exception type for error reporting
type public ParseErrorExceptionMessage(message, lastToken, startPos, endPos) = 
    member public x.Message  = message
    member public x.LastToken  = lastToken
    member public x.StartPos = startPos
    member public x.EndPos   = endPos
exception ParseErrorException of ParseErrorExceptionMessage