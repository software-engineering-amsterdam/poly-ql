using QL.Interpreter.Controls;
using QL.QLClasses.Expressions;
using QL.QLClasses.Types;
using QL.QLClasses.Values;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public class Question : StatementBase
    {
        protected string Name;
        protected string Label;
        protected QType Type;
        protected QLMemoryManager Memory;

        public Question(QLMemoryManager memory, string name, string label, QType type)
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

        public override void Build(GUIQuestionnaire gui)
        {
            if(Type.IsCompatibleWith(new QBool()))
                gui.AppendQuestion(new GUICheckBox(Memory, Name, Label, Type));
            else 
                gui.AppendQuestion(new GUITextBox(Memory, Name, Label, Type));
        }

        #endregion
    }
}