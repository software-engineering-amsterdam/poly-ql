using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Error
{
    class UndeclaredVariableError : QSError 
    {
        private string _name;
        public UndeclaredVariableError(string name, int line)
        {
            this._name = name;
            this._line = line;
        }

        public override string ToString()
        {
            return "Variable " + this._name + " is used before being declared; line number: " + this._line;
        }
    }
}
