using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Types
{
    class QSNumber : Primary
    {
        private int _value;
        private String _id;
        private int _linenr;

        public QSNumber(String id, int value, int linenr)
        {
            this._id = id;
            this._value = value;
            this._linenr = linenr;
        }

        public QSNumber(int value, int linenr)
        {
            this._value = value;
            this._linenr = linenr;
        }

        public override Type Type
        {
            get
            {
                return 1.GetType();
            }
        }

        public override string ToString()
        {
            return this._value.ToString();
        }
    }
}
