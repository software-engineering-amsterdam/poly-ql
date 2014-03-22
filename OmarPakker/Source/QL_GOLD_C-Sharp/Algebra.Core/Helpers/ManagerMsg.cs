using System;

namespace Algebra.Core.Helpers
{
    internal class ManagerMsg
    {
        internal string Message { get; private set; }
        internal Tuple<int, int> StartPosition { get; private set; }
        internal Tuple<int, int> EndPosition { get; private set; }

        internal ManagerMsg(string msg, Tuple<int, int> startPos, Tuple<int, int> endPos)
        {
            Message = msg;
            StartPosition = startPos;
            EndPosition = endPos;
        }
    }
}
