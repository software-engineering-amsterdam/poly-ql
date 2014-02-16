using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Types
{
    class Bool : BaseType
    {
        private bool _value;
        private string _id;

        public override Type GetType()
        {
            return true.GetType();
        }
    }

    
}
