using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Conditions
{
    public class Conditional_Expression
    {

        public virtual bool Equals(object obj)
        {
            return this.ToString().Equals(obj.ToString());
        }
    }
}
