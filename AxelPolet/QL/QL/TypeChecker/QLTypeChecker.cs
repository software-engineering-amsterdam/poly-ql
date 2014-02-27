using System;
using System.Collections.Generic;
using QL.QLClasses;

namespace QL.TypeChecker
{
    public class QLTypeChecker
    {
        private static List<QLTypeError> additionalErrors = new List<QLTypeError>();
        
        public static void SaveQLError(QLTypeError ex)
        {
            additionalErrors.Add(ex);
        }

        public static void ClearAdditionalErrors()
        {
            additionalErrors.Clear();
        }

        public delegate void ErrorHandler(string message);
        public ErrorHandler OnError { get; set; }

        public List<QLTypeError> TypeErrors { get; private set; }

        public QLTypeChecker()
        {
            TypeErrors = new List<QLTypeError>();
        }

        public void Check(Questionnaire AST)
        {
            QLTypeErrors typeErrors = new QLTypeErrors();

            QLTypeError qlTypeError = new QLTypeError();

            foreach (ITypeChecker typeChecker in AST.Body)
            {
                if (!typeChecker.CheckType(ref qlTypeError))
                    SaveQLError(qlTypeError);
            }

            foreach (QLTypeError additionalError in additionalErrors)
            {
                HandleError(additionalError);
            }
        }

        private void HandleError(QLTypeError error)
        {
            OnError(string.Format("QLTypeChecker: {0} {1}"  +
                            "<At token '{2}' on line {3}, column {4}>{5}", 
                            error.Message, Environment.NewLine, 
                            error.TokenInfo.TokenText, error.TokenInfo.TokenLine, error.TokenInfo.TokenText, Environment.NewLine));
        }
    }

    public class QLTypeErrors
    {
        public List<QLTypeError> TypeErrors { get; private set; }

        public QLTypeErrors()
        {
            TypeErrors = new List<QLTypeError>();
        }

        public void ReportError(QLTypeError typeError)
        {
            TypeErrors.Add(typeError);
        }
    }
}
