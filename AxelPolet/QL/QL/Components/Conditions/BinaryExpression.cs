using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Components.Types;

namespace QL.Components.Conditions
{
    public abstract class BinaryExpression : ConditionalExpression, IExpression
    {
        public ExpressionBase LeftValue { get; set; }
        public ExpressionBase RightValue { get; set; }

        public override abstract bool Result();
    }
}
