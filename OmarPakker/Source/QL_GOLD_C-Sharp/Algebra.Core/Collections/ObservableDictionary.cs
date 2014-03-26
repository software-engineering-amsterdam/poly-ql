using System;
using System.Collections;
using System.Collections.Generic;

namespace Algebra.Core.Collections
{
    public class ObservableDictionary<K, V> : IDictionary<K, V>
    {
        public event Action<DictionaryChangedEventArgs<K, V>> DictionaryChanged;

        private readonly IDictionary<K, V> dictionary;

        public ObservableDictionary()
        {
            dictionary = new Dictionary<K, V>();
        }

        private void OnCollectionChanged(DictionaryChangedEventArgs<K, V> args)
        {
            if (DictionaryChanged != null)
            {
                DictionaryChanged(args);
            }
        }

        public void Add(K key, V value)
        {
            dictionary.Add(key, value);

            OnCollectionChanged(new DictionaryChangedEventArgs<K, V>(new KeyValuePair<K, V>(key, value),
                DictionaryChangedEventArgs<K, V>.ChangedAction.Add));
        }

        public void Add(KeyValuePair<K, V> item)
        {
            dictionary.Add(item);

            OnCollectionChanged(new DictionaryChangedEventArgs<K, V>(item,
                DictionaryChangedEventArgs<K, V>.ChangedAction.Add));
        }

        public bool Remove(K key)
        {
            bool success = dictionary.Remove(key);

            OnCollectionChanged(new DictionaryChangedEventArgs<K, V>(new KeyValuePair<K, V>(key, default(V)),
                DictionaryChangedEventArgs<K, V>.ChangedAction.Remove));

            return success;
        }

        public bool Remove(KeyValuePair<K, V> item)
        {
            bool success = dictionary.Remove(item);

            OnCollectionChanged(new DictionaryChangedEventArgs<K, V>(item,
                DictionaryChangedEventArgs<K, V>.ChangedAction.Remove));

            return success;
        }

        public void Clear()
        {
            dictionary.Clear();

            OnCollectionChanged(new DictionaryChangedEventArgs<K, V>(new KeyValuePair<K, V>(),
                DictionaryChangedEventArgs<K, V>.ChangedAction.Clear));
        }

        public bool ContainsKey(K key)
        {
            return dictionary.ContainsKey(key);
        }

        public bool Contains(KeyValuePair<K, V> item)
        {
            return dictionary.Contains(item);
        }

        public bool TryGetValue(K key, out V value)
        {
            return dictionary.TryGetValue(key, out value);
        }

        public void CopyTo(KeyValuePair<K, V>[] array, int arrayIndex)
        {
            dictionary.CopyTo(array, arrayIndex);
        }

        public ICollection<K> Keys
        {
            get { return dictionary.Keys; }
        }

        public ICollection<V> Values
        {
            get { return dictionary.Values; }
        }

        public int Count
        {
            get { return dictionary.Count; }
        }

        public bool IsReadOnly
        {
            get { return dictionary.IsReadOnly; }
        }

        public V this[K key]
        {
            get { return dictionary[key]; }
            set
            {
                DictionaryChangedEventArgs<K, V>.ChangedAction action = ContainsKey(key)
                    ? DictionaryChangedEventArgs<K, V>.ChangedAction.Replace
                    : DictionaryChangedEventArgs<K, V>.ChangedAction.Add;

                dictionary[key] = value;
                OnCollectionChanged(new DictionaryChangedEventArgs<K, V>(new KeyValuePair<K, V>(key, value), action));
            }
        }

        public IEnumerator<KeyValuePair<K, V>> GetEnumerator()
        {
            return dictionary.GetEnumerator();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return GetEnumerator();
        }
    }
}
