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

type statement =
    | Assignment        of string * string * expression
    | Question          of string * string * qlType
    | IfElseConditional of expression * statement list * statement list
    | IfConditional     of expression * statement list

type questionaire = 
    {   ID          : string;
        Statements  : statement list }
    override this.ToString() = sprintf "%+A" this


type public Position(line, column, character) =
    member public this.Line      : int = line
    member public this.Column    : int = column
    member public this.Character : int = character
    override this.ToString() = ""