using System.Collections.Generic;
using QSLib.AST.Expressions;
using QSLib.AST.Types;
using QSLib.Visitors;
using QSLib;
using System;
namespace QSLib.AST.Statements
{
    public class IfStatement : IStatement
    {
        private QSExpression _condition;
        private CodeBlock _code;
        private CodeBlock _elseBlock;
        private int _lineNr;

        #region Constructors
        public IfStatement(QSExpression con, CodeBlock code, CodeBlock elseBlock, int lineNr)
        {
            this._condition = con;
            this._code = code;
            this._elseBlock = elseBlock;
            this._lineNr = lineNr;
        }

        public IfStatement(QSExpression con, CodeBlock code, int lineNr)
        {
            this._condition = con;
            this._code = code;
            this._elseBlock = new CodeBlock(new List<IStatement>());
            this._lineNr = lineNr;
        }
        #endregion

        #region TypeCheckers
        public T Accept<T>(IStatementVisitor<T> checker)
        {
            return (T)checker.Visit(this);;
        }

        #endregion

        #region Getters
        public int Line
        {
            get
            {
                return this._lineNr;
            }
        }
        public QSExpression Condition
        {
            get
            {
                return this._condition;
            }
        }

        public CodeBlock If
        {
            get
            {
                return this._code;
            }
        }

        public CodeBlock Else
        {
            get
            {
                return this._elseBlock;
            }
        }
        #endregion

        internal QSType GetConditionType(TypeMemory memory)
        {
            return Condition.GetType(memory) ;
        }
    }
}
