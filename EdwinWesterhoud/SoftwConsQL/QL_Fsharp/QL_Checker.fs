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

    member this.ErrorList = errors.ToArray()

////

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
    let isNumeric exprType = exprType.Equals(TInt) || exprType.Equals(TDecimal)

    let checkBooleanOp left op right cond = let typeLeft = checkExpression left checkInfo
                                            let typeRight = checkExpression right checkInfo
                                            if cond typeLeft typeRight then 
                                                TBool
                                            else
                                                checkInfo.RegisterError(sprintf "Type error: cannot apply %+A on %+A and %+A" op typeLeft typeRight)
                                                TError

    let checkArithmeticOp left op right =   let typeLeft = checkExpression left checkInfo
                                            let typeRight = checkExpression right checkInfo
                                            if typeLeft.Equals(typeRight) && isNumeric typeLeft then
                                                typeLeft
                                            else if isNumeric typeLeft && typeRight.Equals(TError) then
                                                typeLeft
                                            else if typeLeft.Equals(TError) && isNumeric typeRight then
                                                typeRight
                                            else 
                                                checkInfo.RegisterError(sprintf "Type error: cannot apply %+A on %+A and %+A" op typeLeft typeRight)
                                                TError

    match expression with
    | ID(name, _)      ->  let exprType = checkInfo.GetIdentifierType(name)
                           if (exprType.Equals(TError)) then
                            checkInfo.RegisterError("Unknown identifier: " + name)
                           exprType

    | Literal(expr,_) -> (fst <| literalType expr)

    | Neg(expr,_)     ->  let exprType = checkExpression expr checkInfo
                          if (not <| exprType.Equals(TBool) && not <| exprType.Equals(TError)) then
                              checkInfo.RegisterError("Type error: expected boolean expression")
                          exprType

    | BooleanOp(left, (booleanOp.Eq as op), right,_)
    | BooleanOp(left, (booleanOp.Ne as op), right,_) -> checkBooleanOp left op right (fun typeLeft typeRight -> typeLeft.Equals(typeRight)  || 
                                                                                                                typeLeft.Equals(TError) || 
                                                                                                                typeRight.Equals(TError))
    | BooleanOp(left, (booleanOp.And as op), right,_)
    | BooleanOp(left, (booleanOp.Or as op), right,_) -> checkBooleanOp left op right (fun typeLeft typeRight -> (typeLeft.Equals(typeRight) && typeLeft.Equals(TBool)) || 
                                                                                                                 typeLeft.Equals(TError) || typeRight.Equals(TError))
    | BooleanOp(left, (booleanOp.Lt as op), right,_)
    | BooleanOp(left, (booleanOp.Le as op), right,_)
    | BooleanOp(left, (booleanOp.Gt as op), right,_)
    | BooleanOp(left, (booleanOp.Ge as op), right,_) -> checkBooleanOp left op right (fun typeLeft typeRight -> (typeLeft.Equals(typeRight) && isNumeric typeRight)  ||
                                                                                                                (typeLeft.Equals(TError) && isNumeric typeRight) ||
                                                                                                                (isNumeric typeLeft && typeRight.Equals(TError)) ||
                                                                                                                (typeLeft.Equals(TError) && typeRight.Equals(TError)))
    | ArithmeticOp(left, op, right,_) -> checkArithmeticOp left op right

let rec checkStmts stmts (checkInfo : TypeCheckInfo) = 
    let checkStmt stmt = 
        match stmt with
        | Assignment(id, label, expression) ->  let exprType = checkExpression expression checkInfo
                                                checkInfo.RegisterIdentifier(id, exprType) |> ignore // todo: duplicate id check
        | Question(id, label, qlType) ->        checkInfo.RegisterIdentifier(id, mapQLType qlType) |> ignore // todo duplicate id check
        | IfElseConditional(cond, ifStmts, elseStmts) ->    let exprType = checkExpression cond checkInfo
                                                            if not <| exprType.Equals(TBool) && not <| exprType.Equals(TError) then
                                                                checkInfo.RegisterError("Type error: expected boolean expression")
                                                            checkStmts ifStmts checkInfo
                                                            checkStmts elseStmts checkInfo
        | IfConditional(cond, stmts) ->         let exprType = checkExpression cond checkInfo
                                                if not <| exprType.Equals(TBool) && not <| exprType.Equals(TError) then
                                                    checkInfo.RegisterError("Type error: expected boolean expression")
                                                checkStmts stmts checkInfo
        
    List.iter checkStmt stmts

let typeCheck ast = let checkInfo = new TypeCheckInfo(ast.ID)
                    checkStmts ast.Statements checkInfo
                    checkInfo

