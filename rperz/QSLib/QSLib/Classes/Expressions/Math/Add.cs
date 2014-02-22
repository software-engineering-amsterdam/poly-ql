using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Math
{
    class Add : Binary_Expression  
    {
        protected String _operator = "+";

        public Add(IExpression a, IExpression b)
            : base(a, b)
        {
        }
    }
}
