using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using QL.Components.Types;

namespace QL.Components.Conditions.BinaryExpressions.Operators
{
    public abstract class OperatorBase
    {
        public abstract bool Compare(ExpressionBase leftValue, ExpressionBase rightValue);
    }
}
