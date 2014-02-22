using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Types
{
    class QSBoolean : IExpression
    {
        private bool _value;
        private string _id;

        public QSBoolean(String id, bool value)
        {
            this._id = id;
            this._value = value;
        }

        public QSBoolean(bool value)
        {
            this._value = value;
        }

        public Type CheckType()
        {
            return true.GetType();
        }

        public override string ToString()
        {
            return this._value.ToString();
        }
    }

    
}
