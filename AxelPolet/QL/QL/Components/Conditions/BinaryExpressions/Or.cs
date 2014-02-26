using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Components.Conditions.BinaryExpressions
{
    public class Or : BinaryExpression, IExpression
    {
        public override bool Result()
        {
            return true;
        }   
    }
}
