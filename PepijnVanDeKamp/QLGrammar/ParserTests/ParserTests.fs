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
    member x.FormWithOneStatementTest() = 
        let input = "form TestForm { hasSoldHouse: \"Dit is \\\" mijn vraag?\" boolean }"
        let expectedOutput = {Name = "TestForm"; StatementList = [Question ("hasSoldHouse","Dit is \\\" mijn vraag?",QL_Boolean,new Position())];}
        let output = ParseToObject QlParser.start (LexBuffer input)
        Assert.AreEqual(expectedOutput, output)

    [<TestMethod>]
    member x.SingleLineCommentTest() = 
        let input = @"form TestForm { 
                         //Dit is een regel commentaar
                         hasSoldHouse: ""Dit is mijn vraag"" boolean 
                      }"
        let expectedOutput = {Name = "TestForm"; StatementList = [Question ("hasSoldHouse","Dit is mijn vraag",QL_Boolean,new Position())];}
        let output = ParseToObject QlParser.start (LexBuffer input)
        Assert.AreEqual(expectedOutput, output)

    [<TestMethod>]
    member x.ParseComputedQuestionTest() = 
        let input = "hasSoldHouse: \"Dit is mijn vraag?\" boolean(true)"
        let expectedOutput = ComputedQuestion("hasSoldHouse","Dit is mijn vraag?",QL_Boolean,LiteralStatement(Boolean(true)),new Position());
        let output = ParseToObject QlParser.startstatement (LexBuffer input)
        Assert.AreEqual(expectedOutput, output)

    [<TestMethod>]
    member x.ParseConditionIfThenTest() = 
        let input = "if(true){}"
        let expectedOutput = IfThen(LiteralStatement(Boolean(true)),[],Position());
        let output = ParseToObject QlParser.startstatement (LexBuffer input)
        Assert.AreEqual(expectedOutput, output)

    [<TestMethod>]
    member x.ParseConditionIfThenElseTest() = 
        let input = "if(true){}else{}"
        let expectedOutput = IfThenElse(LiteralStatement(Boolean(true)),[],[],Position());
        let output = ParseToObject QlParser.startstatement (LexBuffer input)
        Assert.AreEqual(expectedOutput, output)

    [<TestMethod>]
    member x.ParseNestedConditionsTest() = 
        let input = "if(true){if(false){if(true){}else{if(false){}else{}}}}else{}"
        let expectedOutput = IfThenElse(LiteralStatement(Boolean(true)),[IfThen(LiteralStatement(Boolean(false)),[IfThenElse(LiteralStatement(Boolean(true)),[],[IfThenElse(LiteralStatement(Boolean(false)),[],[],Position())],Position())],Position())],[],Position());
        let output = ParseToObject QlParser.startstatement (LexBuffer input)
        Assert.AreEqual(expectedOutput, output)

    [<TestMethod>]
    member x.ArithmeticPrecedenceTest() = 
        let input = "1 + 2 * 3 - 4 / 5"
        let expectedoutput = ArithmeticExpression(ArithmeticExpression(LiteralStatement (Integer 1),Plus,ArithmeticExpression(LiteralStatement (Integer 2),Times,LiteralStatement (Integer 3))), Minus,ArithmeticExpression(LiteralStatement (Integer 4),Divide,LiteralStatement (Integer 5)))
        let output = ParseToObject QlParser.startexpression (LexBuffer input)
        Assert.AreEqual(expectedoutput, output)