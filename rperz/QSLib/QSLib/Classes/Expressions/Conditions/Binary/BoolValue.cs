using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Conditions.Binary
{
    class BoolValue : Condition
    {
        public BoolValue(IExpression left, int linenr)
            : base(left, linenr)
        {
            base._operator = "";
        }

    }
}
