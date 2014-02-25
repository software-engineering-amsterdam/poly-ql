using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions.Conditions;

namespace QSLib.Expressions.Types
{
    class QSBoolean : Primary 
    {
        private bool _value;
        private string _id;
        private int _linenr;

        public QSBoolean(String id, bool value, int linenr)
        {
            this._id = id;
            this._value = value;
            this._linenr = linenr;
        }

        public QSBoolean(bool value, int linenr)
        {
            this._value = value;
            this._linenr = linenr;
        }

        public override Type Type
        {
            get
            {
                return true.GetType();
            }
        }

        public override string ToString()
        {
            return this._value.ToString();
        }
    }

    
}
