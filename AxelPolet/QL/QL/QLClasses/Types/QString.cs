using System;
using QL.TypeChecker;

namespace QL.QLClasses.Types
{
    public class QString : QBaseType
    {
        public override QBaseType GetType()
        {
            return this;
        }

        public override bool CheckType(ref QLException error)
        {
            return true;
        }

        public override bool IsCompatibleWith(QBaseType type)
        {
            return type.IsCompatibleWithQString(this);
        }

        public override bool IsCompatibleWithQString(QString type)
        {
            return true;
        }
    }
}
