module QL_Checker
#nowarn "40"

open System.Collections.Generic
open System
open QL_Grammar

let contains x = Seq.exists ((=) x)

type expressionType = TBool | TString | TInt | TDecimal | TError | TForm

let mapQLType qlType = match qlType with
                       | QLBool -> TBool
                       | QLString -> TString
                       | QLInt -> TInt
                       | QLDecimal -> TDecimal
// TODO: make parameter in type checker
let identifiers = new Dictionary<string, expressionType>()

let literalType exprType = 
    match exprType with
    | Bool(_)    -> TBool, exprType
    | String(_)  -> TString, exprType
    | Int(_)     -> TInt, exprType
    | Decimal(_) -> TDecimal, exprType

let rec checkExpression expression =
    match expression with
    | ID(name) when identifiers.ContainsKey(name)   -> identifiers.[name], expression
    | ID(name)                                      -> TError, TypeError(expression, "Unknown identifier: " + name)

    | Literal(expr) -> (fst <| literalType expr), expression

    | Neg(expr)  -> let type1,res1 = checkExpression expr
                    let res = Neg(res1)
                    if type1.Equals(TBool) || type1.Equals(TError) then
                        TBool, res
                    else
                        TError, TypeError(res, "Type error: expected boolean expression")

    | BooleanOp(expr1, (booleanOp.Eq as op), expr2)
    | BooleanOp(expr1, (booleanOp.Ne as op), expr2) ->  let type1,res1 = checkExpression expr1
                                                        let type2,res2 = checkExpression expr2
                                                        let res = BooleanOp(res1, op, res2)
                                                        if type1.Equals(type2) || type1.Equals(TError) || type2.Equals(TError) then
                                                           TBool, res
                                                        else
                                                           TError, TypeError(res, sprintf "Type error: cannot apply %+A on %+A and %+A" op type1 type2)
    | BooleanOp(expr1, (booleanOp.And as op), expr2)
    | BooleanOp(expr1, (booleanOp.Or as op), expr2) ->  let type1,res1 = checkExpression expr1
                                                        let type2,res2 = checkExpression expr2
                                                        let res = BooleanOp(res1, op, res2)
                                                        if (type1.Equals(type2) && type1.Equals(TBool)) || type1.Equals(TError) || type2.Equals(TError) then
                                                           TBool, res
                                                        else
                                                           TError, TypeError(res, sprintf "Type error: cannot apply %+A on %+A and %+A" op type1 type2)
    | BooleanOp(expr1, (booleanOp.Lt as op), expr2)
    | BooleanOp(expr1, (booleanOp.Le as op), expr2)
    | BooleanOp(expr1, (booleanOp.Gt as op), expr2)
    | BooleanOp(expr1, (booleanOp.Ge as op), expr2) ->  let type1,res1 = checkExpression expr1
                                                        let type2,res2 = checkExpression expr2
                                                        let res = BooleanOp(res1, op, res2)
                                                        let valid = seq [TInt ; TDecimal ]
                                                        match type1 with
                                                           | TInt | TDecimal when type1.Equals(type2) || type2.Equals(TError) -> TBool, res
                                                           | TError when contains type2 valid || type2.Equals(TError) -> TBool, res
                                                           | _ -> TError, TypeError(res, sprintf "Type error: cannot apply %+A on %+A and %+A" op type1 type2)

    | ArithmeticOp(a1, op, a2) ->   let type1,res1 = checkExpression a1
                                    let type2,res2 = checkExpression a2
                                    let res = ArithmeticOp(res1, op, res2)
                                    let accepted = seq [TInt ; TDecimal ; TError]
                                    if type1.Equals(type2) && contains type1 accepted then
                                      type1, res
                                    else if contains type1 accepted && contains type2 accepted then
                                      match type1 with
                                      | TError -> type2, res
                                      | _ -> type1, expression
                                    else TError, TypeError(res, sprintf "Type error: cannot apply %+A on %+A and %+A" op type1 type2)
    | _ -> failwith "Unhandled type case (should not occur)"

let rec checkStmts = 
    let checkStmt stmt = 
        match stmt with
        | Assignment(id, label, expression) ->  let exprType, expr = checkExpression expression
                                                identifiers.Add(id, exprType)
                                                Assignment(id, label, expr)
        | Question(id, label, qlType) ->        identifiers.Add(id, mapQLType qlType)
                                                stmt
        | Conditional(cond, stmts) ->           let exprType, expr = checkExpression cond
                                                if exprType.Equals(TBool) || exprType.Equals(TError) then
                                                    Conditional(expr, checkStmts stmts)
                                                else
                                                    Conditional(TypeError(expr, "Type error: expected boolean expression"), checkStmts stmts)
        
    List.map checkStmt

let typeCheck ast = identifiers.Clear()
                    identifiers.Add(ast.ID, TForm)
                    {   ID = ast.ID;
                        Statements = checkStmts ast.Statements 
                    }

