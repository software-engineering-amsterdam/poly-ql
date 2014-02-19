using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions;

namespace QSLib
{
    class Question
    {
        private Expression _val;
        private String _text;
        public Question(String text, Expression var)
        {
            this._text = text;
            this._val = var;
        }

    }
}
