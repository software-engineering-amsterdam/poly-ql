using Antlr4.Runtime;

namespace QL
{
    public class ParserErrorListener : IAntlrErrorListener<IToken>
    {
        public delegate void ErrorHandler (string message);
        public ErrorHandler OnError { get; set; }

        public void SyntaxError(IRecognizer recognizer, IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            if(OnError != null)
                OnError(string.Format("Parser error at line {0}, char {1} --> {2}", line, charPositionInLine, msg));
        }
    }

    public class LexerErrorListener : IAntlrErrorListener<int>
    {
        public delegate void ErrorHandler(string message);
        public ErrorHandler OnError { get; set; }

        public void SyntaxError(IRecognizer recognizer, int symbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            if (OnError != null)
                OnError(string.Format("Lexer error at line {0}, char {1} --> {2}", line, charPositionInLine, msg));
        }
    }
}
