module QL_Fsharp_Test

open System
open Microsoft.VisualStudio.TestTools.UnitTesting
open QL_Main
open QL_Grammar

// Form
[<TestClass>]
type FormTests() = 
    [<TestMethod>]
    member x.EmptyForm () = 
        let text = "form formName { }"
        let tree = { ID = "formName"; Statements = [] }
        let result = parse_str text true
        Assert.AreEqual(tree, result)

// Questions
[<TestClass>]
type QuestionTests() = 
    [<TestMethod>]
    member x.BoolQuestion1 () = 
        let text = "form formName {
                        boolQ: \"Does it work?\" boolean
                    }"
        let tree = { ID = "formName"; Statements = [
                                        Question({ 
                                                    ID = "boolQ"; 
                                                    Label = "Does it work?";
                                                    Type = QLBool })
                                        ]; }
        let result = parse_str text true
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.BoolQuestion2 () = 
        let text = "form formName {
                        boolQ1: \"Does it work?\" boolean
                        boolQ2: \"And with two questions?\" boolean
                    }"
        let tree = { ID = "formName"; Statements = [
                                        Question({ 
                                                    ID = "boolQ1"; 
                                                    Label = "Does it work?";
                                                    Type = QLBool });
                                        Question({ 
                                                    ID = "boolQ2"; 
                                                    Label = "And with two questions?";
                                                    Type = QLBool })
                                        ]; }
        let result = parse_str text true
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
        let tree = { ID = "formName"; Statements = [
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
        let result = parse_str text true
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.ConditialBool () = 
        let text = "form formName {
                        if (true) {
                            boolQ: \"Can you see this?\" boolean
                        }
                    }"
        let tree = { ID = "formName"; Statements = [
                                        Conditional(Literal(Bool(true)), [
                                                        Question({
                                                                    ID = "boolQ"; 
                                                                    Label = "Can you see this?";
                                                                    Type = QLBool
                                                        })
                                                    ])
                                    ]; }
        let result = parse_str text true
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.ConditialComp () = 
        let text = "form formName {
                        boolQ1: \"How much do you earn?\" integer
                        if (boolQ1 > 5) {
                            boolQ2: \"Is it enough?\" boolean
                        }
                    }"
        let tree = { ID = "formName"; Statements = [
                                        Question({ 
                                                    ID = "boolQ1"; 
                                                    Label = "How much do you earn?";
                                                    Type = QLInt });
                                        Conditional(BooleanOp(ID("boolQ1"), Gt, Literal(Int(5))), [
                                                        Question({
                                                                    ID = "boolQ2"; 
                                                                    Label = "Is it enough?";
                                                                    Type = QLBool
                                                        })
                                                    ])
                                    ]; }
        let result = parse_str text true
        Assert.AreEqual(tree, result)

// Assignment
[<TestClass>]
type AssignmentTests() = 
    [<TestMethod>]
    member x.Assignment () = 
        let text = "form formName {
                        intQ1: \"Income?\" integer
                        \"Tax amount\" intTax = intQ1 / 100 * 52
                    }"
        let tree = { ID = "formName"; Statements = [
                                        Question({ 
                                                    ID = "intQ1"; 
                                                    Label = "Income?";
                                                    Type = QLInt
                                                });
                                        Assignment({
                                                    ID = "intTax";
                                                    Label = "Tax amount";
                                                    Expression = ArithmeticOp(ArithmeticOp(ID("intQ1"), arithmeticOp.Div, Literal(Int(100))), arithmeticOp.Mult, Literal(Int(52)))
                                                });
                                    ]; }
        let result = parse_str text true
        Assert.AreEqual(tree, result)


// Arithmetic Tests

// Associativity
[<TestClass>]
type Associativity() = 
    [<TestMethod>]
    member x.AssocPlus () = 
        let text = "form formName { \"Testing assignment\" intX = 1 + 2 + 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment({
                                                    ID = "intX";
                                                    Label = "Testing assignment"
                                                    Expression = ArithmeticOp(ArithmeticOp(Literal(Int(1)), arithmeticOp.Plus, Literal(Int(2))), arithmeticOp.Plus, Literal(Int(3)))
                                                })
                                            ]}
        let result = parse_str text true
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.AssocMin () = 
        let text = "form formName { \"Testing assignment\" intX = 1 - 2 - 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment({
                                                    ID = "intX";
                                                    Label = "Testing assignment"
                                                    Expression = ArithmeticOp(ArithmeticOp(Literal(Int(1)), arithmeticOp.Minus, Literal(Int(2))), arithmeticOp.Minus, Literal(Int(3)))
                                                })
                                            ]}
        let result = parse_str text true
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.AssocMult () = 
        let text = "form formName { \"Testing assignment\" intX = 1 * 2 * 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment({
                                                    ID = "intX";
                                                    Label = "Testing assignment"
                                                    Expression = ArithmeticOp(ArithmeticOp(Literal(Int(1)), arithmeticOp.Mult, Literal(Int(2))), arithmeticOp.Mult, Literal(Int(3)))
                                                })
                                            ]}
        let result = parse_str text true
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.AssocDiv () = 
        let text = "form formName { \"Testing assignment\" intX = 1 / 2 / 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment({
                                                    ID = "intX";
                                                    Label = "Testing assignment"
                                                    Expression = ArithmeticOp(ArithmeticOp(Literal(Int(1)), arithmeticOp.Div, Literal(Int(2))), arithmeticOp.Div, Literal(Int(3)))
                                                })
                                            ]}
        let result = parse_str text true
        Assert.AreEqual(tree, result)

// Precedence
[<TestClass>]
type Precedence() = 
    [<TestMethod>]
    member x.PrecPlusMult () = 
        let text = "form formName { \"Testing assignment\" intX = 1 + 2 * 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment({
                                                    ID = "intX";
                                                    Label = "Testing assignment"
                                                    Expression = ArithmeticOp(Literal(Int(1)), arithmeticOp.Plus, ArithmeticOp(Literal(Int(2)), arithmeticOp.Mult, Literal(Int(3))))
                                                })
                                            ]}
        let result = parse_str text true
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.PrecMinDiv () = 
        let text = "form formName { \"Testing assignment\" intX = 1 - 2 / 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment({
                                                    ID = "intX";
                                                    Label = "Testing assignment"
                                                    Expression = ArithmeticOp(Literal(Int(1)), arithmeticOp.Minus, ArithmeticOp(Literal(Int(2)), arithmeticOp.Div, Literal(Int(3))))
                                                })
                                            ]}
        let result = parse_str text true
        Assert.AreEqual(tree, result)

