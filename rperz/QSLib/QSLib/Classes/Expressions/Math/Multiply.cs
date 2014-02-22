﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Math
{
    class Multiply : Binary_Expression 
    {
        protected String _operator = "*";
        public Multiply(IExpression a, IExpression b)
            : base(a, b)
        {
        }   
    }
}