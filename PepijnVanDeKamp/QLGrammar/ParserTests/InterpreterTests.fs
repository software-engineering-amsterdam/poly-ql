module InterpreterTests

open System
open System.Collections.Generic
open System.Linq
open Microsoft.VisualStudio.TestTools.UnitTesting
open QL.AbstractSyntaxTree
open QL.Parsing
open QL.Checking
open QL.Checks
open QL.Interpreter


[<TestClass>]
type InterpreterTests() = 

    [<TestMethod>]
    member x.EvaluateBinaryExpression() = 
       let idResolver id = failwith "Id resolver is just a placeholder and should not be called"
       let evalBoolean left operator right = evaluateExpression (BinaryExpression(LiteralStatement(Boolean(left)), operator ,LiteralStatement(Boolean(right)))) idResolver
       let evalString left operator right = evaluateExpression (BinaryExpression(LiteralStatement(String(left)), operator ,LiteralStatement(String(right)))) idResolver
       let evalInteger left operator right = evaluateExpression (BinaryExpression(LiteralStatement(Integer(left)), operator ,LiteralStatement(Integer(right)))) idResolver
       Assert.AreEqual(evalBoolean true And true,Boolean(true))
       Assert.AreEqual(evalBoolean true And false,Boolean(false))
       Assert.AreEqual(evalBoolean false And true,Boolean(false))
       Assert.AreEqual(evalBoolean false Or true,Boolean(true))
       Assert.AreEqual(evalBoolean true Or false,Boolean(true))
       Assert.AreEqual(evalBoolean true Equals false,Boolean(false))
       Assert.AreEqual(evalBoolean true Equals true,Boolean(true))
       Assert.AreEqual(evalBoolean true NotEquals false,Boolean(true))
       Assert.AreEqual(evalBoolean true NotEquals true,Boolean(false))
       Assert.AreEqual(evalString "a" Equals "a", Boolean(true))
       Assert.AreEqual(evalString "a" Equals "b", Boolean(false))
       Assert.AreEqual(evalString "a" NotEquals "a", Boolean(false))
       Assert.AreEqual(evalString "a" NotEquals "b", Boolean(true))
       Assert.AreEqual(evalInteger 1 Equals 1, Boolean(true))
       Assert.AreEqual(evalInteger 1 Equals 2, Boolean(false))
       Assert.AreEqual(evalInteger 1 NotEquals 2, Boolean(true))
       Assert.AreEqual(evalInteger 1 NotEquals 1, Boolean(false))
       Assert.AreEqual(evalInteger 1 GreaterThan 2, Boolean(false))
       Assert.AreEqual(evalInteger 2 GreaterThan 1, Boolean(true))
       Assert.AreEqual(evalInteger 2 GreaterEqualsThan 1, Boolean(true))
       Assert.AreEqual(evalInteger 1 GreaterEqualsThan 1, Boolean(true))
       Assert.AreEqual(evalInteger 1 GreaterEqualsThan 2, Boolean(false))
       Assert.AreEqual(evalInteger 1 LessThan 2, Boolean(true))
       Assert.AreEqual(evalInteger 2 LessThan 1, Boolean(false))
       Assert.AreEqual(evalInteger 2 LessEqualsThan 1, Boolean(false))
       Assert.AreEqual(evalInteger 1 LessEqualsThan 1, Boolean(true))
       Assert.AreEqual(evalInteger 1 LessEqualsThan 2, Boolean(true))

    [<TestMethod>]
    member x.EvaluateArithmeticExpression() = 
       let idResolver id = failwith "Id resolver is just a placeholder and should not be called"
       let evalInteger left operator right = evaluateExpression (ArithmeticExpression(LiteralStatement(Integer(left)), operator ,LiteralStatement(Integer(right)))) idResolver
       Assert.AreEqual(evalInteger 1 Plus 1,Integer(2))
       Assert.AreEqual(evalInteger 1 Minus 1,Integer(0))
       Assert.AreEqual(evalInteger 2 Times 3,Integer(6))
       Assert.AreEqual(evalInteger 10 Divide 5,Integer(2))
       Assert.AreEqual(evalInteger 10 Divide 0,Integer(0))
       Assert.AreEqual(evalInteger 10 Divide 3,Integer(3))

    [<TestMethod>]
    member x.EvaluateNegationExpression() = 
       let idResolver id = failwith "Id resolver is just a placeholder and should not be called"
       let evalBoolean value  = evaluateExpression (NegationExpression(LiteralStatement(Boolean(value)))) idResolver
       Assert.AreEqual(evalBoolean true,Boolean(false))
       Assert.AreEqual(evalBoolean false,Boolean(true))
