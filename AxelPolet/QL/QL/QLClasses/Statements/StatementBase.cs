using Antlr4.Runtime;
using QL.Interfaces;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public abstract class StatementBase : ITypeChecker
    {
        public QLTokenInfo TokenInfo { get; set; }

        public IToken Token 
        {
            set { TokenInfo = new QLTokenInfo(value);}
        }

        #region TypeChecker Implementation

        public abstract bool CheckType(ref QLException error);

        #endregion
    }
}
