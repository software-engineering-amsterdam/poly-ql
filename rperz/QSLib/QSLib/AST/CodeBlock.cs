using System;
using System.Collections.Generic;
using System.Linq;
using QSLib.AST.Statements;
using QSLib.Visitors;

namespace QSLib.AST
{
    public class CodeBlock
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
        public T Accept<T>(IStatementVisitor<T> checker)
        {
            return (T)checker.Visit(this);
        }

        #endregion

        public List<IStatement> Statements
        {
            get
            {
                return this._statements;
            }
        }

    }
}
