using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Error
{
    public abstract class QSError
    {
        protected int _line;

        public override abstract string ToString();
    }
}
