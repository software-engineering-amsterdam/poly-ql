using System.Collections.Generic;
using QL.QLClasses.Expressions;
using QL.QLClasses.Types;
using QL.QLClasses.Values;

namespace QL
{
    public class QLMemory
    {
        private readonly Dictionary<string, QType> _idsTypes;
        private readonly Dictionary<string, QValue> _idsValues; 
        private readonly Dictionary<string, ExpressionBase> _idsComputedValues;
        private readonly List<string> _labels;

        public Dictionary<string, QValue> IdsValues { get; set; }

        public QLMemory()
        {
            _idsTypes = new Dictionary<string, QType>();
            _idsValues = new Dictionary<string, QValue>();
            _idsComputedValues = new Dictionary<string, ExpressionBase>();
            _labels = new List<string>();
        }

        #region Types

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

        #region Values

        public void DeclareValue(string name, QValue value)
        {
            _idsValues[name] = value;
        }

        public void DeclareComputedValue(string name, ExpressionBase value)
        {
            _idsComputedValues[name] = value;
        }

        public bool ValueIsDeclared(string name)
        {
            return _idsComputedValues.ContainsKey(name) || _idsValues.ContainsKey(name);
        }

        public QValue GetDeclaredValue(string name)
        {
            if (_idsComputedValues.ContainsKey(name))
                return _idsComputedValues[name].Evaluate();

            return _idsValues[name];
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
