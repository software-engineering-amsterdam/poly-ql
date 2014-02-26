using System.Collections.Generic;
using System.IO;
using System.Text;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using QL.QLClasses;
using QL.TypeChecker;

namespace QL
{
    public class QLController
    {
        public Questionnaire AST { get; private set; }
        
        public List<string> LexerErrors { get; private set; }
        public List<string> ParserErrors { get; private set; }
        
        public QLIdentifiers Identifiers { get; private set; }       
        public QLTypeChecker TypeChecker { get; private set; }


        public QLController()
        {
            LexerErrors = new List<string>();
            ParserErrors = new List<string>();
            Identifiers = new QLIdentifiers();
            TypeChecker = new QLTypeChecker();
        }

        public void Run(string inputString)
        {
            MemoryStream inputStream = new MemoryStream(Encoding.UTF8.GetBytes(inputString ?? ""));

            AntlrInputStream antlrInputStream = new AntlrInputStream(inputStream);
            QLLexer lexer = new QLLexer(antlrInputStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLParser parser = new QLParser(tokens);

            lexer.RemoveErrorListeners();
            parser.RemoveErrorListeners();

            lexer.AddErrorListener(new LexerErrorListener() { OnError = LexerErrors.Add });
            parser.AddErrorListener(new ParserErrorListener() { OnError = ParserErrors.Add });

            IParseTree parseTree = parser.questionnaire();
            AST = parser.theQuestionnaire;
        }
    }
}
