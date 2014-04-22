module ParserTests

open System
open Microsoft.VisualStudio.TestTools.UnitTesting
open QL.Grammar
open QL.Parsing


// Form
[<TestClass>]
type ParserTests() = 

    [<TestMethod>]
    member x.EmptyFormTest() = 
        //setup
        let input = "form TestForm{ }"
        let expectedOutput = { Name = "TestForm"; StatementList = []; }
        //execute
        let output = Parse input
        //assert
        Assert.AreEqual(expectedOutput.ToString(), output.ToString())

    [<TestMethod>]
    member x.FormWithOneQuestionTest() = 
        //setup
        let input = "form TestForm { hasSoldHouse: \"Dit is \\\" mijn vraag?\" boolean }"
        let expectedOutput = {Name = "TestForm"; StatementList = [Question ("hasSoldHouse","Dit is \\\" mijn vraag?",QL_Boolean,new QL.Grammar.Position())];}
        //execute
        let output = Parse input
        //assert
        Assert.AreEqual(expectedOutput.ToString(), output.ToString())
