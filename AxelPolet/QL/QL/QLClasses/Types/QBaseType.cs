namespace QL.QLClasses.Types
{
    public abstract class QBaseType : ASTBase
    {              
        public new abstract QBaseType GetType();

        #region Double Dispatch Implementation

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

        #endregion
    }
}