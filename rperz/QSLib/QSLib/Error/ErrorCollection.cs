using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Error
{
    class ErrorCollection : List<QSError>
    {
        private string _noErrors = "No errors found!";
        public override string ToString()
        {
            string output = "";
            foreach (QSError error in this)
            {
                output += error.ToString() + "\r\n";
            }
            if (output.Equals(""))
                return this._noErrors;
            return output;
        }
    }
}
