using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.AST.Types;
namespace QSLib.Error
{
    class TypeMismatchError : QSError
    {
        private QSType _type1;
        private QSType _type2;

        public TypeMismatchError(QSType type1, QSType type2, int line)
        {
            // TODO: Complete member initialization
            this._type1 = type1;
            this._type2 = type2;
            this._line = line;
        }

        public override string ToString()
        {
            if(this._type1 == null || this._type2 == null)
                return "One of the variables has a null type" +
                                    "; line number: " + this._line;
            return this._type1.ToString() + " is not compatible with " + this._type2.ToString() +
                                "; line number: " + this._line;
        }

    }
}
