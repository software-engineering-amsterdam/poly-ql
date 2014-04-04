using System;
using System.IO;

namespace GOLD.Engine
{
    internal class LookAheadBuffer
    {
        internal Tuple<int, int> Position { get; private set; }

        private TextReader reader;
        private string buffer;

        internal LookAheadBuffer(TextReader tr)
        {
            reader = tr;
            buffer = String.Empty;

            Position = new Tuple<int, int>(0, 0);
        }

        internal string GetTextFromBuffer(int length)
        {
            if (length >= buffer.Length)
            {
                return buffer;
            }

            return buffer.Substring(0, length);
        }

        internal string LookAhead(int index)
        {
            if (index > buffer.Length)
            {
                int readCount = index - buffer.Length;
                for (int i = 0; i < readCount; i++)
                {
                    buffer += (char)reader.Read();
                }
            }

            return index <= buffer.Length ? buffer[index - 1].ToString() : String.Empty;
        }

        internal void Consume(int count)
        {
            if (count > buffer.Length)
            {
                return;
            }

            for (int i = 0; i < count; i++)
            {
                switch(buffer[i])
                {
                    case '\n':
                        Position = new Tuple<int, int>(Position.Item1 + 1, 0);
                        break;

                    case '\r':
                        break;

                    default:
                        Position = new Tuple<int, int>(Position.Item1, Position.Item2 + 1);
                        break;
                }
            }

            buffer = buffer.Remove(0, count);
        }
    }
}
