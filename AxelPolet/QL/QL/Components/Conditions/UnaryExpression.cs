using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Components.Types;

namespace QL.Components.Conditions
{
    public class UnaryExpression : ConditionalExpression, ITypeChecker, IExpression
    {
        public TypeBase Value { get; set; }

        public override bool Result()
        {
            return Convert.ToBoolean(Value.GetValue());
        }

        public bool CheckType()
        {
            return Value is TypeBool;
        }
    }
}
