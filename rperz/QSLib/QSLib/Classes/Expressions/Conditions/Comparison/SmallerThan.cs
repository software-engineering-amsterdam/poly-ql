using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Conditions.Comparison
{
    class SmallerThan : Binary_Expression 
    {
        protected String _operator = "<";
        public SmallerThan(IExpression a, IExpression b)
            : base(a, b)
        {
        }   
    }
}
