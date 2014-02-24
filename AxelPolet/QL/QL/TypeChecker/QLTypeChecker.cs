using System;
using QL.Interfaces;
using QL.QLClasses;
using QL.QLClasses.Statements;

namespace QL.TypeChecker
{
    public class QLTypeChecker
    {
        public delegate void ErrorHandler(string message);
        public ErrorHandler OnError { get; set; }

        private QLException _qlException;
        
        public QLTypeChecker()
        {
            _qlException = new QLException();
        }

        public void Check(Questionnaire AST)
        {
            foreach (StatementBase statement in AST.Body)
            {
                CheckType(statement);
            }
        }

        private void CheckType(ITypeChecker typeChecker)
        {
            if (!typeChecker.CheckType(ref _qlException))
                HandleError(_qlException);
        }

        private void HandleError(QLException error)
        {
            OnError(string.Format("QLTypeChecker: {0} {1}"  +
                            "<At token '{2}' on line {3}, column {4}>{5}", 
                            error.Message, Environment.NewLine, 
                            error.TokenText, error.TokenLine, error.TokenColumn, Environment.NewLine));
        }
    }
}
