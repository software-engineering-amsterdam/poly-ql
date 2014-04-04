using System;
using Algebra.Core.Environment;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Environment
{
    public interface ITypeEnvironment : IVarEnvironment<ITypeCheckType>
    {
        void ReportError(string msg, Tuple<int, int> startPos, Tuple<int, int> endPos);
        void ReportWarning(string msg, Tuple<int, int> startPos, Tuple<int, int> endPos);
    }
}
