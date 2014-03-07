﻿using QSLib.Types;
namespace QSLib.Expressions.Binary
{
    class LargerThan : Binary_Expression
    {
        public LargerThan(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = ">";
        }

        public override QSType Type
        {
            get { return new BoolType(); }
        }
    }
}