using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Errors
{
    class TypeException : Exception
    {
        public TypeException(string message) : base(message)
        {

        }
    }
}
