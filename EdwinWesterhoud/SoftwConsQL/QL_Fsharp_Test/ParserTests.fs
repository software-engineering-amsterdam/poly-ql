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
        let result = parse_string text
        Assert.AreEqual(tree.ToString(), result.ToString())

// Questions
[<TestClass>]
type QuestionTests() = 
    [<TestMethod>]
    member x.BoolQuestion1 () = 
        let text = "form formName {
                        \"Does it work?\" boolQ: boolean
                    }"
        let tree = { ID = "formName"; Statements = [
                                        Question( "boolQ",
                                                  "Does it work?",
                                                  QLBool, new QL_Grammar.Position())
                                        ]; }
        let result = parse_string text
        Assert.AreEqual(tree.ToString(), result.ToString())
    [<TestMethod>]
    member x.BoolQuestion2 () = 
        let text = "form formName {
                        \"Does it work?\" boolQ1: boolean
                        \"And with two questions?\" boolQ2: boolean
                    }"
        let tree = { ID = "formName"; Statements = [
                                        Question( "boolQ1",
                                                  "Does it work?",
                                                  QLBool, new QL_Grammar.Position());
                                        Question( "boolQ2",
                                                  "And with two questions?",
                                                   QLBool, new QL_Grammar.Position())
                                        ]; }
        let result = parse_string text
        Assert.AreEqual(tree.ToString(), result.ToString())

// Conditionals
[<TestClass>]
type ConditionalTests() = 
    [<TestMethod>]
    member x.ConditialID () = 
        let text = "form formName {
                        \"Display next question?\" boolQ1: boolean
                        if (boolQ1) {
                            \"Did you like it?\" boolQ2: boolean
                        }
                    }"
        let tree = { ID = "formName"; Statements = [
                                        Question( "boolQ1",
                                                  "Display next question?",
                                                  QLBool, new QL_Grammar.Position());
                                        IfConditional(ID("boolQ1", new QL_Grammar.Position()), [
                                                        Question( "boolQ2",
                                                                    "Did you like it?",
                                                                    QLBool, new QL_Grammar.Position())
                                                    ], new QL_Grammar.Position())
                                    ]; }
        let result = parse_string text
        Assert.AreEqual(tree.ToString(), result.ToString())
    [<TestMethod>]
    member x.ConditialBool () = 
        let text = "form formName {
                        if (true) {
                            \"Can you see this?\" boolQ: boolean
                        }
                    }"
        let tree = { ID = "formName"; Statements = [
                                        IfConditional(Literal(Bool(true), new QL_Grammar.Position()), [
                                                        Question( "boolQ",
                                                                   "Can you see this?",
                                                                   QLBool, new QL_Grammar.Position())
                                                    ], new QL_Grammar.Position())
                                    ]; }
        let result = parse_string text
        Assert.AreEqual(tree.ToString(), result.ToString())
    [<TestMethod>]
    member x.ConditialComp () = 
        let text = "form formName {
                        \"How much do you earn?\" boolQ1: integer
                        if (boolQ1 > 5) {
                            \"Is it enough?\" boolQ2: boolean
                        }
                    }"
        let tree = { ID = "formName"; Statements = [
                                        Question( "boolQ1",
                                                  "How much do you earn?",
                                                  QLInt, new QL_Grammar.Position());
                                        IfConditional(BooleanOp(ID("boolQ1", new QL_Grammar.Position()), Gt, Literal(Int(5), new QL_Grammar.Position()), new QL_Grammar.Position()), [
                                                        Question( "boolQ2",
                                                                  "Is it enough?",
                                                                  QLBool, new QL_Grammar.Position())
                                                    ], new QL_Grammar.Position())
                                    ]; }
        let result = parse_string text
        Assert.AreEqual(tree.ToString(), result.ToString())

// Assignment
[<TestClass>]
type AssignmentTests() = 
    [<TestMethod>]
    member x.Assignment () = 
        let text = "form formName {
                        \"Income?\" intQ1: integer
                        \"Tax amount\" intTax = intQ1 / 100 * 52
                    }"
        let tree = { ID = "formName"; Statements = [
                                        Question( "intQ1",
                                                  "Income?",
                                                  QLInt, new QL_Grammar.Position());
                                        Assignment( "intTax",
                                                    "Tax amount",
                                                    ArithmeticOp(ArithmeticOp(ID("intQ1", new QL_Grammar.Position()), arithmeticOp.Div, Literal(Int(100), new QL_Grammar.Position()), new QL_Grammar.Position()), arithmeticOp.Mult, Literal(Int(52), new QL_Grammar.Position()), new QL_Grammar.Position())
                                                  , new QL_Grammar.Position());
                                    ]; }
        let result = parse_string text
        Assert.AreEqual(tree.ToString(), result.ToString())


