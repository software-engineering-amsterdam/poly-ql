using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Math
{
    class Divide : Binary_Expression 
    {
        protected String _operator = "/";
        public Divide(IExpression a, IExpression b)
            : base(a, b)
        {
        }
    }
}
