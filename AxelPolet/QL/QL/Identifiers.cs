using System.Collections.Generic;
using System.Linq;
using QL.QLClasses.Expressions.Types;
using QL.QLClasses.Statements;

namespace QL
{
    public class Identifiers
    {
        private readonly static Dictionary<QIdentifier, Question> _identifiers = new Dictionary<QIdentifier, Question>();

        public static bool IsDefined(string id)
        {
            return _identifiers.Keys.Any((k) => k.Identifier == id);
        }

        public static void AddIdentifier(string id, Question question)
        {
            _identifiers.Add(question.ID, question);
        }

        public static Question GetQuestion(string id)
        {
            return _identifiers.Single((k) => k.Key.Identifier == id).Value;
        }

        public static void Reset()
        {
            _identifiers.Clear();
        }
    }
}
