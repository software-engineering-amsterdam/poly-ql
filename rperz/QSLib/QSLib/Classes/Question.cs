using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions;
using QSLib.Expressions.Types;
namespace QSLib
{
    public class Question : IStatement
    {
        private IExpression _val;
        private QSString _text;
        private int _linenr;
        public Question(QSString text, IExpression var, int linenr)
        {
            this._text = text;
            this._val = var;
            this._linenr = linenr;
        }

        public override string ToString()
        {
            return this._text.ToString()  + this._val.ToString();
        }

        public Type Type
        {
            get
            {
                return null;
            }
        }
        public bool CheckType()
        {
            return this._val.CheckType();
        }
    }
}
