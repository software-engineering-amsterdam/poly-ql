module QL_Grammar
open System

type public Position(state : Parsing.IParseState) =
    let startPos, endPos = state.ResultRange
    member public this.StartLine      : int = startPos.Line+1
    member public this.StartColumn    : int = startPos.Column
    member public this.StartCharacter : int = startPos.AbsoluteOffset
    member public this.EndLine        : int = endPos.Line+1
    member public this.EndColumn      : int = endPos.Column
    member public this.EndCharacter   : int = endPos.AbsoluteOffset
    override this.ToString() = "Position"

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
    | ID            of string * Position
    | Literal       of literal * Position
    | Neg           of expression * Position
    | BooleanOp     of expression * booleanOp * expression * Position
    | ArithmeticOp  of expression * arithmeticOp * expression * Position

type statement =
    | Assignment        of string * string * expression
    | Question          of string * string * qlType
    | IfElseConditional of expression * statement list * statement list
    | IfConditional     of expression * statement list

type questionaire = 
    {   ID          : string;
        Statements  : statement list }
    override this.ToString() = sprintf "%+A" this