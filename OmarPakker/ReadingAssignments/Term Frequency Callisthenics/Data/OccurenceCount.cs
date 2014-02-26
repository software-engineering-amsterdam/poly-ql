using System;

namespace Term_Frequency_Callisthenics.Data
{
    public class OccurenceCount : IComparable<OccurenceCount>
    {
        private int _count;

        public OccurenceCount()
            : this(0)
        {
            
        }

        public OccurenceCount(int count)
        {
            _count = count;
        }

        public void Increment()
        {
            _count++;
        }

        public int CompareTo(OccurenceCount other)
        {
            return _count - other._count;
        }

        public override bool Equals(object obj)
        {
            if(!(obj is OccurenceCount))
            {
                return false;
            }

            int otherCount = ((OccurenceCount)obj)._count;
            return _count.Equals(otherCount);
        }

        public override int GetHashCode()
        {
            return _count.GetHashCode();
        }

        public override string ToString()
        {
            return _count.ToString();
        }
    }
}
