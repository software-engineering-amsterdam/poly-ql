using System;
using QSLib.AST.Types;
using QSLib.Visitors;
namespace QSLib.AST.Expressions.Nullary
{
    public class Identifier : QSExpression

    {
        protected String _name;

        #region Constructors
        public Identifier(String name, int lineNr)
            : base(lineNr)
        {
            this._name = name;
        }

        #endregion

        public override T Accept<T>(IExpressionVisitor<T> checker)
        {
            return checker.Visit(this);
        }

        #region getters/setters
        public string Name
        {
            get
            {
                return this._name;
            }
        }

        public override QSType GetType(TypeMemory memory)
        {
            return memory.GetType(this._name);
        }

#endregion


    }
}
