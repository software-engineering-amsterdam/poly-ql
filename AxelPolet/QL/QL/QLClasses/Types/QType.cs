using QL.QLClasses.Values;

namespace QL.QLClasses.Types
{
    public abstract class QType : ASTBase
    {              
        public new abstract QType GetType();

        public abstract QValue UndefinedValue();

        #region Double Dispatch Implementation

        public virtual bool IsCompatibleWith(QType type)
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

        #endregion
    }
}