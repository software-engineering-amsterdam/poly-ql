using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions;

namespace QSLib
{
    public class CodeBlock : IStatement
    {
        List<IStatement> _statements;

        public CodeBlock()
        {
        }

        public CodeBlock(List<IStatement> statements)
        {
            this._statements = statements;
        }

        public override string ToString()
        {
            String retVal = "";
            foreach (IStatement s in this._statements)
            {
                if(s != null)
                    retVal += s.ToString() + "\r\n";
            }
            return retVal;
        }

        public Type Type
        {
            get
            {
                return null;
            }
        }

        public bool CheckType()
        {
            bool retVal = true;
            foreach(IStatement stat in this._statements)
            {
                retVal &= stat.CheckType();
            }
            return retVal;
        }
    }
}
