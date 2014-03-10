
namespace QSLib
{
    public class MyListener : QSBaseListener
    {
        private QSParser parser;
        private Form root;

        public MyListener(QSParser parser)
        {
            this.parser = parser;
        }

        public override void ExitForm(QSParser.FormContext context)
        {
            root = context.f;
        }

        public Form Root
        {
            get
            {
                return root;
            }
        }
    }
}
