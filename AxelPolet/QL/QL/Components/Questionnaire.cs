using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Components
{
    public class Questionnaire
    {
        public string ID { get; set; }
        public string Title { get; set; }
        public List<Question> Questions { get; private set; }

        public Questionnaire()
        {
            Questions = new List<Question>();
        }
    }
}
