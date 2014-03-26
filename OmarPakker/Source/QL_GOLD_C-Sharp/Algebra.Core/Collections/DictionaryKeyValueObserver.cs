using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace Algebra.Core.Collections
{
    public class DictionaryKeyValueObserver<K, V> : IEnumerable<V>
    {
        public event Action FilterResultChanged;

        private readonly ObservableDictionary<K, V> dictionary;
        private readonly Func<KeyValuePair<K, V>, bool> predicate;

        public DictionaryKeyValueObserver(ObservableDictionary<K, V> dict, Func<KeyValuePair<K, V>, bool> filter)
        {
            dictionary = dict;
            predicate = filter;

            dictionary.DictionaryChanged += (args) =>
            {
                if (filter(args.Item))
                {
                    OnFilterResultChanged();
                }
            };
        }

        private void OnFilterResultChanged()
        {
            if (FilterResultChanged != null)
            {
                FilterResultChanged();
            }
        }

        public IEnumerator<V> GetEnumerator()
        {
            return dictionary.Where(predicate).Select(kv => kv.Value).GetEnumerator();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
    }
}
