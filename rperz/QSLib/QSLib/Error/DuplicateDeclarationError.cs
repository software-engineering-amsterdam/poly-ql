using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Error
{
    class DuplicateDeclarationError : QSError
    {
        private string _name;
        public DuplicateDeclarationError(string name, int line)
        {
            this._name = name;
            this._line = line;
        }
        public override string ToString()
        {
            return "Duplicate declaration of " + this._name + "; line number: " + this._line;
        }
    }
}
