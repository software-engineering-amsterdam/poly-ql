using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Components.Types
{
    public class TypeString : TypeBase, IExpression
    {
        private string _value;

        public TypeString(string field) : base(field)
        {
            SetValue(field);
        }

        public override Type Type()
        {
            return typeof(string);
        }

        public override object GetValue()
        {
            return _value;
        }

        public override void SetValue(object value)
        {
            _value = Convert.ToString(value);
        }
    }
}
