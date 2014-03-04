using System;

namespace GOLD.Engine
{
    public class ParserException : Exception
    {
        public ParserException()
            : base()
        {

        }

        public ParserException(string msg)
            : base(msg)
        {

        }
    }
}
