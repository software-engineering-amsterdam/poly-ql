module ParserTests

open System
open Microsoft.VisualStudio.TestTools.UnitTesting
open QL.AbstractSyntaxTree
open QL.Parsing
open QlParser

// Form
[<TestClass>]
type ParserTests() = 

    [<TestMethod>]
    member x.EmptyFormTest() = 
        let input = "form TestForm{ }"
        let expectedOutput = { Name = "TestForm"; StatementList = []; }
        let output = ParseToObject QlParser.start (LexBuffer input)
        Assert.AreEqual(expectedOutput, output)

    [<TestMethod>]
    member x.FormWithOneQuestionTest() = 
        let input = "form TestForm { hasSoldHouse: \"Dit is \\\" mijn vraag?\" boolean }"
        let expectedOutput = {Name = "TestForm"; StatementList = [Question ("hasSoldHouse","Dit is \\\" mijn vraag?",QL_Boolean,new Position())];}
        let output = ParseToObject QlParser.start (LexBuffer input)
        Assert.AreEqual(expectedOutput, output)

    [<TestMethod>]
    member x.ArithmeticPrecedenceTest() = 
        let input = "1 + 2 * 3 - 4 / 5"
        let expectedoutput = ArithmeticExpression(ArithmeticExpression(LiteralStatement (Integer 1),Plus,ArithmeticExpression(LiteralStatement (Integer 2),Times,LiteralStatement (Integer 3))), Minus,ArithmeticExpression(LiteralStatement (Integer 4),Divide,LiteralStatement (Integer 5)))
        let output = ParseToObject QlParser.startexpression (LexBuffer input)
        Assert.AreEqual(expectedoutput, output)