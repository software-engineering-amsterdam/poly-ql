using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.AST.Types;
namespace QSLib.Error
{
    class OperatorTypeMismatch : QSError 
    {
        private QSType _type1;
        private QSType _type2;
        private string _operator;

        public OperatorTypeMismatch(QSType type1, QSType type2, string op, int line)
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
