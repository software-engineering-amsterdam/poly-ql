using QSLib.AST.Expressions.Literals;
using QSLib.AST.Expressions.Unary;
using QSLib;
using QSLib.Visitors;
using QSLib.AST.Expressions;
using QSLib.AST.Types;
using System;
namespace QSLib.AST.Statements
{
    public class ComputedQuestion : IStatement
    {
        private string _id;
        private string _text;
        private int _lineNr;
        private QSType _type;
        private QSExpression _expression;

        #region Constructors
        public ComputedQuestion(string text, string id, QSExpression expr, QSType type, int lineNr)
        {
            this._type = type;
            this._text = text;
            this._id = id;
            this._lineNr = lineNr;
            this._expression = expr;
        }
        #endregion

        #region Getters
        public string Id
        {
            get
            {
                return this._id;
            }
        }

        public QSExpression Expression
        {
            get
            {
                return this._expression;
            }
        }

        public string Text
        {
            get
            {
                return this._text.ToString();
            }
        }

        public QSType Type
        {
            get
            {
                return this._type;
            }
        }

        public int Line
        {
            get
            {
                return this._lineNr;
            }
        }
        #endregion

        #region TypeChecker
        public T Accept<T>(IStatementVisitor<T> checker)
        {
            return (T)checker.Visit(this);
        }
        #endregion
    }

}
