using System.Windows.Documents;

namespace Algebra.QL.Print.Stmnt
{
    public class GotoStmnt : IPrintStmnt
    {
        public GotoStmnt()
		{

		}

        public Block BuildDocument()
        {
            Paragraph p = new Paragraph();
            p.Inlines.Add(new Run("gotoNextForm") { Foreground = StyleSettings.KeyWordColor });
            p.Inlines.Add(";");
            return p;
        }
    }
}
