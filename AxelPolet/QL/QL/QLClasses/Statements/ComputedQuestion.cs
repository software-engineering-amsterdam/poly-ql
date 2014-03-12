using QL.Interpreter.Controls;
using QL.QLClasses.Expressions;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public class ComputedQuestion : Question
    {
        private readonly ExpressionBase _value;

        public ComputedQuestion(QLMemoryManager memory, string name, string label, QType type, ExpressionBase expression) 
            : base(memory, name, label, type)
        {
            _value = expression;
        }

        #region TypeChecker Implementation

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (!_value.CheckType(typeErrors))
                return false;

            if (!Type.GetType().IsCompatibleWith(_value.GetResultType()))
            {
                typeErrors.ReportError(new QLTypeError
                {
                    Message = string.Format("(Question) Assigned value does not match declared type. Expected type: '{0}', Given value: '{1}'",
                            Type.GetType(), _value.GetResultType()), TokenInfo = TokenInfo
                });

                return false;
            }

            //check other question properties after the expression check, to prevent circulair references
            return base.CheckType(typeErrors);
        }

        protected override void DeclareValue()
        {
            Memory.DeclareValue(Name, _value);
        }

        #endregion

        #region Builder Implementation

        public override void Build(GUIQuestionnaire gui)
        {
            if (Type.IsCompatibleWith(new QBool()))
                gui.AppendQuestion(new GUICheckBox(Memory, Name, Label, Type, _value));
            else
                gui.AppendQuestion(new GUITextBox(Memory, Name, Label, Type, _value));
        }

        #endregion
    }
}
