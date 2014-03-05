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

/**
 *
 * @author svene_000
 */
public class UndefinedVariableError implements TypeError {

    String name;
    int line;

    public UndefinedVariableError(String name, int line) {
        this.name = name;
        this.line = line;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public void print() {
        System.out.println("Undefined variable: " + name + " on line: " + line);
    }

    public String toString() {
        return "Undefined variable: " + name + " on line: " + line;
    }

    @Override
    public JLabel renderAsLabel() {
       JLabel label = new JLabel("Undefined variable: " + name + " on line: "+line, new ImageIcon("error.png"), JLabel.LEFT);
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
