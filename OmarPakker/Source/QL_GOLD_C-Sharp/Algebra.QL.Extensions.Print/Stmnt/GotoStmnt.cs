using System.Windows.Documents;
using Algebra.QL.Print;
using Algebra.QL.Print.Stmnt;

namespace Algebra.QL.Extensions.Print.Stmnt
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
