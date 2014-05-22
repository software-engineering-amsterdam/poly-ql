using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QLUI.WindowsForms.Abstract
{
    public interface IPrimitiveValue<T>
    {
        T GetValue();
        void SetValue(T Value);
    }
}
