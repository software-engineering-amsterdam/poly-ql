using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions;
using QSLib.Expressions.Types;
namespace QSLib
{
    public class Question : IExpression, IStatement
    {
        private IExpression _val;
        private QSString _text;
        public Question(QSString text, IExpression var)
        {
            this._text = text;
            this._val = var;
        }

        public override string ToString()
        {
            return this._text.ToString()  + this._val.ToString();
        }


        public Type CheckType()
        {
            // not yet implemented
            return null;
        }
    }
}
