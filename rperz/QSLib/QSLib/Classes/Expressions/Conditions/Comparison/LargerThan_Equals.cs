using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Conditions.Comparison
{
    class LargerThan_Equals : Binary_Expression 
    {
        protected String _operator = ">=";
        public LargerThan_Equals(IExpression a, IExpression b)
            : base(a, b)
        {
        }   
    }
}
