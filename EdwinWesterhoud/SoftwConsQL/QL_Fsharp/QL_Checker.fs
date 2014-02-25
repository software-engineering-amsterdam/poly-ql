module QL_Checker
#nowarn "40"

open System.Collections.Generic
open System
open QL_Grammar

let contains x = Seq.exists ((=) x)

type expressionType = TBool | TString | TInt | TDate | TDecimal | TMoney | TError | TForm

let mapQLType qlType = match qlType with
                       | QLBool -> TBool
                       | QLString -> TString
                       | QLInt -> TInt
                       | QLDate -> TDate
                       | QLDecimal -> TDecimal
                       | QLMoney -> TMoney

let identifiers = new Dictionary<string, expressionType>()

let getPrimitiveType exprType = 
    match exprType with
    | Bool(_) -> TBool, exprType
    | String(_) -> TString, exprType
    | Int(_) -> TInt, exprType
    | Date(_) -> TDate, exprType
    | Decimal(_) -> TDecimal, exprType
    | Money(_) -> TMoney, exprType

let rec checkExpression expression =
    match expression with
    | ID(name) when identifiers.ContainsKey(name)   -> identifiers.[name], expression
    | ID(name)                                      -> TError, TypeError(expression, "Unknown identifier: " + name)

    | Expr(expr) -> (fst <| getPrimitiveType expr), expression

    | Neg(expr)  -> let type1,res1 = checkExpression expr
                    if type1.Equals(TBool) || type1.Equals(TError) then
                        TBool, res1
                    else
                        TError, TypeError(res1, "Type error: expected boolean expression")

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
                                                        let valid = seq [TInt ; TDate ; TDecimal ; TMoney ]
                                                        match type1 with
                                                           | TInt | TDate | TDecimal | TMoney when type1.Equals(type2) || type2.Equals(TError) -> TBool, res
                                                           | TError when contains type2 valid || type2.Equals(TError) -> TBool, res
                                                           | _ -> TError, TypeError(res, sprintf "Type error: cannot apply %+A on %+A and %+A" op type1 type2)

    | ArithmeticOp(a1, op, a2) ->   let type1,res1 = checkExpression a1
                                    let type2,res2 = checkExpression a2
                                    let res = ArithmeticOp(res1, op, res2)
                                    let accepted = seq [TInt ; TDate ; TDecimal ; TMoney ; TError]
                                    if type1.Equals(type2) && contains type1 accepted then
                                      type1, res
                                    else if contains type1 accepted && contains type2 accepted then
                                      match type1 with
                                      | TError -> type2, res
                                      | _ -> type1, expression
                                    else TError, TypeError(res, sprintf "Type error: cannot apply %+A on %+A and %+A" op type1 type2)
    | _ -> failwith "Unhandled type case (should not occur)"

let rec checkStmts = 
    let checkAssignment ass = let exprType, expr = checkExpression ass.Expression
                              identifiers.Add(ass.ID, exprType)
                              Assignment({ID = ass.ID; Label = ass.Label; Expression = expr})

    let checkQuestion (ques:question) = identifiers.Add(ques.ID, mapQLType ques.Type)
                                        Question(ques)

    let checkConditional cond stmts = let exprType, expr = checkExpression cond
                                      if exprType.Equals(TBool) || exprType.Equals(TError) then
                                        Conditional(expr, checkStmts stmts)
                                      else
                                        Conditional(TypeError(expr, "Type error: expected boolean expression"), checkStmts stmts)

    let checkStmt stmt = 
        match stmt with
        | Assignment(ass) -> checkAssignment ass
        | Question(ques) -> checkQuestion ques
        | Conditional(cond, stmts) -> checkConditional cond stmts
        
    List.map checkStmt

let typeCheck ast = identifiers.Clear()
                    identifiers.Add(ast.ID, TForm)
                    {   ID = ast.ID;
                        Statements = checkStmts ast.Statements 
                    }

