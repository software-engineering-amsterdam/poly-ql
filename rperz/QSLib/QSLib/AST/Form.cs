using System;
using QSLib.Visitors;

namespace QSLib.AST
{
    public class Form
    {
        private CodeBlock _code;
        private int _lineNr;

        #region Constructors
        public Form(CodeBlock code, int lineNr)
        {
            this._code = code;
            this._lineNr = lineNr;
        }
        #endregion

        #region Getters

        public CodeBlock Code
        {
            get
            {
                return _code;
            }
        }
        #endregion

        #region TypeChecker
        public T Accept<T>(IStatementVisitor<T> checker)
        {
            return (T)checker.Visit(this);;
        }
        #endregion

    }
}
