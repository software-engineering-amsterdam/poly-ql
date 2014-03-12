using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions;
namespace QSLib.Statements
{
    public class IfStatement : IStatement
    {
        private IExpression _condition;
        private CodeBlock _code;
        private CodeBlock _elseBlock;
        private int _lineNr;

        public IfStatement(IExpression con, CodeBlock code, CodeBlock elseBlock, int lineNr)
        {
            this._condition = con;
            this._code = code;
            this._elseBlock = elseBlock;
            this._lineNr = lineNr;
        }

        public IfStatement(IExpression con, CodeBlock code, int lineNr)
        {
            this._condition = con;
            this._code = code;
            this._elseBlock = new CodeBlock(new List<IStatement>());
            this._lineNr = lineNr;
        }

        public bool CheckType(TypeChecker checker)
        {
            bool retVal = true;

            retVal &= this._condition.CheckType(checker);

            if (!this._condition.Type.IsBoolean())
            {
                checker.ReportTypeMismatch(this._condition.Type, "if-statement", this._lineNr);
                retVal = false;
            }

            retVal &= this._code.CheckType(checker);
            retVal &= this._elseBlock.CheckType(checker);

            return retVal;
        }

        public override bool Equals(object obj)
        {
            var comp = obj as IfStatement;
            if (comp == null)
                return false;

            // check if all elements are equal
            return this._condition.Equals(comp._condition) &&
                    this._code.Equals(comp._code) &&
                    this._elseBlock.Equals(comp._elseBlock);
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public void CreateGUI(GUIBuilder guiBuilder)
        {
            guiBuilder.CreateIfStatement(this._condition, this._code, this._elseBlock);
        }
    }
}
