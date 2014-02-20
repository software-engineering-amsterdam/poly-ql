module QL_Checker

open System
open QL_Grammar

///// TYPE
type expressionType = TBool | TString | TInt | TDate | TDecimal | TMoney | TIdentifier

let getTypeExprType expressionType = 
    match expressionType with
    | Bool(_) -> TBool
    | String(_) -> TString
    | Int(_) -> TInt
    | Date(_) -> TDate
    | Decimal(_) -> TDecimal
    | Money(_) -> TMoney

let rec getTypeExpr expression =
    match expression with
    | ID(name) -> TIdentifier
    | Expr(exprType) -> getTypeExprType exprType
    | Neg(expr) -> getTypeExpr expr //error detection is expr is not bool
    | BooleanOp(expr1, op, expr2) -> TBool // error detection if expr1 and expr2 is not bool
    //| ArithmeticOp(expr1, op, expr2) -> 
/////

let checkExpr expression =
    match expression with
    | BooleanOp(Expr(Bool(_)), _, Expr(Bool(_))) as orig -> orig
    | BooleanOp(ID(name), _, Expr(Bool(_))) as orig -> orig //check id
    | BooleanOp(Expr(Bool(_)), _, ID(name)) as orig -> orig //check id

    | _ -> failwithf "test"


let checkAssignment ass = Assignment(ass)
let checkQuestion ques = Question(ques)
let checkConditional cond stmts = Conditional(cond, stmts)

let checkStmt stmt = 
    match stmt with
    | Assignment(ass) -> checkAssignment ass
    | Question(ques) -> checkQuestion ques
    | Conditional(cond, stmts) -> checkConditional cond stmts

let checkStmts = List.map checkStmt


let typeCheck ast = checkStmts ast.Statements

// TEST
let checkExpr1 expr =
    match expr with
    | Expr(Int(i)) -> printf "int"
    | Expr(ee) -> printf "e"
    | _ -> printf "otherwise"
