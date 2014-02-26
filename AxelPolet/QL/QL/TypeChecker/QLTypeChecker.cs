using System;
using System.Collections.Generic;
using QL.Interfaces;
using QL.QLClasses;

namespace QL.TypeChecker
{
    public class QLTypeChecker
    {
        public delegate void ErrorHandler(string message);
        public ErrorHandler OnError { get; set; }

        private static List<QLException> additionalErrors = new List<QLException>();

        public static void SaveQLError(QLException ex)
        {
            additionalErrors.Add(ex);
        }

        public static void ClearAdditionalErrors()
        {
            additionalErrors.Clear();
        }

        private QLException _qlException;
        
        public QLTypeChecker()
        {
            _qlException = new QLException();
        }

        public void Check(Questionnaire AST)
        {
            foreach (ITypeChecker typeChecker in AST.Body)
            {
                if (!typeChecker.CheckType(ref _qlException))
                    SaveQLError(_qlException);
            }

            foreach (QLException additionalError in additionalErrors)
            {
                HandleError(additionalError);
            }
        }

        private void HandleError(QLException error)
        {
            OnError(string.Format("QLTypeChecker: {0} {1}"  +
                            "<At token '{2}' on line {3}, column {4}>{5}", 
                            error.Message, Environment.NewLine, 
                            error.TokenInfo.TokenText, error.TokenInfo.TokenLine, error.TokenInfo.TokenText, Environment.NewLine));
        }
    }
}
