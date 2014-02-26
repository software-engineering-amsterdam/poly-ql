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

        public override bool Equals(object obj)
        {
            bool retVal = true;
            var temp = obj as CodeBlock;
            if (temp == null)
                return false;
            if (this._statements != null && temp._statements != null)
            {
                if (this._statements.Count != temp._statements.Count)
                    return false;
                for (int i = 0; i < this._statements.Count; i++)
                {
                    retVal &= this._statements[i].Equals(temp._statements[i]);
                }
            }
            return retVal;
        }
    }
}
