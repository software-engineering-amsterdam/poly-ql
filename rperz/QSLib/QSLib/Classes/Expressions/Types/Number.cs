using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Types
{
    class QSNumber : IExpression
    {
        private int _value;
        private String _id;

        public QSNumber(String id, int value)
        {
            this._id = id;
            this._value = value;
        }

        public QSNumber(int value)
        {
            this._value = value;
        }

        public Type CheckType()
        {
            return 1.GetType();
        }

        public override string ToString()
        {
            return this._value.ToString();
        }
    }
}
