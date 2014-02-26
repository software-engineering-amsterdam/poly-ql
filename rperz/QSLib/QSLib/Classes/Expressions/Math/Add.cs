using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Math
{
    public class Add : Binary_Expression  
    {
        public Add(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "+";
        }
    }
}
