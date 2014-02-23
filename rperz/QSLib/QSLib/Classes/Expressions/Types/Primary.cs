using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Types
{
    public abstract class Primary : IExpression
    {
        public bool CheckType()
        {
            return true;
        }

        public abstract Type Type
        {
            get;
        }
    }
}
