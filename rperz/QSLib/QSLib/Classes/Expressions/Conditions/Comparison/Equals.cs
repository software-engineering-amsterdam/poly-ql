using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Conditions.Comparison
{
    class Equals : Condition
    {
        public Equals(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "==";
        }   
    }
}
