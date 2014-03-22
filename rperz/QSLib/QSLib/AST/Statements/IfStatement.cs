using System.Collections.Generic;
using QSLib.AST.Expressions;
using QSLib.Types;
using QSLib.Visitors;
using QSLib;
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
        public void Accept(IVisitor checker)
        {
            this._condition.Accept(checker);
            checker.Visit(this);
            this._code.Accept(checker);
            this._elseBlock.Accept(checker);
        }

        #endregion

        #region Object overrides
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

        public void CreateGUI(GUIBuilder guiBuilder)
        {
            guiBuilder.CreateIfStatement(this._condition, this._code, this._elseBlock);
        }

        internal bool IsConditionBoolean()
        {
            return this._condition.Type.IsBoolean();
        }

        internal QSType GetConditionType()
        {
            return this._condition.Type ;
        }
    }
}
