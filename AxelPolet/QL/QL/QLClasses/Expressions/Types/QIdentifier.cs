using System;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Types
{
    public class QIdentifier : QBaseType
    {
        public string Identifier { get; private set; }
        public bool Referenced { get; set; }
        public bool HasValue { get { return InnerValue != null && InnerValue.GetValue() != null; } }

        private QBaseType InnerValue
        {
            get { return _value as QBaseType; } 
        }

        public QIdentifier(string identifier, bool referenced = false) : base(null)
        {
            Identifier = identifier;
            Referenced = referenced;
        }

        public QIdentifier(string identifier, QBaseType type, bool referenced = false) : base(type)
        {
            Identifier = identifier;
            Referenced = referenced;
        }

        public override bool CheckType(ref QLException error)
        {
            if (!Referenced && Identifiers.IsDefined(Identifier))
            {
                error.Message = string.Format("Identifier '{0}' already defined!", Identifier);
                error.TokenLine = TokenLine;
                error.TokenColumn = TokenColumn;
                error.TokenText = TokenText;

                return false;
            }

            if (Referenced && !Identifiers.IsDefined(Identifier))
            {
                error.Message = string.Format("Referenced identifier '{0}' is not defined!", Identifier);
                error.TokenLine = TokenLine;
                error.TokenColumn = TokenColumn;
                error.TokenText = TokenText;

                return false;
            }

            if (Referenced)
            {
                RetrieveIdentifierValue();

                if (!HasValue)
                {
                    error.Message = string.Format("Referenced identifier '{0}' has no value", Identifier);
                    error.TokenLine = TokenLine;
                    error.TokenColumn = TokenColumn;
                    error.TokenText = TokenText;

                    return false;
                }
            }

            return InnerValue.CheckType(ref error);
        }

        public override object Result()
        {
            RetrieveIdentifierValue();
            return InnerValue.Result();
        }

        public override object GetValue()
        {
            RetrieveIdentifierValue();
            return HasValue ? InnerValue.GetValue() : null;
        }

        public override void SetValue(object value)
        {
            _value = value;
        }

        public override Type GetType()
        {
            RetrieveIdentifierValue();
            
            return InnerValue.GetType();
        }

        private void RetrieveIdentifierValue()
        {
            if (!HasValue && Referenced)
            {
                QIdentifier refId = Identifiers.GetQuestion(Identifier).ID;

                if (refId.HasValue)
                    _value = refId.InnerValue;
            }
        }       
    }
}
