using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Antlr4.Runtime;
using QSLib;
using Antlr4.Runtime.Tree;
using QSLib.Types;
using QSLib.AST;
using QSLib.AST.Expressions;
using QSLib.AST.Expressions.Literals;
using QSLib.AST.Expressions.Binary;
using QSLib.AST.Expressions.Unary;
using QSLib.AST.Expressions.Unary.Identifiers;
using QSLib.AST.Statements;
using QSLib.Visitors;
namespace ParserTest
{
    /// <summary>
    /// Summary description for ParserTest
    /// </summary>
    [TestClass]
    public class ParserTest
    {
        public ParserTest()
        {
            //
            // TODO: Add constructor logic here
            //
        }

        private TestContext testContextInstance;

        /// <summary>
        ///Gets or sets the test context which provides
        ///information about and functionality for the current test run.
        ///</summary>
        public TestContext TestContext
        {
            get
            {
                return testContextInstance;
            }
            set
            {
                testContextInstance = value;
            }
        }

        #region Additional test attributes
        //
        // You can use the following additional attributes as you write your tests:
        //
        // Use ClassInitialize to run code before running the first test in the class
        // [ClassInitialize()]
        // public static void MyClassInitialize(TestContext testContext) { }
        //
        // Use ClassCleanup to run code after all tests in a class have run
        // [ClassCleanup()]
        // public static void MyClassCleanup() { }
        //
        // Use TestInitialize to run code before running each test 
        // [TestInitialize()]
        // public void MyTestInitialize() { }
        //
        // Use TestCleanup to run code after each test has run
        // [TestCleanup()]
        // public void MyTestCleanup() { }
        //
        #endregion

        private Form init_parse(string text)
        {
            AntlrInputStream stream = new AntlrInputStream(text);
            QSLexer lex = new QSLexer(stream);
            CommonTokenStream tokens = new CommonTokenStream(lex);
            QSParser parser = new QSParser(tokens);
            IParseTree tree = parser.form();
            MyListener listener = new MyListener(parser);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.Walk(listener, tree);
            return listener.Root;
        }

        private HashSet<KeyValuePair<String, Form>> conditionTest = new HashSet<KeyValuePair<string, Form>>();

        [TestMethod]
        public void TestConditionalIf()
        {
            string q1 = "\"Whats the question?\"";
            string q2 = "\"Oh is that it?\"";
            string code = "form \r\n{ \r\n" + q1 + " bAnswer : Boolean\r\nif(bAnswer)\r\n { \r\n" + q2 + " bYesNo : Boolean \r\n} \r\n}";
            Form parse = init_parse(code);
            Identifier bYesNo = new InputIdentifier("bYesNo", new BoolType(), 1);
            Identifier bAnswer = new InputIdentifier("bAnswer", new BoolType(), 1);
            Question q2o = new Question(new QSString(q2,1), bYesNo, 1);
            Question q1o = new Question(new QSString(q1,1), bAnswer, 1);
            List<IStatement> ilist = new List<IStatement>();
            ilist.Add(q2o);
            CodeBlock cb = new CodeBlock(ilist);
            Identifier bAnswerUndec = new Identifier("bAnswer", 1);
            IfStatement ifstat = new IfStatement(bAnswerUndec, cb, 1);
            List<IStatement> ilist2 = new List<IStatement>();
            ilist2.Add(q1o);
            ilist2.Add(ifstat);
            CodeBlock cb2 = new CodeBlock(ilist2);
            Form construct = new Form(cb2, 1);
            TypeChecker.StartVisit(parse);
            TypeChecker.StartVisit(construct);
            Assert.AreEqual(construct, parse);
        }

        [TestMethod]
        public void TestConditionalIfElse()
        {
            
            string q1 = "\"Whats the question?\"";
            string q2 = "\"Oh is that it?\"";
            string q3 = "\"Last Question?\"";
            string code = "form \r\n{ \r\n" + q1 + " bAnswer : Boolean\r\nif(bAnswer)\r\n { \r\n" + q2 + " bYesNo : Boolean \r\n} else { " + q3 + " bAnswer } \r\n}";
            Form parse = init_parse(code);
            Identifier bYesNo = new InputIdentifier("bYesNo", new BoolType(), 1);
            Identifier bAnswer = new InputIdentifier("bAnswer", new BoolType(), 1);

            // now we need to set the type and the declaration
            Identifier bAnswerUndec = new Identifier("bAnswer", 1);
            Identifier bAnswerUndec2 = new Identifier("bAnswer", 1);

            Question q2o = new Question(new QSString(q2, 1), bYesNo, 1);
            Question q1o = new Question(new QSString(q1, 1), bAnswer, 1);
            Question q3o = new Question(new QSString(q3, 1), bAnswerUndec2, 1);


            List<IStatement> ilist = new List<IStatement>();
            ilist.Add(q2o);
            CodeBlock cb = new CodeBlock(ilist);
            List<IStatement> ilist3 = new List<IStatement>();
            ilist3.Add(q3o);
            CodeBlock cb3 = new CodeBlock(ilist3);

            IfStatement ifstat = new IfStatement(bAnswerUndec, cb, cb3, 1);

            List<IStatement> ilist2 = new List<IStatement>();
            ilist2.Add(q1o);
            ilist2.Add(ifstat);

            CodeBlock cb2 = new CodeBlock(ilist2);
            
            Form construct = new Form(cb2, 1);
            TypeChecker.StartVisit(construct);
            TypeChecker.StartVisit(parse);
            Assert.AreEqual(construct, parse);
        }


