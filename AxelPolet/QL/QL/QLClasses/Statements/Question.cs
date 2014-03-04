using QL.QLClasses.Expressions;
using QL.QLClasses.Expressions.Identifier;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public class Question : StatementBase
    {
        private QIdentifier _name;
        private string _label;
        private QBaseType _type;
        private ExpressionBase _value;
        private QLQuestionManager _questionManager;

        public Question(QLQuestionManager questionManager, QIdentifier identifier, string label, QBaseType type, ExpressionBase expression = null)
        {
            _label = label;
            _type = type;
            _value = expression;

            _name = new QIdentifier(identifier.Name, type, identifier.QlIdManager, expression);
            _name.TokenInfo = identifier.TokenInfo;

            _questionManager = questionManager;
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            //check identifier first
            if (!_name.CheckType(typeErrors))
                return false;

            if (!_questionManager.LabelExists(_label))
            {
                typeErrors.ReportError(new QLTypeError
                {
                    IsWarning = true,
                    Message = string.Format("(Question) Declared label already exists: '{0}'", _label),
                    TokenInfo = _name.TokenInfo
                });
            }

            if (_value != null)
            {
                if (!_value.CheckType(typeErrors))
                    return false;

                if (!_type.GetType().IsCompatibleWith(_value.GetResultType()))
                {
                    typeErrors.ReportError(new QLTypeError
                    {
                        Message = string.Format(
                                "(Question) Assigned value does not match declared type. Expected type: '{0}', Given value: '{1}'",
                                _type.GetType(), _value.GetResultType()),
                        TokenInfo = _name.TokenInfo
                    });

                    return false;
                }
            }
            
            return true;
        }
    }
}
