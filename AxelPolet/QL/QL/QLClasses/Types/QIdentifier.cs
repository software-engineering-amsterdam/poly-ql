using System;
using QL.QLClasses.Expressions;
using QL.TypeChecker;

namespace QL.QLClasses.Types
{
    public class QIdentifier : QBaseType
    {
        public string Identifier { get; private set; }
        public bool Referenced { get; set; }
        public bool AlreadyDefined { get; set; }
        
        public QBaseType InnerType { get; set; }
        public ExpressionBase InnerValue { get; set; }

        public QIdentifier(string identifier) //: base(null)
        {
            Identifier = identifier;
            Referenced = true;
        }

        public QIdentifier(string identifier, QBaseType value) //: base(value)
        {
            Identifier = identifier;
            Referenced = false;
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

                    QLTypeChecker.QLError(error);
                    AlreadyDefined = true;
                }
                else
                {
                    Identifiers.AddIdentifier(Identifier, this);
                }
            }
        }

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
                if (GetValue() == null)
                {
                    error.Message = string.Format("Referenced identifier '{0}' has no value!", Identifier);
                    error.TokenInfo = TokenInfo;
                    return false;
                }
            }

            if (InnerType.GetType() != InnerValue.GetResultType())
            {
                error.Message = string.Format("Identifier '{0}' expected a value of type '{1}', got '{2}'", Identifier, InnerType.GetType(), InnerValue.GetType());
                error.TokenInfo = TokenInfo;
                return false;
            }

            if(InnerValue != null)
                return InnerValue.CheckType(ref error);

            return true;
        }

        //public override object GetResult()
        //{
        //    if (AlreadyDefined)
        //        return false;

        //    if (InnerValue != null)
        //        return InnerValue.GetResult();

        //    if (Referenced)
        //    {
        //        if (!Identifiers.IsDefined(Identifier))
        //            return null;

        //        QIdentifier refId = Identifiers.GetIdentifier(Identifier);
        //        return refId.GetResult();
        //    }

        //    return null;
        //}

        public ExpressionBase GetValue()
        {
            if (InnerValue != null)
                return InnerValue;//.GetResult();
            
            if(Referenced)
            {
                if (!Identifiers.IsDefined(Identifier))
                    return null;

                QIdentifier refId = Identifiers.GetIdentifier(Identifier);
                return refId.GetValue();
            }

            return null;
        }

        public override QBaseType GetType()
        {
            if (InnerType != null)
                return InnerType;

            if (Referenced)
            {
                if (!Identifiers.IsDefined(Identifier))
                    return null;

                QIdentifier refId = Identifiers.GetIdentifier(Identifier);
                return refId.GetType();
            }

            return null;
        }
     
    }
}
