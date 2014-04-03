using System;
using System.Collections.Generic;

namespace Algebra.Core.Environment
{
    public class ErrorManager
    {
        public event Action<string, Tuple<int, int>, Tuple<int, int>> ErrorReported;
        public event Action<string, Tuple<int, int>, Tuple<int, int>> WarningReported;
        public event Action<string, Tuple<int, int>, Tuple<int, int>> InfoMessageReported;

        private readonly ICollection<ManagerMsg> errors;
        private readonly ICollection<ManagerMsg> warnings;
        private readonly ICollection<ManagerMsg> infoMessages;

        public bool HasErrors { get { return errors.Count > 0; } }
        public bool HasWarnings { get { return warnings.Count > 0; } }
        public bool HasInfoMessages { get { return infoMessages.Count > 0; } }
        public bool HasAnyMessage { get { return HasErrors || HasWarnings || HasInfoMessages; } }

        private readonly bool prefixMessageType;
        private readonly bool suffixPosition;

        public ErrorManager()
            : this(false, true)
        {

        }

        public ErrorManager(bool prefixMsgType, bool suffixPos)
        {
            prefixMessageType = prefixMsgType;
            suffixPosition = suffixPos;

            errors = new List<ManagerMsg>();
            warnings = new List<ManagerMsg>();
            infoMessages = new List<ManagerMsg>();
        }

        public void ReportError(string msg)
        {
            ReportError(msg, null, null);
        }

        public void ReportError(string msg, Tuple<int, int> startPos, Tuple<int, int> endPos)
        {
            if (prefixMessageType)
            {
                msg = "Error! " + msg;
            }
            if (suffixPosition && startPos != null && endPos != null)
            {
                msg += String.Format(" (Start {0} | End {1}).", startPos, endPos);
            }

            ReportError(new ManagerMsg(msg, startPos, endPos));
        }

        private void ReportError(ManagerMsg msg)
        {
            errors.Add(msg);

            if (ErrorReported != null)
            {
                ErrorReported(msg.Message, msg.StartPosition, msg.EndPosition);
            }
        }

        public void ReportWarning(string msg)
        {
            ReportWarning(msg, null, null);
        }

        public void ReportWarning(string msg, Tuple<int, int> startPos, Tuple<int, int> endPos)
        {
            if (prefixMessageType)
            {
                msg = "Warning! " + msg;
            }
            if (suffixPosition && startPos != null && endPos != null)
            {
                msg += String.Format(" (Start {0} | End {1}).", startPos, endPos);
            }

            ReportWarning(new ManagerMsg(msg, startPos, endPos));
        }

        private void ReportWarning(ManagerMsg msg)
        {
            warnings.Add(msg);

            if (WarningReported != null)
            {
                WarningReported(msg.Message, msg.StartPosition, msg.EndPosition);
            }
        }

        public void ReportInfoMessage(string msg)
        {
            ReportInfoMessage(msg, null, null);
        }

        public void ReportInfoMessage(string msg, Tuple<int, int> startPos, Tuple<int, int> endPos)
        {
            if (suffixPosition && startPos != null && endPos != null)
            {
                msg += String.Format(" (Start {0} | End {1}).", startPos, endPos);
            }

            ReportInfoMessage(new ManagerMsg(msg, startPos, endPos));
        }

        private void ReportInfoMessage(ManagerMsg msg)
        {
            infoMessages.Add(msg);

            if (InfoMessageReported != null)
            {
                InfoMessageReported(msg.Message, msg.StartPosition, msg.EndPosition);
            }
        }
    }
}
