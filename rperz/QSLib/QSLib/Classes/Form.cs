using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions;

namespace QSLib.Classes
{
    class Form
    {
        private List<Expression> _expList;
        public Form(List<Expression> expList)
        {
            this._expList = expList;
        }
    }
}
