using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using QL.Components.Conditions.BinaryExpressions.Operators;
using QL.Components.Types;


namespace QL.Components.Conditions.BinaryExpressions
{
    public class CompareExpression : BinaryExpression, IExpression
    {
        public OperatorBase CompareOperator { get; set; }

        public override bool Result()
        {
            return CompareOperator.Compare(LeftValue, RightValue);
        }
    }
}
