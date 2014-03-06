using System;

namespace Algebra.QL.TypeCheck.Helpers
{
    public class ErrorReporter
    {
        public delegate void OnTypeCheckErrorEventHandler(Tuple<int, int> sourceStartPos, Tuple<int, int> sourceEndPos, string msg, bool error);
        public event OnTypeCheckErrorEventHandler OnTypeCheckError;
        public bool HasErrors { get; private set; }

        public ErrorReporter()
        {
            HasErrors = false;
        }

        public void ReportError(ITypeCheck item, string msg)
        {
            HasErrors = true;
            if (OnTypeCheckError != null)
            {
                OnTypeCheckError(item.SourceStartPosition, item.SourceEndPosition,
                    ConstructMessage("ERROR! " + msg, item), true);
            }
        }

        public void ReportWarning(ITypeCheck item, string msg)
        {
            if (OnTypeCheckError != null)
            {
                OnTypeCheckError(item.SourceStartPosition, item.SourceEndPosition,
                    ConstructMessage("WARNING! " + msg, item), false);
            }
        }

        private string ConstructMessage(string msg, ITypeCheck item)
        {
            if (item != null && item.SourceStartPosition != null && item.SourceEndPosition != null)
            {
                msg += String.Format(" (Start {0} | End {1}).", item.SourceStartPosition, item.SourceEndPosition);
            }
            return msg;
        }
    }
}
