using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Math
{
    class Subtract : Binary_Expression 
    {
        public Subtract(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "-";
        }   
    }
}
