using System.Collections.Generic;
using QL.QLClasses;

namespace QL.TypeChecker
{
    public class QLTypeChecker
    {
        public QLTypeErrors TypeErrors { get; private set; }

        public QLTypeChecker()
        {
            TypeErrors = new QLTypeErrors();
        }

        public void Run(Questionnaire AST)
        {
            AST.CheckType(TypeErrors);
        }
    }

    public class QLTypeErrors : List<QLTypeError>
    {
        public void ReportError(QLTypeError typeError)
        {
            Add(typeError);
        }
    }

    public class QLTypeError
    {
        public QLTokenInfo TokenInfo { get; private set; }
        public string Message { get; private set; }
        public bool IsWarning { get; private set; }

        public QLTypeError(string message, QLTokenInfo tokenInfo, bool isWarning = false)
        {
            TokenInfo = tokenInfo;
            Message = message;
            IsWarning = isWarning;
        }
    }
}
