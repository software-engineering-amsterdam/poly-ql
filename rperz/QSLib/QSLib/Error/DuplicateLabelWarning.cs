using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Error
{
    class DuplicateLabelWarning : QSError
    {
        private string _questionText;
        public DuplicateLabelWarning(string text, int line)
        {
            this._questionText = text;
            this._line = line;
        }

        public override string ToString()
        {
            return "Warning: duplicate questiontext : " + this._questionText + "; line number: " + this._line;
        }
    }
}
