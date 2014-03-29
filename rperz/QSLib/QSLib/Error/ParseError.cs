using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Error
{
    public class ParseError : QSError 
    {
        public ParseError(int line)
        {
            this._line = line;
        }

        public override string ToString()
        {
            return "Type checker has found a parse error; line number: " + this._line;
        }
    }
}
