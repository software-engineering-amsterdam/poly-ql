using System;

namespace QL_Grammar.QLTypeCheck.Helpers
{
    public static class ErrorHelpers
    {
        public static Tuple<string, bool> CreateTypeCheckError(this ITypeCheck check, string msg, bool error)
        {
            string finalMsg = (error ? "ERROR! " : "WARNING! ") + msg;
            if (check.SourcePosition != null)
            {
                finalMsg += String.Format(" (line {0} column {1}).",
                    //Line/column properties start on 0 so offset it to correct that.
                    //Column points to the character index at the end of the statement.
                    check.SourcePosition.Item1 + 1, check.SourcePosition.Item2 + 1);
            }
            return new Tuple<string, bool>(finalMsg, error);
        }
    }
}
