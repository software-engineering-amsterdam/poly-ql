using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Conditions.Binary
{
    class And : Binary_Expression 
    {
        protected String _operator = "&&";

        public And(IExpression a, IExpression b)
            : base(a, b)
        {
        }
    }
}
