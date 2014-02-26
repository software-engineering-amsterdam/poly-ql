using System;
using Antlr4.Runtime;
using QL.Interfaces;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions
{
    public abstract class ExpressionBase : ITypeChecker
    {
        public QLTokenInfo TokenInfo { get; set; }

        public IToken Token
        {
            set { TokenInfo = new QLTokenInfo(value);}
        }
        
        public abstract QBaseType GetResultType();
        public abstract ExpressionBase GetResult();

        #region TypeChecker Implementation

        public abstract bool CheckType(ref QLException error);

        #endregion
    }
}
