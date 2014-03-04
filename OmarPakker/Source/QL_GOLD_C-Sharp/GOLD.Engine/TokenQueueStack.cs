using System.Collections.Generic;

namespace GOLD.Engine
{
    internal class TokenQueueStack
    {
        internal int Count { get { return tokenList.Count; } }

        private IList<Token> tokenList;

        internal TokenQueueStack()
        {
            tokenList = new List<Token>();
        }

        internal void Enqueue(Token token)
        {
            tokenList.Add(token);
        }

        internal Token Dequeue()
        {
            Token result = tokenList[0];
            tokenList.RemoveAt(0);
            return result;
        }

        internal void Push(Token token)
        {
            tokenList.Insert(0, token);
        }

        internal Token Pop()
        {
            return Dequeue();
        }

        internal Token Peek()
        {
            return Count > 0 ? tokenList[0] : null;
        }

        internal void Clear()
        {
            tokenList.Clear();
        }
    }
}
