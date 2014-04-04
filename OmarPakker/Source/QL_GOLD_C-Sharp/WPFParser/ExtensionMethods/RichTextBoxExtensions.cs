using System;
using System.Windows.Controls;
using System.Windows.Documents;

namespace WPFParser.ExtensionMethods
{
    public static class RichTextBoxExtensions
    {
        public static TextPointer GetTextPointerForPosition(this RichTextBox rtb, Tuple<int, int> position)
        {
            return rtb.GetTextPointerForPosition(position.Item1, position.Item2);
        }

        public static TextPointer GetTextPointerForPosition(this RichTextBox rtb, int line, int column)
        {
            TextPointer docStartLine = rtb.Document.ContentStart.GetLineStartPosition(0);
            TextPointer tp = docStartLine.GetLineStartPosition(line);

            for (int i = 0; i <= column; i++)
            {
                tp = tp.GetNextInsertionPosition(LogicalDirection.Forward);
            }

            return tp;
        }

        public static int GetLineForTextPointer(this RichTextBox rtb, TextPointer tp)
        {
            TextPointer tpLine = tp.GetLineStartPosition(0);
            int lineNr = 1;

            for (TextPointer linePointer = rtb.Document.ContentStart.GetLineStartPosition(0);
                linePointer.CompareTo(tpLine) < 0; linePointer = linePointer.GetLineStartPosition(1))
            {
                lineNr++;
            }

            return lineNr;
        }

        public static int GetColumnForTextPointer(this RichTextBox rtb, TextPointer tp)
        {
            TextPointer tpColumn = tp.GetInsertionPosition(LogicalDirection.Backward);
            int columnNr = 1;

            for (TextPointer linePointer = tpColumn.GetLineStartPosition(0).GetNextInsertionPosition(LogicalDirection.Forward);
                linePointer.CompareTo(tpColumn) < 0; linePointer = linePointer.GetNextInsertionPosition(LogicalDirection.Forward))
            {
                columnNr++;
            }

            return columnNr;
        }
    }
}
