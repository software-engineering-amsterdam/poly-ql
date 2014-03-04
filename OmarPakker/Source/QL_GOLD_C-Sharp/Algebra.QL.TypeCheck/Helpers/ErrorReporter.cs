using System;

namespace Algebra.QL.TypeCheck.Helpers
{
    public class ErrorReporter
    {
        public delegate void OnTypeCheckErrorEventHandler(Tuple<int, int> sourceStartPos, Tuple<int, int> sourceEndPos, string msg, bool error);
        public event OnTypeCheckErrorEventHandler OnTypeCheckError;

        public ErrorReporter()
        {

        }

        public void ReportError(ITypeCheck item, string msg)
        {
            if (OnTypeCheckError != null)
            {
                OnTypeCheckError(item.SourceStartPosition, item.SourceEndPosition,
                    ConstructMessage("ERROR! " + msg, item.SourceStartPosition), true);
            }
        }

        public void ReportWarning(ITypeCheck item, string msg)
        {
            if (OnTypeCheckError != null)
            {
                OnTypeCheckError(item.SourceStartPosition, item.SourceEndPosition,
                    ConstructMessage("WARNING! " + msg, item.SourceStartPosition), false);
            }
        }

        private string ConstructMessage(string msg, Tuple<int, int> pos)
        {
            if (pos != null)
            {
                msg += String.Format(" (line {0} column {1}).", pos.Item1, pos.Item2);
            }
            return msg;
        }
    }
}
