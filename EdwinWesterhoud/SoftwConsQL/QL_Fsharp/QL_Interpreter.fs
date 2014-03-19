module QL_Interpreter

open System
open System.Collections.Generic
open System.Windows.Forms
open QL_Grammar
open QL_Checker
open ControlInfo
open QL_Csharp
open QL_Csharp.PrimitiveControls

let getControlValue (control : StatementControl) =
    match control with
    | :? BooleanControl  -> let bcontrol = control :?> BooleanControl
                            Bool(bcontrol.GetValue())
    | :? StringControl   -> let scontrol = control :?> StringControl
                            String(scontrol.GetValue())
    | :? IntegerControl  -> let icontrol = control :?> IntegerControl
                            Int(icontrol.GetValue())
    | :? DecimalControl  -> let dcontrol = control :?> DecimalControl
                            Decimal(dcontrol.GetValue())
    | _                  -> failwith "Unknown control type (did you add a new control?)"

let setControlValue (control : StatementControl) newValue =
    match newValue with
    | Bool(value) ->    let bcontrol = control :?> BooleanControl
                        bcontrol.SetValue(value)
    | String(value) ->  let scontrol = control :?> StringControl
                        scontrol.SetValue(value)
    | Int(value) ->     let icontrol = control :?> IntegerControl
                        icontrol.SetValue(value)
    | Decimal(value) -> let dcontrol = control :?> DecimalControl
                        dcontrol.SetValue(value)

let evalBooleanOp (left, op, right) =   
    match (left, op, right) with
    | (Bool(left),    booleanOp.And, Bool(right))   -> Bool(left && right)
    | (Bool(left),    booleanOp.Or,  Bool(right))   -> Bool(left || right)
    | (Bool(left),    booleanOp.Eq,  Bool(right))   -> Bool(left = right)
    | (Bool(left),    booleanOp.Ne,  Bool(right))   -> Bool(not (left = right))

    | (String(left),  booleanOp.Eq, String(right))  -> Bool(left = right)
    | (String(left),  booleanOp.Ne, String(right))  -> Bool(not (left = right))
                                        
    | (Int(left),     booleanOp.Eq, Int(right))     -> Bool(left = right)
    | (Int(left),     booleanOp.Ne, Int(right))     -> Bool(not (left = right))
    | (Int(left),     booleanOp.Gt, Int(right))     -> Bool(left > right)
    | (Int(left),     booleanOp.Ge, Int(right))     -> Bool(left >= right)
    | (Int(left),     booleanOp.Lt, Int(right))     -> Bool(left < right)
    | (Int(left),     booleanOp.Le, Int(right))     -> Bool(left <= right)
                                        
    | (Decimal(left), booleanOp.Eq, Decimal(right)) -> Bool(left = right)
    | (Decimal(left), booleanOp.Ne, Decimal(right)) -> Bool(not (left = right))
    | (Decimal(left), booleanOp.Gt, Decimal(right)) -> Bool(left > right)
    | (Decimal(left), booleanOp.Ge, Decimal(right)) -> Bool(left >= right)
    | (Decimal(left), booleanOp.Lt, Decimal(right)) -> Bool(left < right)
    | (Decimal(left), booleanOp.Le, Decimal(right)) -> Bool(left <= right)

    | (_, _, _) -> failwith "Unexpected application of a boolean operation (may indicate problem in typechecker)"

let evalArithmeticOp (left, op, right) = 
    match (left, op, right) with
    | (Int(left),     arithmeticOp.Plus,  Int(right))     -> Int(left + right)
    | (Int(left),     arithmeticOp.Minus, Int(right))     -> Int(left - right)
    | (Int(left),     arithmeticOp.Mult,  Int(right))     -> Int(left * right)
    | (Int(left),     arithmeticOp.Div,   Int(right))     -> if right = 0 then Int(0) else Int(left / right)

    | (Decimal(left), arithmeticOp.Plus,  Decimal(right)) -> Decimal(left + right)
    | (Decimal(left), arithmeticOp.Minus, Decimal(right)) -> Decimal(left - right)
    | (Decimal(left), arithmeticOp.Mult,  Decimal(right)) -> Decimal(left * right)
    | (Decimal(left), arithmeticOp.Div,   Decimal(right)) -> if right = 0.0 then Decimal(0.0) else Decimal(left / right)

    | (_, _, _) -> failwith "Unexpected application of a boolean operation (may indicate problem in typechecker)"


let rec evalExpression expression (controlInfo : ControlInfo) =
    match expression with
    | ID(name, _)     -> getControlValue <| controlInfo.GetControl(name)
    | Literal(lit, _) -> lit
    | Neg(expr, _)    -> let evalInner = evalExpression expr controlInfo
                         match evalInner with
                         | Bool(value) -> Bool(not value)
                         | _           -> failwith "Unexpected result (may indicate problem in typechecker)"
    | BooleanOp(left, op, right, _)    -> let evalLeft = evalExpression left controlInfo
                                          let evalRight = evalExpression right controlInfo
                                          evalBooleanOp (evalLeft, op, evalRight)
    | ArithmeticOp(left, op, right, _) -> let evalLeft = evalExpression left controlInfo
                                          let evalRight = evalExpression right controlInfo
                                          evalArithmeticOp (evalLeft, op, evalRight)

let evalCondition condition (controlInfo : ControlInfo) =
    let evaluated = evalExpression condition controlInfo
    match evaluated with
    | Bool(value) -> value
    | _           -> failwith "Unexpected result (may indicate problem in typechecker)"
