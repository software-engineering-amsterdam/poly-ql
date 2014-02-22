using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Conditions.Binary
{
    class Or : Binary_Expression 
    {
        private String _operator = "||";

        public Or(IExpression a, IExpression b)
            : base(a, b)
        {
        }


    }
}
