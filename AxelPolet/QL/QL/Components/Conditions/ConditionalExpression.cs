using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Components.Conditions
{
    public abstract class ConditionalExpression : ExpressionBase, IExpression
    {
        public abstract bool Result();
        
        public override Type Type()
        {
            return typeof(ConditionalExpression);
        }
    }
}
