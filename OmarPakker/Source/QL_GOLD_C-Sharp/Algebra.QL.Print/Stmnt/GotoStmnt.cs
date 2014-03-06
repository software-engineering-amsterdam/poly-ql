using System.Windows.Documents;

namespace Algebra.QL.Print.Stmnt
{
    public class GotoStmnt : Algebra.QL.Extensions.Stmnt.GotoStmnt, IPrintStmnt
    {
        public GotoStmnt(string gotoName)
            : base(gotoName)
		{

		}

        public Block BuildDocument()
        {
            Paragraph p = new Paragraph();
            p.Inlines.Add(new Run("goto") { Foreground = StyleSettings.KeyWordColor });
            p.Inlines.Add(" ");
            p.Inlines.Add(new Run(GotoName) { Foreground = StyleSettings.ReferenceColor });
            p.Inlines.Add(";");
            return p;
        }
    }
}
