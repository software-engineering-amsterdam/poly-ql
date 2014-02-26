using Antlr4.Runtime;

namespace QL.TypeChecker
{
    public class QLTokenInfo
    {
        public int TokenLine { get; set; }
        public int TokenColumn { get; set; }
        public string TokenText { get; set; }

        public QLTokenInfo(IToken token)
        {
            TokenLine = token.Line;
            TokenColumn = token.Column;
            TokenText = token.Text;
        }
    }
}
