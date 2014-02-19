using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Components.Types
{
    public class TypeInt : TypeBase, IExpression
    {
        private int _value;

        public TypeInt(string field) : base(field)
        {
            SetValue(field);
        }

        public override Type Type()
        {
            return typeof(int);
        }

        public override object GetValue()
        {
            return _value;
        }

        public override void SetValue(object value)
        {
            _value = Convert.ToInt32(value);
        }
    }
}
