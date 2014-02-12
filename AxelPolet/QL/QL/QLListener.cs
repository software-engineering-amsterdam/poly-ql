using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4;

namespace QL
{
    public class QLListener : QLBaseListener
    {
        public override void EnterQuestionnaire(QLParser.QuestionnaireContext context)
        {
            base.EnterQuestionnaire(context);
        }
    }
}
