using System;
using System.Collections.Generic;
using System.Linq;

namespace QSLib
{
    public class CodeBlock : IStatement
    {
        List<IStatement> _statements = new List<IStatement>();

        #region Constructors
        public CodeBlock()
        {
        }

        public CodeBlock(List<IStatement> statements)
        {
            this._statements = statements;
        }
        #endregion

        #region TypeChecker
        public void Check(TypeChecker checker)
        {
            checker.Check(this);
        }

        public void CheckStatements(TypeChecker checker)
        {
            if(this._statements.Count > 0)
                this._statements.ForEach(i => i.Check(checker));
        }
        #endregion

        #region Object overrides
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

        public override string ToString()
        {
            String retVal = "";
            foreach (IStatement s in this._statements)
            {
                retVal += s.ToString() + "\r\n";
            }

            return retVal;
        }
        #endregion

        public void CreateGUI(GUIBuilder guiBuilder)
        {
            this._statements.ForEach(x => x.CreateGUI(guiBuilder));
            guiBuilder.EndBlock();
        }

    }
}
