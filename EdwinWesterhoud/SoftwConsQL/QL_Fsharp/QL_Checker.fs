module QL_Checker
#nowarn "40"

open System.Collections.Generic
open System
open QL_Grammar
open TypeCheckInfo

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

let getExpressionPosition expression = match expression with
                                       | ID(_, pos)               -> pos
                                       | Literal(_, pos)          -> pos
                                       | Neg(_, pos)              -> pos
                                       | BooleanOp(_,_,_, pos)    -> pos
                                       | ArithmeticOp(_,_,_, pos) -> pos

let rec checkExpression expression (checkInfo : TypeCheckInfo) =
    let isNumeric exprType = exprType.Equals(TInt) || exprType.Equals(TDecimal)

    let checkBooleanOp left op right (pos:Position) cond =  let typeLeft = checkExpression left checkInfo
                                                            let typeRight = checkExpression right checkInfo
                                                            if cond typeLeft typeRight then 
                                                                TBool
                                                            else
                                                                checkInfo.RegisterError(sprintf "Type error on line %i: cannot apply %s on %s and %s" pos.StartLine (op.ToString()) (typeLeft.ToString()) (typeRight.ToString()), pos)
                                                                TError

    let checkArithmeticOp left op right (pos:Position) =    let typeLeft = checkExpression left checkInfo
                                                            let typeRight = checkExpression right checkInfo
                                                            if typeLeft.Equals(typeRight) && isNumeric typeLeft then
                                                                typeLeft
                                                            else if isNumeric typeLeft && typeRight.Equals(TError) then
                                                                typeLeft
                                                            else if typeLeft.Equals(TError) && isNumeric typeRight then
                                                                typeRight
                                                            else 
                                                                checkInfo.RegisterError(sprintf "Type error on line %i: cannot apply %s on %s and %s" pos.StartLine (op.ToString()) (typeLeft.ToString()) (typeRight.ToString()), pos)
                                                                TError

    match expression with
    | ID(name, pos)      -> let exprType = checkInfo.GetIdentifierType(name)
                            if (exprType.Equals(TError)) then
                                checkInfo.RegisterError(sprintf "Unknown identifier on line %i (%s)" pos.StartLine name, pos)
                            exprType

    | Literal(expr, pos) -> (fst <| literalType expr)

    | Neg(expr, pos)     -> let exprType = checkExpression expr checkInfo
                            if (not <| exprType.Equals(TBool) && not <| exprType.Equals(TError)) then
                                checkInfo.RegisterError(sprintf "Type error on line %i: expected Boolean expression" pos.StartLine, pos)
                            exprType

    | BooleanOp(left, (booleanOp.Eq as op), right, pos)
    | BooleanOp(left, (booleanOp.Ne as op), right, pos) -> checkBooleanOp left op right pos 
                                                            (fun typeLeft typeRight -> typeLeft.Equals(typeRight)  || 
                                                                                       typeLeft.Equals(TError) || 
                                                                                       typeRight.Equals(TError))
    | BooleanOp(left, (booleanOp.And as op), right, pos)
    | BooleanOp(left, (booleanOp.Or as op), right, pos) -> checkBooleanOp left op right pos 
                                                            (fun typeLeft typeRight -> (typeLeft.Equals(typeRight) && typeLeft.Equals(TBool)) || 
                                                                                        typeLeft.Equals(TError) || 
                                                                                        typeRight.Equals(TError))
    | BooleanOp(left, (booleanOp.Lt as op), right, pos)
    | BooleanOp(left, (booleanOp.Le as op), right, pos)
    | BooleanOp(left, (booleanOp.Gt as op), right, pos)
    | BooleanOp(left, (booleanOp.Ge as op), right, pos) -> checkBooleanOp left op right pos 
                                                            (fun typeLeft typeRight -> (typeLeft.Equals(typeRight) && isNumeric typeRight)  ||
                                                                                       (typeLeft.Equals(TError) && isNumeric typeRight) ||
                                                                                       (isNumeric typeLeft && typeRight.Equals(TError)) ||
                                                                                       (typeLeft.Equals(TError) && typeRight.Equals(TError)))
    | ArithmeticOp(left, op, right, pos) -> checkArithmeticOp left op right pos

let rec checkStmts stmts (checkInfo : TypeCheckInfo) = 
    let checkStmt stmt = 
        match stmt with
        | Assignment(id, label, expression, pos) -> let exprType = checkExpression expression checkInfo
                                                    checkInfo.RegisterIdentifier(id, exprType, pos)
                                                    checkInfo.RegisterLabel(label, pos)
        | Question(id, label, qlType, pos)       -> checkInfo.RegisterIdentifier(id, mapQLType qlType, pos)
                                                    checkInfo.RegisterLabel(label, pos)
        | IfElseConditional(cond, ifStmts, elseStmts, pos) ->   let exprType = checkExpression cond checkInfo
                                                                if not <| exprType.Equals(TBool) && not <| exprType.Equals(TError) then
                                                                    checkInfo.RegisterError(sprintf "Type error on line %i: expected Boolean expression" pos.StartLine, getExpressionPosition cond)
                                                                checkStmts ifStmts checkInfo
                                                                checkStmts elseStmts checkInfo
        | IfConditional(cond, stmts, pos) ->    let exprType = checkExpression cond checkInfo
                                                if not <| exprType.Equals(TBool) && not <| exprType.Equals(TError) then
                                                    checkInfo.RegisterError(sprintf "Type error on line %i: expected Boolean expression" pos.StartLine, getExpressionPosition cond)
                                                checkStmts stmts checkInfo
        
    List.iter checkStmt stmts

let typeCheck ast = let checkInfo = new TypeCheckInfo(ast.ID)
                    checkStmts ast.Statements checkInfo
                    checkInfo
