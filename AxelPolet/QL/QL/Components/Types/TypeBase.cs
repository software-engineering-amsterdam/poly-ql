using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Components.Types
{
    public abstract class TypeBase : ExpressionBase, IExpression
    {
        public abstract object GetValue();
        public abstract void SetValue(object value);

        public TypeBase(string field)
        {
            SetValue(field);
        }

        public override Type Type()
        {
            return typeof(TypeBase);
        }
    }
}