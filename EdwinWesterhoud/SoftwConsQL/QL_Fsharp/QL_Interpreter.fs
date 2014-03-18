module QL_Interpreter

open System.Collections.Generic
open System
open System.Windows.Forms;
open QL_Grammar
open QL_Checker
open QL_Csharp
open QL_Csharp.PrimitiveControls

//// GUI HELPERS
let indentBlock (stmtListControl : StatementList) = let mutable margin = stmtListControl.Margin
                                                    margin.Left <- 25
                                                    stmtListControl.Margin <- margin

let setBlockVisibility (block : StatementList) newVisibility = block.Visible <- newVisibility
/// END

//// EVAL
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
    | (Int(left),     arithmeticOp.Div,   Int(right))     -> Int(left / right)

    | (Decimal(left), arithmeticOp.Plus,  Decimal(right)) -> Decimal(left + right)
    | (Decimal(left), arithmeticOp.Minus, Decimal(right)) -> Decimal(left - right)
    | (Decimal(left), arithmeticOp.Mult,  Decimal(right)) -> Decimal(left * right)
    | (Decimal(left), arithmeticOp.Div,   Decimal(right)) -> Decimal(left / right)

    | (_, _, _) -> failwith "Unexpected application of a boolean operation (may indicate problem in typechecker)"


let rec evalExpression expression (controlMap : Dictionary<string, StatementControl>) =
    match expression with
    | ID(name, _)     -> getControlValue controlMap.[name]
    | Literal(lit, _) -> lit
    | Neg(expr, _)    -> let evalInner = evalExpression expr controlMap
                         match evalInner with
                         | Bool(value) -> Bool(not value)
                         | _           -> failwith "Unexpected result (may indicate problem in typechecker)"
    | BooleanOp(left, op, right, _)    -> let evalLeft = evalExpression left controlMap
                                          let evalRight = evalExpression right controlMap
                                          evalBooleanOp (evalLeft, op, evalRight)
    | ArithmeticOp(left, op, right, _) -> let evalLeft = evalExpression left controlMap
                                          let evalRight = evalExpression right controlMap
                                          evalArithmeticOp (evalLeft, op, evalRight)

let evalCondition condition (controlMap : Dictionary<string, StatementControl>) =
    let evaluated = evalExpression condition controlMap
    match evaluated with
    | Bool(value) -> value
    | _           -> failwith "Unexpected result (may indicate problem in typechecker)"

//// END


let rec checkStmts stmts (controlMap : Dictionary<string, StatementControl>) : Control list =
    let assignmentGUI label expression : StatementControl = let expressionEval = evalExpression expression controlMap
                                                            match expressionEval with
                                                            | Bool(value)    -> let control = new BooleanControl(label)
                                                                                control.SetValue(value)
                                                                                control.SetReadOnly(true)
                                                                                upcast control
                                                            | String(value)  -> let control = new StringControl(label)
                                                                                control.SetValue(value)
                                                                                control.SetReadOnly(true)
                                                                                upcast control
                                                            | Int(value)     -> let control = new IntegerControl(label)
                                                                                control.SetValue(value)
                                                                                control.SetReadOnly(true)
                                                                                upcast control
                                                            | Decimal(value) -> let control = new DecimalControl(label)
                                                                                control.SetValue(value)
                                                                                control.SetReadOnly(true)
                                                                                upcast control

    let questionGUI label qlType : StatementControl =   match qlType with
                                                        | QLBool    -> upcast new BooleanControl(label)
                                                        | QLString  -> upcast new StringControl(label)
                                                        | QLInt     -> upcast new IntegerControl(label)
                                                        | QLDecimal -> upcast new DecimalControl(label)

    let rec getIdentifierControls expression =  match expression with
                                                | ID(name, _)   -> [controlMap.[name]]
                                                | Literal(_, _) -> []
                                                | Neg(expr, _)  -> getIdentifierControls expr
                                                | BooleanOp(left, _, right, _)
                                                | ArithmeticOp(left, _, right, _) -> getIdentifierControls left @ getIdentifierControls right

    let addConditionalEvents condition (statementList : StatementList) =
        let identifierControls = getIdentifierControls condition
        List.iter
            (
                fun (identifier : StatementControl) ->
                    identifier.AddValueChangedEventHandler(
                        fun _ _ -> setBlockVisibility statementList <| evalCondition condition controlMap
                    )
            )
            identifierControls

    let addAssigmentEvents expression (control : StatementControl) =
        let identifierControls = getIdentifierControls expression
        List.iter
            (
                fun (identifier : StatementControl) ->
                    identifier.AddValueChangedEventHandler(
                        fun _ _ -> setControlValue control <| evalExpression expression controlMap
                    )
            )
            identifierControls

    let checkStmt stmt : Control list =
        match stmt with
        | Assignment(id, label, expression, pos)             -> let control = assignmentGUI label expression
                                                                controlMap.Add(id, control)
                                                                addAssigmentEvents expression control
                                                                [control]
        | Question(id, label, qlType, pos)                   -> let control = questionGUI label qlType
                                                                controlMap.Add(id, control)
                                                                [control]
        | IfElseConditional(cond, ifStmts, elseStmts, pos)   -> let statementListIf = new StatementList() // REFACTOR 1 extract method
                                                                let statementListElse = new StatementList()
                                                                statementListIf.AddControls(List.toArray <| checkStmts ifStmts controlMap)
                                                                statementListElse.AddControls(List.toArray <| checkStmts elseStmts controlMap)
                                                                indentBlock statementListIf
                                                                setBlockVisibility statementListIf <| evalCondition cond controlMap
                                                                indentBlock statementListElse
                                                                setBlockVisibility statementListElse <| evalCondition cond controlMap
                                                                addConditionalEvents cond statementListIf
                                                                addConditionalEvents <| Neg(cond, pos) <| statementListElse
                                                                [statementListIf ; statementListElse]
        | IfConditional(cond, stmts, pos)                   ->  let statementList = new StatementList() // REFACTOR 1 extract method
                                                                statementList.AddControls(List.toArray <| checkStmts stmts controlMap)
                                                                indentBlock statementList
                                                                setBlockVisibility statementList <| evalCondition cond controlMap
                                                                addConditionalEvents cond statementList
                                                                [statementList]

    List.concat <| List.map checkStmt stmts

let buildGUI ast : Control list =   let controlMap = new Dictionary<string, StatementControl>()
                                    checkStmts ast.Statements controlMap