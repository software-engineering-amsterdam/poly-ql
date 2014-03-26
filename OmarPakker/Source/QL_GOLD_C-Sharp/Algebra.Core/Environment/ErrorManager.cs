using System;
using System.Collections.Generic;

namespace Algebra.Core.Environment
{
    public class ErrorManager
    {
        //TODO: Delegate or Action<>?
        public event Action<string, Tuple<int, int>, Tuple<int, int>> OnError;
        public event Action<string, Tuple<int, int>, Tuple<int, int>> OnWarning;
        public event Action<string, Tuple<int, int>, Tuple<int, int>> OnMessage;

        private readonly ICollection<ManagerMsg> errors;
        private readonly ICollection<ManagerMsg> warnings;
        private readonly ICollection<ManagerMsg> messages;

        public bool HasErrors { get { return errors.Count > 0; } }
        public bool HasWarnings { get { return warnings.Count > 0; } }
        public bool HasMessages { get { return messages.Count > 0; } }

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
            messages = new List<ManagerMsg>();
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

            if (OnError != null)
            {
                OnError(msg.Message, msg.StartPosition, msg.EndPosition);
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

            if (OnWarning != null)
            {
                OnWarning(msg.Message, msg.StartPosition, msg.EndPosition);
            }
        }

        public void ReportMessage(string msg)
        {
            ReportMessage(msg, null, null);
        }

        public void ReportMessage(string msg, Tuple<int, int> startPos, Tuple<int, int> endPos)
        {
            if (suffixPosition && startPos != null && endPos != null)
            {
                msg += String.Format(" (Start {0} | End {1}).", startPos, endPos);
            }

            ReportMessage(new ManagerMsg(msg, startPos, endPos));
        }

        private void ReportMessage(ManagerMsg msg)
        {
            messages.Add(msg);

            if (OnMessage != null)
            {
                OnMessage(msg.Message, msg.StartPosition, msg.EndPosition);
            }
        }
    }
}
