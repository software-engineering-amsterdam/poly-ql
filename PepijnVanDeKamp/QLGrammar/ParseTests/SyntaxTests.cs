using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using Microsoft.FSharp.Collections;

namespace ParseTests
{
    [TestClass]
    public class SyntaxTests
    {
        [TestMethod]
        public void EmptyFormTest()
        {
            ////Setup
            //var _statements = ListModule.OfSeq(new List<QL.Grammar.Statement>());
            //QL.Grammar.Form _form = new QL.Grammar.Form("TestForm", _statements);

            ////Execute
            //var _formParsed = QL.Parsing.Parse("form TestForm{ }");

            ////Verify
            //Assert.AreEqual(_form, _formParsed);
        }

        [TestMethod]
        public void FormWithOneQuestionTest()
        {
            
            //QL.Grammar.Statement.QuestionStatement _questionstatement = new QL.Grammar.Statement.QuestionStatement();

            ////Item = new QL.Grammar.Question("hasSoldHouse", "Dit is \\\" mijn vraag?", QL.Grammar.QuestionType.QL_Boolean)};
            ////QL.Grammar.Statement _statement = ;

            
           

            ////Setup
            //var _questions = ListModule.OfSeq(new List<QL.Grammar.Statement>(){_question});
            //QL.Grammar.Form _form = new QL.Grammar.Form("TestForm", _questions);

            ////Execute
            //var _formParsed = QL.Parsing.Parse("form TestForm { hasSoldHouse: \"Dit is \\\" mijn vraag?\" boolean }");

            ////Verify
            //Assert.AreEqual(_form, _formParsed);
        }

        [TestMethod]
        public void FormWithMoreQuestionsTest()
        {
            ////Setup
            //QL.Grammar.Question _question = new QL.Grammar.Question("hasSoldHouse1", "Dit is mijn vraag 1?", QL.Grammar.QuestionType.QL_Boolean);
            //QL.Grammar.Question _question2 = new QL.Grammar.Question("hasSoldHouse2", "Dit is mijn vraag 2?", QL.Grammar.QuestionType.QL_Boolean);
            //QL.Grammar.Question _question3 = new QL.Grammar.Question("hasSoldHouse3", "Dit is mijn vraag 3?", QL.Grammar.QuestionType.QL_Boolean);
            
            //var _questions = ListModule.OfSeq(new List<QL.Grammar.Question>() { _question, _question2,_question3 });
            //QL.Grammar.Form _form = new QL.Grammar.Form("TestForm", _questions);

            ////Execute
            //var _formParsed = QL.Parsing.Parse("form TestForm { \n hasSoldHouse1: \"Dit is mijn vraag 1?\" boolean hasSoldHouse2: \"Dit is mijn vraag 2?\" boolean hasSoldHouse3: \"Dit is mijn vraag 3?\" boolean }");

            ////Verify
            //Assert.AreEqual(_form.ToString(), _formParsed.ToString());
        }
    }
}
