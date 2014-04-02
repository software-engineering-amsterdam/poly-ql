using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.AST.Types;
namespace QSLib.Error
{
    class UnaryOperatorTypeMismatch :QSError
    {
        private QSType _type1;
        private string _operator;

        public UnaryOperatorTypeMismatch(QSType type1, string op, int line)
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
