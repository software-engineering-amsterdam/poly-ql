namespace QLUI
module InterpretGUI =

    open System.Windows.Forms
    open QL
    open QL.AbstractSyntaxTree
    open QL.Interpreter
    open QLUI.WindowsForms.Abstract
    open QLUI.WindowsForms.Forms

    let getValueFromControl (control:QuestionControl) =
        match box control with
        | :? IPrimitiveValue<bool>   -> Boolean((box control :?> IPrimitiveValue<bool>).GetValue())
        | :? IPrimitiveValue<int>    -> Integer((box control :?> IPrimitiveValue<int>).GetValue())
        | :? IPrimitiveValue<string> -> String((box control :?> IPrimitiveValue<string>).GetValue())
        | _ -> failwith "Unexpected primitive type from GUI"

    let setValueToControl (control:QuestionControl) value =
        match (box control, value) with
        | :? IPrimitiveValue<bool>, Boolean(innervalue)  -> (box control :?> IPrimitiveValue<bool>).SetValue(innervalue)
        | :? IPrimitiveValue<int>, Integer(innervalue)   -> (box control :?> IPrimitiveValue<int>).SetValue(innervalue)
        | :? IPrimitiveValue<string>, String(innervalue) -> (box control :?> IPrimitiveValue<string>).SetValue(innervalue)
        | _ -> failwith "Invalid combination of control and value"

    let rec evaluateExpression (controlMap:Map<string,QuestionControl>) expression =
        match expression with
        | Id(id) -> getValueFromControl controlMap.[id]
        | LiteralStatement(literalValue) -> literalValue
        | Neg(innerExpression) -> evaluateNegationExpression (evaluateExpression controlMap innerExpression)
        | BinaryExpression(leftExpression,operator,rightExpression) -> evaluateBinaryExpression (evaluateExpression controlMap leftExpression) operator (evaluateExpression controlMap rightExpression)
        | ArithmeticExpression(leftExpression,operator,rightExpression) -> evaluateArithmeticExpression (evaluateExpression controlMap leftExpression) operator (evaluateExpression controlMap rightExpression)