// Arithmetic Tests

// Associativity
[<TestClass>]
type Associativity() = 
    [<TestMethod>]
    member x.AssocPlus () = 
        let text = "form formName { \"Testing assignment\" intX = 1 + 2 + 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment( "intX",
                                                    "Testing assignment",
                                                    ArithmeticOp(ArithmeticOp(Literal(Int(1), new QL_Grammar.Position()), arithmeticOp.Plus, Literal(Int(2), new QL_Grammar.Position()), new QL_Grammar.Position()), arithmeticOp.Plus, Literal(Int(3), new QL_Grammar.Position()), new QL_Grammar.Position())
                                                  , new QL_Grammar.Position())
                                            ]}
        let result = parse_string text
        Assert.AreEqual(tree.ToString(), result.ToString())
    [<TestMethod>]
    member x.AssocMin () = 
        let text = "form formName { \"Testing assignment\" intX = 1 - 2 - 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment( "intX",
                                                    "Testing assignment",
                                                    ArithmeticOp(ArithmeticOp(Literal(Int(1), new QL_Grammar.Position()), arithmeticOp.Minus, Literal(Int(2), new QL_Grammar.Position()), new QL_Grammar.Position()), arithmeticOp.Minus, Literal(Int(3), new QL_Grammar.Position()), new QL_Grammar.Position())
                                                  , new QL_Grammar.Position())
                                            ]}
        let result = parse_string text
        Assert.AreEqual(tree.ToString(), result.ToString())
    [<TestMethod>]
    member x.AssocMult () = 
        let text = "form formName { \"Testing assignment\" intX = 1 * 2 * 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment( "intX",
                                                    "Testing assignment",
                                                    ArithmeticOp(ArithmeticOp(Literal(Int(1), new QL_Grammar.Position()), arithmeticOp.Mult, Literal(Int(2), new QL_Grammar.Position()), new QL_Grammar.Position()), arithmeticOp.Mult, Literal(Int(3), new QL_Grammar.Position()), new QL_Grammar.Position())
                                                  , new QL_Grammar.Position())
                                            ]}
        let result = parse_string text
        Assert.AreEqual(tree.ToString(), result.ToString())
    [<TestMethod>]
    member x.AssocDiv () = 
        let text = "form formName { \"Testing assignment\" intX = 1 / 2 / 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment( "intX",
                                                    "Testing assignment",
                                                    ArithmeticOp(ArithmeticOp(Literal(Int(1), new QL_Grammar.Position()), arithmeticOp.Div, Literal(Int(2), new QL_Grammar.Position()), new QL_Grammar.Position()), arithmeticOp.Div, Literal(Int(3), new QL_Grammar.Position()), new QL_Grammar.Position())
                                                  , new QL_Grammar.Position())
                                            ]}
        let result = parse_string text
        Assert.AreEqual(tree.ToString(), result.ToString())

// Precedence
[<TestClass>]
type Precedence() = 
    [<TestMethod>]
    member x.PrecPlusMult () = 
        let text = "form formName { \"Testing assignment\" intX = 1 + 2 * 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment( "intX",
                                                    "Testing assignment",
                                                    ArithmeticOp(Literal(Int(1), new QL_Grammar.Position()), arithmeticOp.Plus, ArithmeticOp(Literal(Int(2), new QL_Grammar.Position()), arithmeticOp.Mult, Literal(Int(3), new QL_Grammar.Position()), new QL_Grammar.Position()), new QL_Grammar.Position())
                                                  , new QL_Grammar.Position())
                                            ]}
        let result = parse_string text
        Assert.AreEqual(tree.ToString(), result.ToString())
    [<TestMethod>]
    member x.PrecMinDiv () = 
        let text = "form formName { \"Testing assignment\" intX = 1 - 2 / 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment( "intX",
                                                    "Testing assignment",
                                                    ArithmeticOp(Literal(Int(1), new QL_Grammar.Position()), arithmeticOp.Minus, ArithmeticOp(Literal(Int(2), new QL_Grammar.Position()), arithmeticOp.Div, Literal(Int(3), new QL_Grammar.Position()), new QL_Grammar.Position()), new QL_Grammar.Position())
                                                  , new QL_Grammar.Position())
                                            ]}
        let result = parse_string text
        Assert.AreEqual(tree.ToString(), result.ToString())