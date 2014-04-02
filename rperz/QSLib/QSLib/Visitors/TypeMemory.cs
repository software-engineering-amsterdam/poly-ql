using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.AST.Types;
using QSLib.AST.Expressions;
using QSLib.AST.Expressions.Unary;
using QSLib.AST.Expressions.Literals;
using QSLib.AST.Expressions.Nullary;

namespace QSLib.Visitors
{
    public class TypeMemory
    {
        private IDictionary<string, QSType> _memory = new Dictionary<string, QSType>();

        public bool TryDeclare(string name, QSType type)
        {
            if (this._memory.ContainsKey(name))
                return false;
            else
            {
                this._memory.Add(name, type);
                return true;
            }
        }

        public QSType GetType(string id)
        {
            QSType type = null;
            this._memory.TryGetValue(id, out type);
            return type;
        }

        public bool IsDeclared(string name)
        {
            return this._memory.ContainsKey(name);
        }
    }
}
