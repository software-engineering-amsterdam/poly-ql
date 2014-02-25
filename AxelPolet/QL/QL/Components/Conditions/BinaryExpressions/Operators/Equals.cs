using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using QL.Components.Types;

namespace QL.Components.Conditions.BinaryExpressions.Operators
{
    public class Equals : OperatorBase
    {
        public override bool Compare(ExpressionBase leftValue, ExpressionBase rightValue)
        {
            return true;
            //return (leftValue.GetValue() as leftValue.GetType())
        }
    }
}
