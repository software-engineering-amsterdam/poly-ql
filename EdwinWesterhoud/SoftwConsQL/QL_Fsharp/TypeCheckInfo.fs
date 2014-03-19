module TypeCheckInfo

open System.Collections.Generic
open QL_Grammar

type expressionType = TBool | TString | TInt | TDecimal | TError | TForm
    with override this.ToString() = match this with
                                    | TBool -> "Boolean"
                                    | TString -> "String"
                                    | TInt -> "Integer"
                                    | TDecimal -> "Decimal"
                                    | TForm -> "Form"
                                    | TError -> "Error"

type TypeCheckInfo(formName) = 
    let errors = new List<string * Position>()
    let warnings = new List<string * Position>()

    let labels = new List<string>()
    let identifiers = new Dictionary<string, expressionType>()
    do identifiers.Add(formName, TForm)

    
    member this.RegisterError(message, position) = errors.Add("ERROR: " + message, position)
    member this.RegisterWarning(message, position) = warnings.Add("WARNING: " + message, position)

    member this.HasErrors = errors.Count > 0

    member this.ErrorList = List.ofSeq errors
    member this.WarningList = List.ofSeq warnings

    member this.RegisterIdentifier(id, exprType, position : Position) =
        if identifiers.ContainsKey(id) then
            this.RegisterError(sprintf "Duplicate identifier on line %i (\"%s\")" position.StartLine id, position)
        else
            identifiers.Add(id, exprType)

    member this.RegisterLabel(label, position : Position) =
        if labels.Contains(label) then
            this.RegisterWarning(sprintf "Duplicate label on line %i (\"%s\")" position.StartLine label, position)
        else
            labels.Add(label)
        
    
    member this.GetIdentifierType(id) = 
        if identifiers.ContainsKey(id)
        then identifiers.[id]
        else TError