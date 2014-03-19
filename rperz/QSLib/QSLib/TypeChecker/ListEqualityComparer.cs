using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib
{
    
    public class ListEqualityComparer : IEqualityComparer<IStatement>
    {

        bool IEqualityComparer<IStatement>.Equals(IStatement x, IStatement y)
        {
            return x != null && y != null && x.Equals(y);
        }

        int IEqualityComparer<IStatement>.GetHashCode(IStatement obj)
        {
            return base.GetHashCode();
        }
    }
}
