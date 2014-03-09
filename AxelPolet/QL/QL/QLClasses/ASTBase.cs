using Antlr4.Runtime;
using QL.TypeChecker;

namespace QL.QLClasses
{
    public abstract class ASTBase
    {
        public QLTokenInfo TokenInfo { get; set; }
        public IToken AntlrToken
        {
            set { TokenInfo = new QLTokenInfo(value); }
        }

        public abstract bool CheckType(QLTypeErrors errors);  
    }
}
