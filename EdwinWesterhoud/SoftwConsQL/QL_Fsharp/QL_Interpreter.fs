module QL_Interpreter

open System.Collections.Generic
open System
open System.Windows.Forms;
open QL_Grammar
open QL_Checker
open QL_Csharp
open QL_Csharp.PrimitiveControls

let indentBlock (stmtListControl : StatementList) = let mutable margin = stmtListControl.Margin
                                                    margin.Left <- 25
                                                    stmtListControl.Margin <- margin

let setBlockVisibility (block : StatementList) newVisibility = block.Visible <- newVisibility

let assignmentGUI label expression = new StringControl(label)

let questionGUI label qlType : StatementControl =   match qlType with
                                                    | QLBool    -> upcast new BooleanControl(label)
                                                    | QLString
                                                    | QLInt
                                                    | QLDecimal -> upcast new StringControl(label)

let getValue (control : StatementControl) = match control with
                                            | :? BooleanControl -> let bcontrol = control :?> BooleanControl
                                                                   Bool(bcontrol.GetValue())
                                            | _ -> failwith "Unknown control type (did you add a new control?)"

let evalBooleanOp (left, op, right) =   match (left, op, right) with
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

let evalArithmeticOp (left, op, right)= match (left, op, right) with
                                        | (Int(left),     arithmeticOp.Plus,  Int(right))     -> Int(left + right)
                                        | (Int(left),     arithmeticOp.Minus, Int(right))     -> Int(left - right)
                                        | (Int(left),     arithmeticOp.Mult,  Int(right))     -> Int(left * right)
                                        | (Int(left),     arithmeticOp.Div,   Int(right))     -> Int(left / right)

                                        | (Decimal(left), arithmeticOp.Plus,  Decimal(right)) -> Decimal(left + right)
                                        | (Decimal(left), arithmeticOp.Minus, Decimal(right)) -> Decimal(left - right)
                                        | (Decimal(left), arithmeticOp.Mult,  Decimal(right)) -> Decimal(left * right)
                                        | (Decimal(left), arithmeticOp.Div,   Decimal(right)) -> Decimal(left / right)

                                        | (_, _, _) -> failwith "Unexpected application of a boolean operation (may indicate problem in typechecker)"

let rec evalExpr expression (controlMap : Dictionary<string, StatementControl>) =
    match expression with
    | ID(name, _)     -> getValue controlMap.[name]
    | Literal(lit, _) -> lit
    | Neg(expr, _)    -> let evalInner = evalExpr expr controlMap
                         match evalInner with
                         | Bool(value) -> Bool(not value)
                         | _           -> failwith "Unexpected result (may indicate problem in typechecker)"
    | BooleanOp(left, op, right, _)    -> let evalLeft = evalExpr left controlMap
                                          let evalRight = evalExpr right controlMap
                                          evalBooleanOp (evalLeft, op, evalRight)
    | ArithmeticOp(left, op, right, _) -> let evalLeft = evalExpr left controlMap
                                          let evalRight = evalExpr right controlMap
                                          evalArithmeticOp (evalLeft, op, evalRight)


let rec checkStmts stmts (controlMap : Dictionary<string, StatementControl>) : Control list =
    let evalCondition condition = let evaluated = evalExpr condition controlMap
                                  match evaluated with
                                  | Bool(value) -> value
                                  | _           -> failwith "Unexpected result (may indicate problem in typechecker)"

    let addEvents condition (statementList : StatementList) = 
        let rec addEventsExpr expression =  match expression with
                                            | ID(name, _)   ->  controlMap.[name].AddValueChangedEventHandler
                                                                    (
                                                                        fun _ _ -> setBlockVisibility statementList <| evalCondition condition
                                                                    )
                                            | Literal(_, _) -> ()
                                            | Neg(expr, _)  -> addEventsExpr expr
                                            | BooleanOp(left, _, right, _)
                                            | ArithmeticOp(left, _, right, _) -> addEventsExpr left
                                                                                 addEventsExpr right

        addEventsExpr condition

    let checkStmt stmt : Control list =
        match stmt with
        | Assignment(id, label, expression, pos)             -> [assignmentGUI label expression] // TODO add to controlmap (id, control)
        | Question(id, label, qlType, pos)                   -> let control = questionGUI label qlType
                                                                controlMap.Add(id, control)
                                                                [control]
        | IfElseConditional(cond, ifStmts, elseStmts, pos)   -> let statementListIf = new StatementList()
                                                                let statementListElse = new StatementList()
                                                                statementListIf.AddControls(List.toArray <| checkStmts ifStmts controlMap)
                                                                statementListElse.AddControls(List.toArray <| checkStmts elseStmts controlMap)
                                                                indentBlock statementListIf
                                                                setBlockVisibility statementListIf <| evalCondition cond
                                                                indentBlock statementListElse
                                                                setBlockVisibility statementListElse <| evalCondition cond
                                                                [statementListIf ; statementListElse]
        | IfConditional(cond, stmts, pos)                   ->  let statementList = new StatementList()
                                                                statementList.AddControls(List.toArray <| checkStmts stmts controlMap)
                                                                indentBlock statementList
                                                                setBlockVisibility statementList <| evalCondition cond
                                                                addEvents cond statementList
                                                                [statementList]

    List.concat <| List.map checkStmt stmts

let buildGUI ast : Control list =   let controlMap = new Dictionary<string, StatementControl>()
                                    checkStmts ast.Statements controlMap