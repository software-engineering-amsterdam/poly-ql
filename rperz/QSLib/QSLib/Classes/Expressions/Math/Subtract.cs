using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Math
{
    class Subtract : Binary_Expression 
    {
        protected String _operator = "-";
        public Subtract(IExpression a, IExpression b)
            : base(a, b)
        {
        }   
    }
}
