using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib
{
    public class MyListener : QSBaseListener
    {
        private QSParser parser;
        public delegate void Print(String text);
        public Print OnPrint { get; set; }
        public Form root;
        public List<String> variables = new List<String>();


        public MyListener(QSParser parser)
        {
            this.parser = parser;
        }

        public override void ExitForm(QSParser.FormContext context)
        {
            root = context.f;
        }
    }
}
