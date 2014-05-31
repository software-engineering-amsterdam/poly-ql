namespace QLUI
module Interpreter =

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

    let evaluateExpressionFromControls (controlMap:Map<string,QuestionControl>) expression =
        let resolveIdValue id = getValueFromControl controlMap.[id]
        evaluateExpression expression resolveIdValue

