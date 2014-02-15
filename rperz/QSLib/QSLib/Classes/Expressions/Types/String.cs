using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions;

namespace QSLib.Expressions.Types
{
    class Str : BaseType
    {
        private String _value;
        private Identifier _id;

        public override Type GetType()
        {
            return "".GetType();
        }
    }
}
