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
        Assert.AreEqual(tree, result)

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
                                                  QLBool)
                                        ]; }
        let result = parse_string text
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.BoolQuestion2 () = 
        let text = "form formName {
                        \"Does it work?\" boolQ1: boolean
                        \"And with two questions?\" boolQ2: boolean
                    }"
        let tree = { ID = "formName"; Statements = [
                                        Question( "boolQ1",
                                                  "Does it work?",
                                                  QLBool);
                                        Question( "boolQ2",
                                                  "And with two questions?",
                                                   QLBool)
                                        ]; }
        let result = parse_string text
        Assert.AreEqual(tree, result)

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
                                                  QLBool);
                                        IfConditional(ID("boolQ1"), [
                                                        Question( "boolQ2",
                                                                    "Did you like it?",
                                                                    QLBool)
                                                    ])
                                    ]; }
        let result = parse_string text
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.ConditialBool () = 
        let text = "form formName {
                        if (true) {
                            \"Can you see this?\" boolQ: boolean
                        }
                    }"
        let tree = { ID = "formName"; Statements = [
                                        IfConditional(Literal(Bool(true)), [
                                                        Question( "boolQ",
                                                                   "Can you see this?",
                                                                   QLBool)
                                                    ])
                                    ]; }
        let result = parse_string text
        Assert.AreEqual(tree, result)
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
                                                  QLInt);
                                        IfConditional(BooleanOp(ID("boolQ1"), Gt, Literal(Int(5))), [
                                                        Question( "boolQ2",
                                                                  "Is it enough?",
                                                                  QLBool)
                                                    ])
                                    ]; }
        let result = parse_string text
        Assert.AreEqual(tree, result)

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
                                                  QLInt);
                                        Assignment( "intTax",
                                                    "Tax amount",
                                                    ArithmeticOp(ArithmeticOp(ID("intQ1"), arithmeticOp.Div, Literal(Int(100))), arithmeticOp.Mult, Literal(Int(52)))
                                                  );
                                    ]; }
        let result = parse_string text
        Assert.AreEqual(tree, result)


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
                                                    ArithmeticOp(ArithmeticOp(Literal(Int(1)), arithmeticOp.Plus, Literal(Int(2))), arithmeticOp.Plus, Literal(Int(3)))
                                                  )
                                            ]}
        let result = parse_string text
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.AssocMin () = 
        let text = "form formName { \"Testing assignment\" intX = 1 - 2 - 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment( "intX",
                                                    "Testing assignment",
                                                    ArithmeticOp(ArithmeticOp(Literal(Int(1)), arithmeticOp.Minus, Literal(Int(2))), arithmeticOp.Minus, Literal(Int(3)))
                                                  )
                                            ]}
        let result = parse_string text
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.AssocMult () = 
        let text = "form formName { \"Testing assignment\" intX = 1 * 2 * 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment( "intX",
                                                    "Testing assignment",
                                                    ArithmeticOp(ArithmeticOp(Literal(Int(1)), arithmeticOp.Mult, Literal(Int(2))), arithmeticOp.Mult, Literal(Int(3)))
                                                  )
                                            ]}
        let result = parse_string text
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.AssocDiv () = 
        let text = "form formName { \"Testing assignment\" intX = 1 / 2 / 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment( "intX",
                                                    "Testing assignment",
                                                    ArithmeticOp(ArithmeticOp(Literal(Int(1)), arithmeticOp.Div, Literal(Int(2))), arithmeticOp.Div, Literal(Int(3)))
                                                  )
                                            ]}
        let result = parse_string text
        Assert.AreEqual(tree, result)

// Precedence
[<TestClass>]
type Precedence() = 
    [<TestMethod>]
    member x.PrecPlusMult () = 
        let text = "form formName { \"Testing assignment\" intX = 1 + 2 * 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment( "intX",
                                                    "Testing assignment",
                                                    ArithmeticOp(Literal(Int(1)), arithmeticOp.Plus, ArithmeticOp(Literal(Int(2)), arithmeticOp.Mult, Literal(Int(3))))
                                                  )
                                            ]}
        let result = parse_string text
        Assert.AreEqual(tree, result)
    [<TestMethod>]
    member x.PrecMinDiv () = 
        let text = "form formName { \"Testing assignment\" intX = 1 - 2 / 3}"
        let tree = { ID = "formName"; Statements = [
                                        Assignment( "intX",
                                                    "Testing assignment",
                                                    ArithmeticOp(Literal(Int(1)), arithmeticOp.Minus, ArithmeticOp(Literal(Int(2)), arithmeticOp.Div, Literal(Int(3))))
                                                  )
                                            ]}
        let result = parse_string text
        Assert.AreEqual(tree, result)

//// Type checker
//[<TestClass>]
//type TypeChecker() = 
//    [<TestMethod>]
//    member x.PrecPlusMult () = 
//        let text = "form formName { \"Testing assignment\" intX = 1 + 2 * 3}"
//        let tree = { ID = "formName"; Statements = [
//                                        Assignment({
//                                                    ID = "intX";
//                                                    Label = "Testing assignment"
//                                                    Expression = ArithmeticOp(Literal(Int(1)), arithmeticOp.Plus, ArithmeticOp(Literal(Int(2)), arithmeticOp.Mult, Literal(Int(3))))
//                                                })
//                                            ]}
//        let result = parse_string text
//        Assert.AreEqual(tree, result)