        [TestMethod]
        public void TestConditionNotBoolInt()
        {
            CheckCondition("Integer");
        }

        [TestMethod]
        public void TestConditionNotBoolString()
        {
            CheckCondition("String");
        }

        [TestMethod]
        public void TestUndeclared()
        {
            string q1 = "\"Whats the question?\"";
            string code = "form \r\n{ \r\n" + q1 + " bAnswer \r\n}";
            Form parse = init_parse(code);
            Assert.AreEqual(false, TypeChecker.StartVisit(parse).Result);
        }

        [TestMethod]
        public void TestBooleanOperators()
        {
            string[] test = new string[] { "&&", "||" };
            foreach (string s in test)
            {
                TestOperatorType(s, "Boolean", "Boolean", true);
            }
        }

        [TestMethod]
        public void TestIncorrectOperandsBool()
        {
            string[] test = new string[] { "&&", "||" };
            string[] operands = new string[] { "Integer", "String" };
            foreach (string op in test)
            {
                foreach (string operand in operands)
                {
                    TestOperatorType(op, operand, "Boolean", false);
                }
            }
        }

        [TestMethod]
        public void TestMathOperators()
        {
            string[] test = new string[] { "+", "-", "*", "/" };
            foreach (string s in test)
            {
                TestOperatorType(s, "Integer", "Integer", true);
            }
        }

        [TestMethod]
        public void TestIncorrectOperandsMath()
        {
            string[] test = new string[] { "+", "-", "*", "/" };
            string[] operands = new string[] { "Boolean", "String" };
            foreach (string op in test)
            {
                foreach (string operand in operands)
                {
                    TestOperatorType(op, operand, "Integer", false);
                }
            }
        }

        [TestMethod]
        public void TestAssociativityDivide()
        {
            string q1 = "\"Whats the question?\"";
            string q2 = "\"Oh is that it?\"";
            string code = "form \r\n{ \r\n" + q1 + " iAnswer : Integer  " + q2 + " iDivAnswer = iAnswer + iAnswer / 2 : Integer \r\n}";
            Identifier iAnswer = new InputIdentifier("iAnswer", new IntegerType(), 1);
            Question q1o = new Question(new QSString(q1, 1), iAnswer, 1);
            Identifier iAnswer2 = new Identifier("iAnswer", 1);
            Identifier iAnswer3 = new Identifier("iAnswer", 1);
            Identifier iAnswerDiv = new Identifier("iDivAnswer", new IntegerType(), new Add(iAnswer2, new Divide(iAnswer3, new QSNumber(2, 1), 1), 1), 1);
            Question q2o = new Question(new QSString(q2, 1), iAnswerDiv, 1);
            List<IStatement> ilist = new List<IStatement>();
            ilist.Add(q1o);
            ilist.Add(q2o);
            Form f = new Form(new CodeBlock(ilist), 1);
            Form parse = init_parse(code);
            TypeChecker.StartVisit(f);
            TypeChecker.StartVisit(parse);
            Assert.AreEqual(f, parse);
        }

        [TestMethod]
        public void TestAssociativityMultiply()
        {
            string q1 = "\"Whats the question?\"";
            string q2 = "\"Oh is that it?\"";
            string code = "form \r\n{ \r\n" + q1 + " iAnswer : Integer  " + q2 + " iDivAnswer = iAnswer + iAnswer * 2 : Integer \r\n}";
            Identifier iAnswer = new InputIdentifier("iAnswer", new IntegerType(), 1);
            Question q1o = new Question(new QSString(q1, 1), iAnswer, 1);
            Identifier iAnswer2 = new Identifier("iAnswer", 1);
            Identifier iAnswer3 = new Identifier("iAnswer", 1);
            Identifier iAnswerDiv = new Identifier("iDivAnswer", new IntegerType(), new Add(iAnswer2, new Multiply(iAnswer3, new QSNumber(2, 1), 1), 1), 1);

            Question q2o = new Question(new QSString(q2, 1), iAnswerDiv, 1);
            List<IStatement> ilist = new List<IStatement>();
            ilist.Add(q1o);
            ilist.Add(q2o);
            Form f = new Form(new CodeBlock(ilist), 1);
            Form parse = init_parse(code);
            TypeChecker.StartVisit(f);
            TypeChecker.StartVisit(parse);
            Assert.AreEqual(f, parse);
        }

        public void TestOperatorType(string op, string typeOperand, string typeAssign, bool expected)
        {
            string q1 = "\"Whats the question?\"";
            string q2 = "\"Oh is that it?\"";
            string code = "form \r\n{ \r\n" + q1 + " bAnswer : " + typeOperand + "  " + q2 + " bIntAnswer = bAnswer " + op + " bAnswer : "+ typeAssign + " \r\n}";
            Form parse = init_parse(code);
            Assert.AreEqual(expected, TypeChecker.StartVisit(parse).Result);
        }

        private void CheckCondition(String type)
        {
            string q1 = "\"Whats the question?\"";
            string q2 = "\"Oh is that it?\"";
            string code = "form \r\n{ \r\n" + q1 + " bAnswer : " + type + "\r\nif(bAnswer)\r\n { \r\n" + q2 + " bYesNo : Boolean \r\n} \r\n}";
            Form parse = init_parse(code);
            Assert.AreEqual(false, TypeChecker.StartVisit(parse).Result);
        }



    }
}
