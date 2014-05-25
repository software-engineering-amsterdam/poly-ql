module InterpretGUI
open System.Windows.Forms
open QL
open QL.Values
open QL.AbstractSyntaxTree
open QL.Interpreter
open QLUI.WindowsForms.Abstract
open QLUI.WindowsForms.Forms

    let getValueFromControl (control:QuestionControl) =
        match box control with
        | :? IPrimitiveValue<bool>   -> QLBoolean((box control :?> IPrimitiveValue<bool>).GetValue())
        | :? IPrimitiveValue<int>    -> QLInteger((box control :?> IPrimitiveValue<int>).GetValue())
        | :? IPrimitiveValue<string> -> QLString((box control :?> IPrimitiveValue<string>).GetValue())
        | _ -> failwith "Unexpected primitive type from GUI"

    let setValueToControl (control:QuestionControl) value =
        match (box control, value) with
        | :? IPrimitiveValue<bool>, QLBoolean(innervalue)  -> (box control :?> IPrimitiveValue<bool>).SetValue(innervalue)
        | :? IPrimitiveValue<int>, QLInteger(innervalue)   -> (box control :?> IPrimitiveValue<int>).SetValue(innervalue)
        | :? IPrimitiveValue<string>, QLString(innervalue) -> (box control :?> IPrimitiveValue<string>).SetValue(innervalue)
        | _ -> failwith "Invalid combination of control and value"

    let rec evaluateExpression expression (controlMap:Map<string,QuestionControl>) =
        match expression with
        | Id(id) -> getValueFromControl controlMap.[id]
        | LiteralStatement(literalValue) -> failwith ""
        | Neg(innerExpression) -> evaluateNegationExpression (evaluateExpression innerExpression controlMap)
        | BinaryExpression(leftExpression,operator,rightExpression) -> evaluateBinaryExpression (evaluateExpression leftExpression controlMap) operator (evaluateExpression rightExpression controlMap)
        | ArithmeticExpression(leftExpression,operator,rightExpression) -> evaluateArithmeticExpression (evaluateExpression leftExpression controlMap) operator (evaluateExpression rightExpression controlMap)

