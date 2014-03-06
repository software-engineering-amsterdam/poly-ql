module QL_Checker
#nowarn "40"

open System.Collections.Generic
open System
open QL_Grammar

//// Type check info
type expressionType = TBool | TString | TInt | TDecimal | TError | TForm
type TypeCheckInfo(formName) = 
    let errors = new List<string>()
    let identifiers = new Dictionary<string, expressionType>()
    do identifiers.Add(formName, TForm)

    member this.RegisterIdentifier(id, exprType) =
        if identifiers.ContainsKey(id) 
        then false
        else identifiers.Add(id, exprType)
             true
    
    member this.GetIdentifierType(id) = 
        if identifiers.ContainsKey(id)
        then identifiers.[id]
        else TError

    member this.RegisterError(message) = errors.Add(message)

    member this.HasErrors = errors.Count > 0

    member this.ErrorList = errors 

////

let contains x = Seq.exists ((=) x)

let mapQLType qlType = match qlType with
                       | QLBool -> TBool
                       | QLString -> TString
                       | QLInt -> TInt
                       | QLDecimal -> TDecimal

let literalType exprType = 
    match exprType with
    | Bool(_)    -> TBool, exprType
    | String(_)  -> TString, exprType
    | Int(_)     -> TInt, exprType
    | Decimal(_) -> TDecimal, exprType

let rec checkExpression expression (checkInfo : TypeCheckInfo) =
    match expression with
    | ID(name)      ->  let exprType = checkInfo.GetIdentifierType(name)
                        if (exprType.Equals(TError)) then
                            checkInfo.RegisterError("Unknown identifier: " + name)
                        exprType

    | Literal(expr) -> (fst <| literalType expr)

    | Neg(expr)     ->  let exprType = checkExpression expr checkInfo
                        if (not <| exprType.Equals(TBool) && not <| exprType.Equals(TError)) then
                            checkInfo.RegisterError("Type error: expected boolean expression")
                        exprType

    | BooleanOp(expr1, (booleanOp.Eq as op), expr2)
    | BooleanOp(expr1, (booleanOp.Ne as op), expr2) ->  let type1 = checkExpression expr1 checkInfo
                                                        let type2 = checkExpression expr2 checkInfo
                                                        if type1.Equals(type2) || type1.Equals(TError) || type2.Equals(TError) then
                                                            TBool
                                                        else
                                                            checkInfo.RegisterError(sprintf "Type error: cannot apply %+A on %+A and %+A" op type1 type2)
                                                            TError
    | BooleanOp(expr1, (booleanOp.And as op), expr2)
    | BooleanOp(expr1, (booleanOp.Or as op), expr2) ->  let type1 = checkExpression expr1 checkInfo
                                                        let type2 = checkExpression expr2 checkInfo
                                                        if (type1.Equals(type2) && type1.Equals(TBool)) || type1.Equals(TError) || type2.Equals(TError) then
                                                            TBool
                                                        else
                                                            checkInfo.RegisterError(sprintf "Type error: cannot apply %+A on %+A and %+A" op type1 type2)
                                                            TError
    | BooleanOp(expr1, (booleanOp.Lt as op), expr2)
    | BooleanOp(expr1, (booleanOp.Le as op), expr2)
    | BooleanOp(expr1, (booleanOp.Gt as op), expr2)
    | BooleanOp(expr1, (booleanOp.Ge as op), expr2) ->  let type1 = checkExpression expr1 checkInfo
                                                        let type2 = checkExpression expr2 checkInfo
                                                        let valid = seq [TInt ; TDecimal ]
                                                        match type1 with
                                                           | TInt | TDecimal when type1.Equals(type2) || type2.Equals(TError) -> TBool
                                                           | TError when contains type2 valid || type2.Equals(TError) -> TBool
                                                           | _ -> checkInfo.RegisterError(sprintf "Type error: cannot apply %+A on %+A and %+A" op type1 type2)
                                                                  TError

    | ArithmeticOp(a1, op, a2) ->   let type1 = checkExpression a1 checkInfo
                                    let type2 = checkExpression a2 checkInfo
                                    let accepted = seq [TInt ; TDecimal ; TError]
                                    if type1.Equals(type2) && contains type1 accepted then
                                        type1
                                    else if contains type1 accepted && contains type2 accepted then
                                        match type1 with
                                        | TError -> type2
                                        | _ -> type1
                                    else checkInfo.RegisterError(sprintf "Type error: cannot apply %+A on %+A and %+A" op type1 type2)
                                         TError
    | _ -> failwith "Unhandled type case (should not occur)"

let rec checkStmts stmts (checkInfo : TypeCheckInfo) = 
    let checkStmt stmt = 
        match stmt with
        | Assignment(id, label, expression) ->  let exprType = checkExpression expression checkInfo
                                                checkInfo.RegisterIdentifier(id, exprType) |> ignore // todo: duplicate id check
        | Question(id, label, qlType) ->        checkInfo.RegisterIdentifier(id, mapQLType qlType) |> ignore // todo duplicate id check
        | Conditional(cond, stmts) ->           let exprType = checkExpression cond checkInfo
                                                if not <| exprType.Equals(TBool) && not <| exprType.Equals(TError) then
                                                    checkInfo.RegisterError("Type error: expected boolean expression")
                                                checkStmts stmts checkInfo
        
    List.iter checkStmt stmts

let typeCheck ast = let checkInfo = new TypeCheckInfo(ast.ID)
                    checkStmts ast.Statements checkInfo
                    ast, checkInfo

