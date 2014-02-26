// Signature file for parser generated by fsyacc
module QL_Parser
type token = 
  | END
  | EQ
  | NE
  | LT
  | LE
  | GT
  | GE
  | AND
  | OR
  | PLUS
  | MINUS
  | MULT
  | DIV
  | NOT
  | QLBOOL
  | QLSTRING
  | QLINT
  | QLDECIMAL
  | DECIMAL of (float)
  | INT of (int)
  | STRING of (string)
  | BOOL of (bool)
  | LABEL of (string)
  | IDENTIFIER of (string)
  | ASSIGN
  | COLON
  | B_OPEN
  | B_CLOSE
  | CB_OPEN
  | CB_CLOSE
  | IF
  | FORM
type tokenId = 
    | TOKEN_END
    | TOKEN_EQ
    | TOKEN_NE
    | TOKEN_LT
    | TOKEN_LE
    | TOKEN_GT
    | TOKEN_GE
    | TOKEN_AND
    | TOKEN_OR
    | TOKEN_PLUS
    | TOKEN_MINUS
    | TOKEN_MULT
    | TOKEN_DIV
    | TOKEN_NOT
    | TOKEN_QLBOOL
    | TOKEN_QLSTRING
    | TOKEN_QLINT
    | TOKEN_QLDECIMAL
    | TOKEN_DECIMAL
    | TOKEN_INT
    | TOKEN_STRING
    | TOKEN_BOOL
    | TOKEN_LABEL
    | TOKEN_IDENTIFIER
    | TOKEN_ASSIGN
    | TOKEN_COLON
    | TOKEN_B_OPEN
    | TOKEN_B_CLOSE
    | TOKEN_CB_OPEN
    | TOKEN_CB_CLOSE
    | TOKEN_IF
    | TOKEN_FORM
    | TOKEN_end_of_input
    | TOKEN_error
type nonTerminalId = 
    | NONTERM__startstart
    | NONTERM_start
    | NONTERM_stmtList
    | NONTERM_stmt
    | NONTERM_assignment
    | NONTERM_question
    | NONTERM_conditional
    | NONTERM_qlType
    | NONTERM_literal
    | NONTERM_expression
/// This function maps integers indexes to symbolic token ids
val tagOfToken: token -> int

/// This function maps integers indexes to symbolic token ids
val tokenTagToTokenId: int -> tokenId

/// This function maps production indexes returned in syntax errors to strings representing the non terminal that would be produced by that production
val prodIdxToNonTerminal: int -> nonTerminalId

/// This function gets the name of a token as a string
val token_to_string: token -> string
val start : (Microsoft.FSharp.Text.Lexing.LexBuffer<'cty> -> token) -> Microsoft.FSharp.Text.Lexing.LexBuffer<'cty> -> (QL_Grammar.questionaire) 
