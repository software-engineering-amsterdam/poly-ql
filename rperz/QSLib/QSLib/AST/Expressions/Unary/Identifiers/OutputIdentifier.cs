using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Types;
using QSLib.Visitors;
namespace QSLib.AST.Expressions.Unary.Identifiers
{
    public class OutputIdentifier : Identifier
    {
        #region Constructors
        public OutputIdentifier(String name, QSExpression internalExpression, int lineNr)
            : base(name, internalExpression, lineNr)
        {
        }

        public OutputIdentifier(String name, QSType type, QSExpression internalExpression, int lineNr)
            : base(name, type, internalExpression, lineNr)
        {
        }
        #endregion

        #region TypeChecker
        public override void Accept(IVisitor checker)
        {
            this._internal.Accept(checker);
            checker.Visit(this);        
        }
        #endregion

        public override void CreateGUI(GUIBuilder guiBuilder)
        {
            this._value.CreateGUI(guiBuilder);
            guiBuilder.SetToOutput(this);
        }
    }
}
