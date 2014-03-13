using QL.Interpreter;
using QL.Interpreter.Controls;
using QL.QLClasses.Expressions;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public class Question : StatementBase
    {
        protected string Name;
        protected string Label;
        protected QType Type;
        protected QLMemory Memory;

        public Question(QLMemory memory, string name, string label, QType type)
        {
            Memory = memory;
            Name = name;
            Label = label;
            Type = type;
        }

        #region TypeChecker Implementation

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (Memory.IsDeclared(Name))
            {
                typeErrors.ReportError(new QLTypeError
                {
                    Message = string.Format("(Question) Identifier '{0}' is already defined!", Name),
                    TokenInfo = TokenInfo
                });
                return false;
            }

            Memory.Declare(Name, Type);

            if (Memory.LabelIsDeclared(Label))
            {
                typeErrors.ReportError(new QLTypeError
                {
                    IsWarning = true,
                    Message = string.Format("(Question) Declared label already exists: '{0}'", Label),
                    TokenInfo = TokenInfo
                });
            }

            Memory.DeclareLabel(Label);

            DeclareValue();
            
            return true;
        }

        protected virtual void DeclareValue()
        {
            Memory.DeclareValue(Name, new Undefined(Type));
        }

        #endregion

        #region Builder Implementation

        public override void Build(QLGuiBuilder guiBuilder)
        {
            if (Type.IsCompatibleWith(new QBool()))
                guiBuilder.AppendQuestion(new GUICheckBox(Memory, Name, Label));
            else if(Type.IsCompatibleWith(new QString()))
                guiBuilder.AppendQuestion(new GUIStringTextBox(Memory, Name, Label));
            else
                guiBuilder.AppendQuestion(new GUIIntTextBox(Memory, Name, Label));
        }

        #endregion
    }
}