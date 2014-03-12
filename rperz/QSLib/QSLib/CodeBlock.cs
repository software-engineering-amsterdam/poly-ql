using System;
using System.Collections.Generic;
using System.Linq;
using QSLib.Types;

namespace QSLib
{
    public class CodeBlock : IStatement
    {
        List<IStatement> _statements = new List<IStatement>();

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
                retVal += s.ToString() + "\r\n";
            }
            
            return retVal;
        }

        public bool CheckType(TypeChecker checker)
        {
            return this._statements.TrueForAll(i => i.CheckType(checker) == true);
        }

        public override bool Equals(object obj)
        {
            var temp = obj as CodeBlock;
            if (temp == null)
                return false;
            return this._statements.SequenceEqual<IStatement>(temp._statements, new ListEqualityComparer());
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public void CreateGUI(GUIBuilder guiBuilder)
        {
            this._statements.ForEach(x => x.CreateGUI(guiBuilder));
            guiBuilder.EndBlock();
        }
    }
}
