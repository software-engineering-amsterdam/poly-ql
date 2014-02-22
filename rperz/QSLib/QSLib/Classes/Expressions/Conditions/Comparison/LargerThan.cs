using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Conditions.Comparison
{
    class LargerThan : Binary_Expression 
    {
        protected String _operator = ">";

        public LargerThan(IExpression a, IExpression b)
            : base(a, b)
        {
        }   
    }
}
