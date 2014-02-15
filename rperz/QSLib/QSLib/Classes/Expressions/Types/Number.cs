using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Types
{
    class Number : BaseType
    {
        private int _value;
        private Identifier _id;

        public override Type GetType()
        {
            return 1.GetType();
        }
    }
}
