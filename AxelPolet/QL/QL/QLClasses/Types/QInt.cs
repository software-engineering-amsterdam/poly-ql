using QL.TypeChecker;

namespace QL.QLClasses.Types
{
    public class QInt : QBaseType
    {
        public override QBaseType GetType()
        {
            return this;
        }

        public override bool IsCompatibleWith(QBaseType type)
        {
            return type.IsCompatibleWithQInt(this);
        }

        public override bool IsCompatibleWithQInt(QInt type)
        {
            return true;
        }
        
        public override bool CheckType(ref QLException error)
        {
            return true;
        }
    }
}
