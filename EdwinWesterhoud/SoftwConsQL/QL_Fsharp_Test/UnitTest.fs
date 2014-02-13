namespace QL_Fsharp_Test

open System
open Microsoft.VisualStudio.TestTools.UnitTesting
open Program
open QL_Grammar

[<TestClass>]
type UnitTest() = 
    [<TestMethod>]
    member x.TestMethod1 () = 
        let text = "1+1"
        let tree = ArithmeticOp(ArithmeticType(Int(1)), Plus, ArithmeticType(Int(1)))
        let result = parse text
        Assert.AreEqual(tree, result)
