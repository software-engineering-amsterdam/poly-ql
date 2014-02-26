using System;
using Antlr4.Runtime;
using QL.Interfaces;
using QL.TypeChecker;

namespace QL.QLClasses.Types
{
    public abstract class QBaseType : ITypeChecker
    {
        public QLTokenInfo TokenInfo { get; set; }
        public IToken Token { set { TokenInfo = new QLTokenInfo(value); }}
               
        public new abstract QBaseType GetType();

        #region TypeChecker Implementation

        public abstract bool CheckType(ref QLException error);

        #endregion

        public virtual bool IsCompatibleWith(QBaseType type)
        {
            return false;
        }

        public virtual bool IsCompatibleWithQInt(QInt type)
        {
            return false;
        }

        public virtual bool IsCompatibleWithQBool(QBool type)
        {
            return false;
        }

        public virtual bool IsCompatibleWithQString(QString type)
        {
            return false;
        }
    }
}