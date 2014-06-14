module TypeCheckerTests

open System
open System.Collections.Generic
open System.Linq
open Microsoft.VisualStudio.TestTools.UnitTesting
open QL.AbstractSyntaxTree
open QL.Parsing
open QL.Checking
open QL.Checks


[<TestClass>]
type TypeCheckerTests() = 

    [<TestMethod>]
    member x.DuplicateLabelsWarningTest() = 
        let input = {Name = "Box1HouseOwning"; StatementList = [Question ("hasSoldHouse","Did you sell a house in 2010?",QL_Boolean,Position());   Question("hasBoughtHouse","Did you sell a house in 2010?",QL_Boolean,Position())];}     
        let output = duplicateLabelsCheck(input)
        Assert.IsTrue(output.Count() = 1)
        Assert.IsTrue(output.[0].Message.Equals("Duplicate Label 'Did you sell a house in 2010?'"));

    [<TestMethod>]
    member x.ReferenceUndefinedQuestionErrorTest() =
        let input = {Name = "Box1HouseOwning"; StatementList = [Question("hasBoughtHouse","Did you buy a house in 2010?",QL_Boolean,Position()); IfThen(Id("hasSoldHouse"), [ComputedQuestion("valueResidue","Value residue:",QL_Integer,ArithmeticExpression(Id("sellingPrice"),Minus,Id("privateDebt")),Position())],Position())];}
        let output = referenceUndefinedQuestionsCheck input
        Assert.IsTrue(output.Count() = 3);
        Assert.IsTrue(output.[0].Message.Contains("hasSoldHouse"));
        Assert.IsTrue(output.[1].Message.Contains("sellingPrice"));
        Assert.IsTrue(output.[2].Message.Contains("privateDebt"));

    [<TestMethod>]
    member x.DuplicateQuestionDeclarationWithDifferentTypesTest() = 
        let input = {Name = "Box1HouseOwning"; StatementList =  [Question ("hasSoldHouse","Did you sell a house in 2010?",QL_Boolean,Position());   Question ("hasSoldHouse","Did you buy a house in 2010?",QL_Integer,Position())];}
        let output = duplicateQuestionDeclarationsMustBeOfSameTypeCheck input
        Assert.IsTrue(output.Count() = 1);
        Assert.IsTrue(output.[0].Message.Contains("hasSoldHouse") && output.[0].Message.Contains("expected 'boolean'"));

    [<TestMethod>]
    member x.ExpectedTypeShouldMatchExpressionTypeTest() =
        let output questions = expressionMustBeOfExpectedTypeCheck {Name = "ExpressionTest"; StatementList = questions}
        let assertCheck questions expectedCount = Assert.IsTrue(output(questions).Count() = expectedCount)
        assertCheck [ComputedQuestion("q1","boolean with int literal",QL_Boolean,LiteralStatement (Integer 1),Position())] 1
        assertCheck [ComputedQuestion("q2","boolean with int Arithmetic",QL_Boolean, ArithmeticExpression(LiteralStatement (Integer 1),Plus,LiteralStatement (Integer 2)),Position())] 1
        assertCheck [Question ("q3","int",QL_Integer,Position());ComputedQuestion ("q4","boolean with int id",QL_Boolean,Id "q3",Position())] 1
        assertCheck [ComputedQuestion("q5","string with int literal",QL_String,LiteralStatement (Integer 1),Position())] 1
        assertCheck [ComputedQuestion("q6","string with int Arithmetic",QL_String, ArithmeticExpression(LiteralStatement (Integer 1),Plus,LiteralStatement (Integer 1)),Position())] 1
        assertCheck [Question ("q3","int",QL_Integer,Position());ComputedQuestion ("q7","string with int id",QL_String,Id "q3",Position())] 1
        assertCheck [ComputedQuestion("q8","string with binary",QL_String,BinaryExpression(LiteralStatement (Integer 5),GreaterThan,LiteralStatement (Integer 3)),Position())] 1
        assertCheck [ComputedQuestion("q9","string with NegationExpression",QL_String,NegationExpression (LiteralStatement (Integer 5)),Position())] 1
        assertCheck [ComputedQuestion("q10","int with boolean literal",QL_Integer,LiteralStatement (Boolean true),Position())] 1
        assertCheck [ComputedQuestion("q5","string with int literal",QL_String,LiteralStatement (Integer 1),Position());ComputedQuestion ("q11","int with string id",QL_Integer,Id "q5",Position())] 2
        assertCheck [ComputedQuestion("q12","int with binary",QL_Integer,BinaryExpression(LiteralStatement (Integer 1),GreaterThan,LiteralStatement (Integer 2)),Position())] 1
        assertCheck [ComputedQuestion("q13","int with NegationExpression",QL_Integer,NegationExpression (LiteralStatement (Integer 4)),Position())] 1

    [<TestMethod>]
    member x.OperandTypeMustMatchOperatorTest() =
        let input = {Name = "Box1HouseOwning"; StatementList = [IfThen(BinaryExpression(LiteralStatement (Integer 1),Equals,LiteralStatement (String "1")),[], Position())];}
        let output = operandsMustBeOfValidTypeToOperatorsCheck input
        Assert.IsTrue(output.[0].Message.Contains("expected 'integer'")) 

    [<TestMethod>]
    member x.CyclicDependencyNotAllowedTest() =
        let input = {Name = "Box1HouseOwning"; StatementList =  [Question ("q1","Did you sell a house in 2010?",QL_Boolean,Position());   ComputedQuestion("q2","Did you buy a house in 2010?",QL_Boolean,Id "q1",Position());   ComputedQuestion("q1","Did you enter a loan for maintenance/reconstruction?",QL_Boolean,Id "q2",Position())];}
        let output = cyclicDependencyCheck input
        Assert.IsTrue(output.[0].Message.Contains("Cyclic"))