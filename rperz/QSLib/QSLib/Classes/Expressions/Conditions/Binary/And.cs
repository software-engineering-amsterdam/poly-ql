using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib;
namespace QSLib.Expressions.Conditions.Binary
{
    class And : Condition
    {
        public And(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "&&";
        }
    }
}
