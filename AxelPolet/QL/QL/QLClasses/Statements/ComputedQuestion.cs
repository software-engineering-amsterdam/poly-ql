using QL.Interpreter;
using QL.Interpreter.Controls;
using QL.QLClasses.Expressions;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public class ComputedQuestion : Question
    {
        private readonly ExpressionBase _value;

        public ComputedQuestion(QLMemory memory, string name, string label, QType type, ExpressionBase expression) 
            : base(memory, name, label, type)
        {
            _value = expression;
        }

        #region TypeChecker Implementation

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (!base.CheckType(typeErrors))
                return false;

            if (!_value.CheckType(typeErrors))
                return false;

            if (!Type.GetType().IsCompatibleWith(_value.GetResultType()))
            {
                typeErrors.ReportError(new QLTypeError(
                    string.Format("(ComputedQuestion) Assigned value does not match declared type. Expected type: '{0}', Given value: '{1}'",
                            Type.GetType(), _value.GetResultType()), 
                    TokenInfo = TokenInfo
                ));

                return false;
            }

            return true;
        }

        protected override void DeclareValue()
        {
            Memory.DeclareComputedValue(Name, _value);
        }

        #endregion

        #region Builder Implementation

        public override void Build(QLGuiBuilder guiBuilder)
        {
            guiBuilder.BuildQuestion(Memory, Name, Label, true);
        }

        #endregion
    }
}
