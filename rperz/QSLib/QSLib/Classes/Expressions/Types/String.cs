using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions;

namespace QSLib.Expressions.Types
{
    public class QSString : Primary
    {
        private String _value;
        private String _id;
        private int _linenr;

        public QSString(String id, String value, int linenr)
        {
            this._id = id;
            this._value = value;
            this._linenr = linenr;
        }

        public QSString(String value, int linenr)
        {
            this._value = value;
            this._linenr = linenr;
        }

        public override Type Type
        {
            get
            {
                return "".GetType();
            }
        }

        public override string ToString()
        {
            return this._value.ToString();
        }
    }
}
