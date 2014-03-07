using QL.QLClasses.Expressions;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public class ComputedQuestion : Question
    {
        private readonly ExpressionBase _value;

        public ComputedQuestion(QLMemoryManager memory, string name, string label, QBaseType type, ExpressionBase expression) :
            base(memory, name, label, type)
        {
            _value = expression;
        }

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

            Memory.DeclareValue(Name, _value);

            //check other question properties after the expression, to prevent circulair references
            return base.CheckType(typeErrors);
        }
    }
}
