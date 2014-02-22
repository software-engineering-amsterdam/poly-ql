using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib
{
    public class CodeBlock
    {
        List<IStatement> _statements;

        public CodeBlock(List<IStatement> statements)
        {
            this._statements = statements;
        }

        public override string ToString()
        {
            String retVal = "";
            foreach (IStatement s in this._statements)
            {
                retVal += s.ToString() + "\r\n";
            }
            return retVal;
        }


    }
}
