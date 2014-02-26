using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Identifier
{
    public class QIdentifier : ExpressionBase
    {
        public string Identifier { get; private set; }
        public bool Referenced { get; set; }
        
        public QBaseType InnerType { get; set; }
        public ExpressionBase InnerValue { get; set; }

        public QIdentifier(string identifier)
        {
            Identifier = identifier;
            Referenced = true;
        }

        public QIdentifier(string identifier, QBaseType type, ExpressionBase value = null)
        {
            Identifier = identifier;
            Referenced = false;
            InnerType = type;
            InnerValue = value;
        }

        public void DeclareSelf()
        {
            if (!Referenced)
            {
                if (Identifiers.IsDefined(Identifier))
                {
                    QLException error = new QLException();

                    error.Message = string.Format("Identifier '{0}' already defined!", Identifier);
                    error.TokenInfo = TokenInfo;

                    QLTypeChecker.SaveQLError(error);
                }
                else
                {
                    Identifiers.AddIdentifier(Identifier, this);
                }
            }
        }

        public override QBaseType GetResultType()
        {
            if (InnerType != null)
                return InnerType;

            if (Referenced)
            {
                if (!Identifiers.IsDefined(Identifier))
                    return null;

                QIdentifier refId = Identifiers.GetIdentifier(Identifier);
                return InnerType = refId.GetResultType();
            }

            return null;
        }

        public override ExpressionBase GetResult()
        {
            if (InnerValue != null)
                return InnerValue;//.GetResult();

            if (Referenced)
            {
                if (!Identifiers.IsDefined(Identifier))
                    return null;

                QIdentifier refId = Identifiers.GetIdentifier(Identifier);
                return InnerValue = refId.GetResult();
            }

            return null;
        }

        #region TypeChecker Implementation

        public override bool CheckType(ref QLException error)
        {
            if (Referenced && !Identifiers.IsDefined(Identifier))
            {
                error.Message = string.Format("Referenced identifier '{0}' is not defined!", Identifier);
                error.TokenInfo = TokenInfo;
                return false;
            }

            if (Referenced)
            {
                if (GetResult() == null)
                {
                    error.Message = string.Format("Referenced identifier '{0}' has no value!", Identifier);
                    error.TokenInfo = TokenInfo;
                    return false;
                }
            }
            

            if (InnerValue != null)
            {
                QBaseType valueType = InnerValue.GetResultType();
                if (valueType != null)
                {
                    if (!(GetResultType().GetType().IsCompatibleWith(InnerValue.GetResultType())))
                    {
                        error.Message = string.Format("Identifier '{0}' expected a value of type '{1}', got '{2}'",
                            Identifier, InnerType.GetType(), InnerValue.GetResultType());
                        error.TokenInfo = TokenInfo;
                        return false;
                    }
                }

                return InnerValue.CheckType(ref error);
            }

            return true;
        }

        #endregion
    }
}
