using System;
using System.Collections.Generic;

namespace Algebra.Core.Collections
{
    public class DictionaryChangedEventArgs<K, V> : EventArgs
    {
        public enum ChangedAction
        {
            Add,
            Remove,
            Clear,
            Replace
        }

        public KeyValuePair<K, V> Item { get; private set; }
        public ChangedAction Action { get; private set; }

        public DictionaryChangedEventArgs(KeyValuePair<K, V> item, ChangedAction action)
        {
            Item = item;
            Action = action;
        }
    }
}
