using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Error
{
    class UnaryOperatorTypeMismatch :QSError
    {
        private string _questionText;
        private Types.QSType _type1;
        private string _operator;

        public UnaryOperatorTypeMismatch(Types.QSType type1, string op, int line)
        {
            // TODO: Complete member initialization
            this._type1 = type1;
            this._operator = op;
            this._line = line;
        }

        public override string ToString()
        {
            return "Operator " + this._operator + " cannot be used with type " + this._type1.ToString() +
                            "; line number: " + this._line;
        }
    }
}
