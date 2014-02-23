using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Conditions.Comparison
{
    class NotEquals : Condition
    {
        protected new String _operator = "!=";

        public NotEquals(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "!=";
        }   
    }
}
