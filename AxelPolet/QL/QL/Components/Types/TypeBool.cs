using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Components.Types
{
    public class TypeBool : TypeBase, IExpression
    {
        private bool _value;

        public TypeBool(string field) : base(field)
        {
            SetValue(field);
        }

        public override Type Type()
        {
            return typeof(bool);
        }

        public override object GetValue()
        {
            return _value;
        }

        public override void SetValue(object value)
        {
            _value = Convert.ToBoolean(value);
        }
    }
}
