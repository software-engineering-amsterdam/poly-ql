using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions
{
    public interface IExpression
    {
        Type CheckType();
    }
}
