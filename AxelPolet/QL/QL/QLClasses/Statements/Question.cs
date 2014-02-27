using QL.QLClasses.Expressions;
using QL.QLClasses.Expressions.Identifier;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public class Question : StatementBase
    {
        public QIdentifier Name { get; set; }
        public string Label { get; set; }
        public QBaseType Type { get; set; }
        public ExpressionBase Value { get; set; }

        public Question(QIdentifier identifier, string label, QBaseType type, ExpressionBase expression = null)
        {
            Label = label;
            Type = type;
            Value = expression;

            Name = identifier;
            Name.Referenced = false;
            Name.InnerType = type;

            if (expression != null)
                Name.InnerValue = expression;

            Name.DeclareSelf();
        }

        public override bool CheckType(ref QLTypeError error)
        {
            if (!Name.CheckType(ref error))
                return false;

            if (Value != null)
            {
                if (!Value.CheckType(ref error))
                    return false;

                if (!Type.GetType().IsCompatibleWith(Value.GetResultType()))
                {
                    error.Message = string.Format("(Question) Assigned value does not match declared type. Type: '{0}' ValueType: '{1}'", Type.GetType(), Value.GetType());
                    error.TokenInfo = Name.TokenInfo;

                    return false;
                }
            }
            
            return true;
        }
    }
}
