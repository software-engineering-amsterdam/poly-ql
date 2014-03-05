/* 
 * Copyright (C) 2014 svene_000
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package construction.ErrorTypes;

import construction.MainWindow;
import construction.Types.IType;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class InvalidOperandError implements TypeError {

    IType l, r, expected;
    int line;

    public InvalidOperandError(IType l, IType r, IType expected, int line) {
        this.l = l;
        this.r = r;
        this.expected = expected;
        this.line = line;
    }

    public InvalidOperandError(IType l, IType expected, int line) {
        this.l = l;
        this.r = r;
        this.expected = expected;
        this.line = line;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public void print() {
        if (r == null && expected == null) {
            System.out.println("Invalid Type. Line: " + line);
            return;
        } else if (r == null) {
            System.out.println("Invalid expression. Line: " + line);
            System.out.println("Expected: " + expected.toString() + " Found: " + l.toString());
            return;
        }
        if (!l.isCompatible(expected)) {
            System.out.println("Invalid expression on lefthand side. Line: " + line);
            System.out.println("Expected: " + expected.toString() + " Found: " + l.toString());
        }
        if (!r.isCompatible(expected)) {
            System.out.println("Invalid expression on righthand side. Line: " + line);
            System.out.println("Expected: " + expected.toString() + " Found: " + r.toString());
        }
    }

    @Override
    public JLabel renderAsLabel() {
        JLabel label = new JLabel("Invalid expression. Line: " + line, new ImageIcon("error.png"), JLabel.LEFT);
        if (r == null && expected == null) {
            label = new JLabel("Invalid type. Line: " + line, new ImageIcon("error.png"), JLabel.LEFT);
        } else if (r == null) {
            label = new JLabel("<html>Invalid expression. Line: " + line + "<br>Expected: " + expected.toString() + " Found: " + l.toString() + "</html>", new ImageIcon("error.png"), JLabel.LEFT);
        }
        else if (l != null && !l.isCompatible(expected)) {
            label = new JLabel("<html>Invalid expression on left hand side. Line: " + line + "<br>Expected: " + expected.toString() + " Found: " + l.toString() + "</html>", new ImageIcon("error.png"), JLabel.LEFT);
        }
        else if (r != null && !r.isCompatible(expected)) {
            label = new JLabel("<html>Invalid expression on right hand side. Line: " + line + "<br>Expected: " + expected.toString() + " Found: " + r.toString() + "</html>", new ImageIcon("error.png"), JLabel.LEFT);
        }
        label.setBackground(new Color(255, 240, 240));
        label.setForeground(Color.BLACK);
        label.setOpaque(true);
        label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        return label;
    }

       @Override
        public void highLight(JTextArea j) {
        try {
                int startIndex = j.getLineStartOffset(line - 1);
                int endIndex = j.getLineEndOffset(line-1);
                Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(new Color(255, 240, 240));
                j.getHighlighter().addHighlight(startIndex, endIndex, painter);
            //    jTextArea1.geth
            } catch (BadLocationException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}
