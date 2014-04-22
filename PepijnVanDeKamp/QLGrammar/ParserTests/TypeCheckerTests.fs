module TypeCheckerTests

open System
open System.Collections.Generic
open System.Linq
open Microsoft.VisualStudio.TestTools.UnitTesting
open QL.Grammar
open QL.Parsing
open QL.TypeChecker


// Form
[<TestClass>]
type TypeCheckerTests() = 

    [<TestMethod>]
    member x.DuplicateLabelsWarningTest() = 
        //setup
        let input = {Name = "Box1HouseOwning"; StatementList = [Question ("hasSoldHouse","Did you sell a house in 2010?",QL_Boolean,Position());   Question("hasBoughtHouse","Did you sell a house in 2010?",QL_Boolean,Position())];}
        let rules = new List<ITypeRule>();
        rules.Add(new DuplicateLabelsRule());
        let checker = new TypeChecker(rules)

        //execute
        let output = checker.getMessages(input).ToList()

        //assert
        Assert.IsTrue(output.Exists(fun _m -> _m.Message.Equals("Duplicate Label 'Did you sell a house in 2010?'")));


    [<TestMethod>]
    member x.ReferenceUndefinedQuestionErrorTest() =
        let input = {Name = "Box1HouseOwning"; StatementList = [Question("hasBoughtHouse","Did you by a house in 2010?",QL_Boolean,Position()); IfThen(Id("hasSoldHouse"), [ComputedQuestion("valueResidue","Value residue:",QL_Integer,ArithmicExpression(Id("sellingPrice"),Minus,Id("privateDebt")),Position())],Position())];}
        let rules = new List<ITypeRule>();
        rules.Add(new ReferenceUndefinedQuestionsRule());
        let checker = new TypeChecker(rules)

        let output = checker.getMessages(input).ToList()

        Assert.IsTrue(output.Count = 3);
        Assert.IsTrue(output.[0].Message.Contains("hasSoldHouse"));
        Assert.IsTrue(output.[1].Message.Contains("sellingPrice"));
        Assert.IsTrue(output.[2].Message.Contains("privateDebt"));

    [<TestMethod>]
    member x.DuplicateQuestionDeclarationWithDifferentTypesTest() = 
        let input = {Name = "Box1HouseOwning"; StatementList =  [Question ("hasSoldHouse","Did you sell a house in 2010?",QL_Boolean,Position());   Question ("hasSoldHouse","Did you by a house in 2010?",QL_Integer,Position())];}
        let rules = new List<ITypeRule>();
        rules.Add(new DuplicateQuestionDeclarationsMustBeOfSameTypeRule());
        let checker = new TypeChecker(rules)

        let output = checker.getMessages(input).ToList()

        Assert.IsTrue(output.Count = 1);
        Assert.IsTrue(output.[0].Message.Contains("hasSoldHouse") && output.[0].Message.Contains("expected 'boolean'"));