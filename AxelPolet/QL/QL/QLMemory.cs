using System.Collections.Generic;
using QL.QLClasses.Expressions;
using QL.QLClasses.Types;
using QL.QLClasses.Values;

namespace QL
{
    public class QLMemory
    {
        private readonly Dictionary<string, QType> _idsTypes;
        private readonly Dictionary<string, ExpressionBase> _idsValues;
        private readonly List<string> _labels;

        public Dictionary<string, QValue> IdsValues { get; set; }

        public QLMemory()
        {
            _idsTypes = new Dictionary<string, QType>();
            _idsValues = new Dictionary<string, ExpressionBase>();
            _labels = new List<string>();
        }

        #region IdsTypes

        public void Declare(string name, QType type)
        {
            _idsTypes[name] = type;
        }

        public bool IsDeclared(string name)
        {
            return _idsTypes.ContainsKey(name);
        }

        public QType GetDeclaredType(string name)
        {
            return _idsTypes[name];
        }

        #endregion

        #region IdsValues

        public void DeclareValue(string name, ExpressionBase value)
        {
            _idsValues[name] = value;
        }

        public bool ValueIsDeclared(string name)
        {
            return _idsValues.ContainsKey(name);
        }

        public ExpressionBase GetDeclaredValue(string name)
        {
            if(ValueIsDeclared(name))
                return _idsValues[name];

            return null;
        }

        #endregion

        #region Labels

        public void DeclareLabel(string label)
        {
            _labels.Add(label);
        }

        public bool LabelIsDeclared(string label)
        {
            return _labels.Contains(label);
        }

        #endregion
    }
}
