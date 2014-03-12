using QL.TypeChecker;

namespace QL.QLClasses.Types
{
    public class QBool : QType
    {
        public override QType GetType()
        {
            return this;
        }

        public override string ToString()
        {
            return "QBool";
        }

        #region TypeChecker Implementation

        public override bool CheckType(QLTypeErrors errors)
        {
            return true;
        }

        #endregion

        #region Double Dispatch Implementation

        public override bool IsCompatibleWith(QType type)
        {
            return type.IsCompatibleWithQBool(this);
        }

        public override bool IsCompatibleWithQBool(QBool type)
        {
            return true;
        }

        #endregion
    }
}
