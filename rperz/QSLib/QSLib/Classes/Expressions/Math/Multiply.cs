using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Math
{
    public class Multiply : Binary_Expression 
    {
        public Multiply(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "*";
        }   
    }
}
