using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.AST.Types;

namespace QSLib.Visitors
{
    public interface ITypeVisitor<T>
    {
        T Visit(IntegerType type);
        T Visit(StringType type);
        T Visit(BoolType type);
    }
}
