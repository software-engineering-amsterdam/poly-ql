using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Error
{
    class OperatorTypeMismatch : QSError 
    {
        private string _questionText;
        private Types.QSType _type1;
        private Types.QSType _type2;
        private string _operator;

        public OperatorTypeMismatch(Types.QSType type1, Types.QSType type2, string op, int line)
        {
            this._type1 = type1;
            this._type2 = type2;
            this._operator = op;
            this._line = line;
        }

        public override string ToString()
        {
            return "Operator " + this._operator + " cannot be used with types " + this._type1.ToString() + " and " +
                            this._type2.ToString() + "; line number: " + this._line;
        }
    }
}
