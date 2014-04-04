using System.Windows.Documents;

namespace Algebra.QL.Print.Stmnt
{
    public class BlockStmnt : IPrintStmnt
    {
        private readonly IPrintStmnt Body;

        public BlockStmnt(IPrintStmnt s)
        {
            Body = s;
        }

        public Block BuildDocument(int indentation)
        {
            Section s = new Section();
            s.Blocks.Add(new Paragraph(new Run("{")));
            s.Blocks.Add(Body.BuildDocument(indentation));
            s.Blocks.Add(new Paragraph(new Run("}")));

            return s;
        }
    }
}
