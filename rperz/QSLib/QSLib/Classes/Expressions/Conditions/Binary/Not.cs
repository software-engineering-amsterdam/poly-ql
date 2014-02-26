using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions.Types;
using QSLib.Errors;
namespace QSLib.Expressions.Conditions.Binary
{
    class Not : Condition
    {

        public Not(IExpression left, int linenr)
            : base(left, linenr)
        {
            base._operator = "!";
        }

        public override bool CheckType()
        {
            bool retVal = true;
            retVal &= this._left.CheckType();
            retVal &= (this._left.Type.Equals(true.GetType()));
            return retVal;
        }

        public new Type Type
        {
            get
            {
                return true.GetType();
            }
        }
    }
}
