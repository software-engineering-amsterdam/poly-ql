using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Types
{
    class Boolean : BaseType
    {
        private bool _value;
        private Identifier _id;

        public override Type GetType()
        {
            return true.GetType();
        }
    }

    
}
