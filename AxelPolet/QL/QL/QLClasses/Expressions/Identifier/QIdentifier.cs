using System.Windows.Forms;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Identifier
{
    public class QIdentifier : ExpressionBase
    {
        private readonly bool _referenced;
        private QBaseType _innerType;
        private ExpressionBase _innerValue;

        public string Name { get; private set; }
        public QLIdManager QlIdManager { get; private set; }

        public QIdentifier(string name, QLIdManager idManager)
        {
            _referenced = true;

            Name = name;
            QlIdManager = idManager;
        }

        public QIdentifier(string name, QBaseType type, QLIdManager idManager, ExpressionBase value = null)
        {
            _referenced = false;
            _innerType = type;
            _innerValue = value;

            Name = name;
            QlIdManager = idManager;
        }

        public override QBaseType GetResultType()
        {
            if (_innerType != null)
                return _innerType;

            if (_referenced)
            {
                QIdentifier refId = QlIdManager.GetIdentifierByString(Name);
                return _innerType = refId.GetResultType();
            }

            return null;
        }

        public override ExpressionBase GetResult()
        {
            if (_innerValue != null)
                return _innerValue;

            if (_referenced)
            {
                QIdentifier refId = QlIdManager.GetIdentifierByString(Name);
                return _innerValue = refId.GetResult();
            }

            return null;
        }

        #region TypeChecker Implementation

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (!_referenced)
            {
                if (QlIdManager.Exists(Name))
                {
                    typeErrors.ReportError(new QLTypeError
                    {
                        Message = string.Format("Identifier '{0}' is already defined!", Name),
                        TokenInfo = TokenInfo
                    });
                    return false;
                }

                QlIdManager.AddId(Name, this);
            }
            else
            {
                if (!QlIdManager.Exists(Name))
                {
                    typeErrors.ReportError(new QLTypeError
                    {
                        Message = string.Format("Referenced identifier '{0}' is not defined!", Name),
                        TokenInfo = TokenInfo
                    });
                    return false;
                }
            }           

            return true;
        }

        #endregion
    }
}
