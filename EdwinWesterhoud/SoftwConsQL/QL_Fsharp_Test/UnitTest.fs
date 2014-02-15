module QL_Fsharp_Test

open System
open Microsoft.VisualStudio.TestTools.UnitTesting
open Program
open QL_Grammar

// Form
[<TestClass>]
type FormTests() = 
    [<TestMethod>]
    member x.EmptyForm () = 
        let text = "form formName { }"
        let tree = { ID = "formName"; Questions = [] }
        let result = parse_str text
        Assert.AreEqual(tree, result)

// Questions
[<TestClass>]
type QuestionTests() = 
    [<TestMethod>]
    member x.BoolQuestion1 () = 
        let text = "form formName {
                        boolQ: \"Does it work?\" boolean
                    }"
        let tree = { ID = "formName"; Questions = [
                                        Question({ 
                                                    ID = "boolQ"; 
                                                    Label = "Does it work?";
                                                    Type = QLBool })
                                        ]; }
        let result = parse_str text
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.BoolQuestion2 () = 
        let text = "form formName {
                        boolQ1: \"Does it work?\" boolean
                        boolQ2: \"And with two questions?\" boolean
                    }"
        let tree = { ID = "formName"; Questions = [
                                        Question({ 
                                                    ID = "boolQ1"; 
                                                    Label = "Does it work?";
                                                    Type = QLBool });
                                        Question({ 
                                                    ID = "boolQ2"; 
                                                    Label = "And with two questions?";
                                                    Type = QLBool })
                                        ]; }
        let result = parse_str text
        Assert.AreEqual(tree, result)

// Conditionals
[<TestClass>]
type ConditionalTests() = 
    [<TestMethod>]
    member x.ConditialID () = 
        let text = "form formName {
                        boolQ1: \"Display next question?\" boolean
                        if (boolQ1) {
                            boolQ2: \"Did you like it?\" boolean
                        }
                    }"
        let tree = { ID = "formName"; Questions = [
                                        Question({ 
                                                    ID = "boolQ1"; 
                                                    Label = "Display next question?";
                                                    Type = QLBool });
                                        Conditional(ID("boolQ1"), [
                                                        Question({
                                                                    ID = "boolQ2"; 
                                                                    Label = "Did you like it?";
                                                                    Type = QLBool
                                                        })
                                                    ])
                                    ]; }
        let result = parse_str text
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.ConditialBool () = 
        let text = "form formName {
                        if (true) {
                            boolQ: \"Can you see this?\" boolean
                        }
                    }"
        let tree = { ID = "formName"; Questions = [
                                        Conditional(Expr(Bool(true)), [
                                                        Question({
                                                                    ID = "boolQ"; 
                                                                    Label = "Can you see this?";
                                                                    Type = QLBool
                                                        })
                                                    ])
                                    ]; }
        let result = parse_str text
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.ConditialComp () = 
        let text = "form formName {
                        boolQ1: \"How much do you earn?\" integer
                        if (boolQ1 > 5) {
                            boolQ2: \"Is it enough?\" boolean
                        }
                    }"
        let tree = { ID = "formName"; Questions = [
                                        Question({ 
                                                    ID = "boolQ1"; 
                                                    Label = "How much do you earn?";
                                                    Type = QLInt });
                                        Conditional(BooleanOp(ID("boolQ1"), Gt, Expr(Int(5))), [
                                                        Question({
                                                                    ID = "boolQ2"; 
                                                                    Label = "Is it enough?";
                                                                    Type = QLBool
                                                        })
                                                    ])
                                    ]; }
        let result = parse_str text
        Assert.AreEqual(tree, result)


// Arithmetic
//[<TestClass>]
//type ArithTests() = 
//    [<TestMethod>]
//    member x.ArithPlus () = 
//        let text = "form formName { 1+1 }"
//        let tree = { ID = "formName"; Questions = []}
//        let result = parse_str text
//        Assert.AreEqual(tree, result)
