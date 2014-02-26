using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Types
{
    public class NullObject : Primary
    {

        public override Type Type
        {
            get
            {
                // object needed to avoid errors on null type
                return new NullObject().GetType();
            }
        }
    }
}
