module TypeCheckerTests

open System
open Microsoft.VisualStudio.TestTools.UnitTesting
open QL_Main
open QL_Grammar
open QL_Checker

[<TestClass>]
type TypeChecker() = 
    [<TestMethod>]
    member x.UndefinedQuestion () = 
        let text = "form formName { \"Testing assignment\" intX = undefinedQuestion }"
        let result = parse_string text
        let checkInfo = typeCheck result
        Assert.IsTrue(checkInfo.ErrorList.Length = 1)
        let errorMessage = fst checkInfo.ErrorList.Head
        Assert.IsTrue(errorMessage.Contains("Unknown identifier"))

    [<TestMethod>]
    member x.DuplicateQuestion () = 
        let text = "form formName { \"Question 1\" intX : integer 
                                    \"Duplicate \" intX : integer }"
        let result = parse_string text
        let checkInfo = typeCheck result
        Assert.IsTrue(checkInfo.ErrorList.Length = 1)
        let errorMessage = fst checkInfo.ErrorList.Head
        Assert.IsTrue(errorMessage.Contains("Duplicate identifier"))

    [<TestMethod>]
    member x.NonBoolIfCondition () = 
        let text = "form formName {
                if (1) {
                }
            }"
        let result = parse_string text
        let checkInfo = typeCheck result
        Assert.IsTrue(checkInfo.ErrorList.Length = 1)
        let errorMessage = fst checkInfo.ErrorList.Head
        Assert.IsTrue(errorMessage.Contains("expected Boolean expression"))

    [<TestMethod>]
    member x.InvalidAnd () = 
        let text = "form formName {
                if (1 && 1) {
                }
            }"
        let result = parse_string text
        let checkInfo = typeCheck result
        Assert.IsTrue(checkInfo.ErrorList.Length = 1)
        let errorMessage = fst checkInfo.ErrorList.Head
        Assert.IsTrue(errorMessage.Contains("cannot apply"))
        Assert.IsTrue(errorMessage.Contains("Int"))
        Assert.IsTrue(errorMessage.Contains("&&"))

    [<TestMethod>]
    member x.InvalidOr () = 
        let text = "form formName {
                if (1.0 || 1.0) {
                }
            }"
        let result = parse_string text
        let checkInfo = typeCheck result
        Assert.IsTrue(checkInfo.ErrorList.Length = 1)
        let errorMessage = fst checkInfo.ErrorList.Head
        Assert.IsTrue(errorMessage.Contains("cannot apply"))
        Assert.IsTrue(errorMessage.Contains("Decimal"))
        Assert.IsTrue(errorMessage.Contains("||"))

    [<TestMethod>]
    member x.InvalidEq () = 
        let text = "form formName {
                if (1.0 == \"\") {
                }
            }"
        let result = parse_string text
        let checkInfo = typeCheck result
        Assert.IsTrue(checkInfo.ErrorList.Length = 1)
        let errorMessage = fst checkInfo.ErrorList.Head
        Assert.IsTrue(errorMessage.Contains("cannot apply"))
        Assert.IsTrue(errorMessage.Contains("Decimal"))
        Assert.IsTrue(errorMessage.Contains("String"))
        Assert.IsTrue(errorMessage.Contains("=="))

    [<TestMethod>]
    member x.InvalidNe () = 
        let text = "form formName {
                if (\"\" != 1) {
                }
            }"
        let result = parse_string text
        let checkInfo = typeCheck result
        Assert.IsTrue(checkInfo.ErrorList.Length = 1)
        let errorMessage = fst checkInfo.ErrorList.Head
        Assert.IsTrue(errorMessage.Contains("cannot apply"))
        Assert.IsTrue(errorMessage.Contains("String"))
        Assert.IsTrue(errorMessage.Contains("Int"))
        Assert.IsTrue(errorMessage.Contains("!="))

    [<TestMethod>]
    member x.InvalidPlus () = 
        let text = "form formName {
                \"Assignment\" expression = 1 + true
            }"
        let result = parse_string text
        let checkInfo = typeCheck result
        Assert.IsTrue(checkInfo.ErrorList.Length = 1)
        let errorMessage = fst checkInfo.ErrorList.Head
        Assert.IsTrue(errorMessage.Contains("cannot apply"))
        Assert.IsTrue(errorMessage.Contains("Int"))
        Assert.IsTrue(errorMessage.Contains("Boolean"))
        Assert.IsTrue(errorMessage.Contains("+"))

    [<TestMethod>]
    member x.InvalidMinus () = 
        let text = "form formName {
                \"Assignment\" expression = 1.0 - \"\"
            }"
        let result = parse_string text
        let checkInfo = typeCheck result
        Assert.IsTrue(checkInfo.ErrorList.Length = 1)
        let errorMessage = fst checkInfo.ErrorList.Head
        Assert.IsTrue(errorMessage.Contains("cannot apply"))
        Assert.IsTrue(errorMessage.Contains("Decimal"))
        Assert.IsTrue(errorMessage.Contains("String"))
        Assert.IsTrue(errorMessage.Contains("-"))

    [<TestMethod>]
    member x.InvalidMult() = 
        let text = "form formName {
                \"Assignment\" expression = 1.0 * true
            }"
        let result = parse_string text
        let checkInfo = typeCheck result
        Assert.IsTrue(checkInfo.ErrorList.Length = 1)
        let errorMessage = fst checkInfo.ErrorList.Head
        Assert.IsTrue(errorMessage.Contains("cannot apply"))
        Assert.IsTrue(errorMessage.Contains("Decimal"))
        Assert.IsTrue(errorMessage.Contains("Boolean"))
        Assert.IsTrue(errorMessage.Contains("*"))

    [<TestMethod>]
    member x.InvalidDiv () = 
        let text = "form formName {
                \"Assignment\" expression = \"\" / 1
            }"
        let result = parse_string text
        let checkInfo = typeCheck result
        Assert.IsTrue(checkInfo.ErrorList.Length = 1)
        let errorMessage = fst checkInfo.ErrorList.Head
        Assert.IsTrue(errorMessage.Contains("cannot apply"))
        Assert.IsTrue(errorMessage.Contains("String"))
        Assert.IsTrue(errorMessage.Contains("Int"))
        Assert.IsTrue(errorMessage.Contains("/"))