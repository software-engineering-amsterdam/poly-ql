// (1) Define AST / syntax
module QL_AST

type Identifier = string
type Label = string

type qtype =
    | Boolean
    | String
    | Integer

type question =
    | Question of Identifier * Label * qtype