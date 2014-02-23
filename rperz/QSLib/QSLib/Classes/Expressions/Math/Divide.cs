using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Math
{
    class Divide : Binary_Expression 
    {
        public Divide(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "/";
        }
    }
}
