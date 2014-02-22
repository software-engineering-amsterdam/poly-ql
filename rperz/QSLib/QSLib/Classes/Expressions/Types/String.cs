using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions;

namespace QSLib.Expressions.Types
{
    public class QSString : IExpression
    {
        private String _value;
        private String _id;

        public QSString(String id, String value)
        {
            this._id = id;
            this._value = value;
        }

        public QSString(String value)
        {
            this._value = value;
        }

        public Type CheckType()
        {
            return "".GetType();
        }

        public override string ToString()
        {
            return "\"" + this._value.ToString() + "\"" ;
        }
    }
}
