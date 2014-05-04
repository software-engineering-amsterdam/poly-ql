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
        let parser = new Parser()
        let output = parser.Parse input
        //assert
        Assert.AreEqual(expectedOutput.ToString(), output.ParseTree.Value.ToString())

    [<TestMethod>]
    member x.FormWithOneQuestionTest() = 
        //setup
        let input = "form TestForm { hasSoldHouse: \"Dit is \\\" mijn vraag?\" boolean }"
        let expectedOutput = {Name = "TestForm"; StatementList = [Question ("hasSoldHouse","Dit is \\\" mijn vraag?",QL_Boolean,new QL.Grammar.Position())];}
        //execute
        let parser = new Parser()
        let output = parser.Parse input
        //assert
        Assert.AreEqual(expectedOutput.ToString(), output.ParseTree.Value.ToString())

    member x.ArithmeticPrecedenceTest() = 
        let input = "form Box1HouseOwning { valueResidue: \"Value residue:\" integer(1 + 2 * 3 - 4 / 5) }";
        let expectedoutput = {Name = "Box1HouseOwning"; StatementList =  [ComputedQuestion("valueResidue","Value residue:",QL_Integer, ArithmeticExpression(ArithmeticExpression(LiteralStatement (Integer 1),Plus,ArithmeticExpression(LiteralStatement (Integer 2),Times,LiteralStatement (Integer 3))), Minus,ArithmeticExpression(LiteralStatement (Integer 4),Divide,LiteralStatement (Integer 5))), Position())];}
        //execute
        let parser = new Parser()
        let output = parser.Parse input
        //assert
        Assert.AreEqual(expectedoutput.ToString(), output.ParseTree.Value.ToString())