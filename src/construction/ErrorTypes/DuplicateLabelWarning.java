/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package construction.ErrorTypes;

import construction.MainWindow;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author svene_000
 */
public class DuplicateLabelWarning implements TypeError {
    
    int line;

    public DuplicateLabelWarning(int line) {
        this.line = line;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public void print() {
        System.out.println("Warning, duplicate label on line: "+line);
    }
    
    public String toString()
    {
        return "Warning, duplicate label on line: "+line;
    }

    @Override
    public JLabel renderAsLabel() {
     JLabel label = new JLabel("Warning duplicate label on line: "+line, new ImageIcon("warning.png"), JLabel.LEFT);
        label.setBackground(new Color(255,255,204));
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
                Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(new Color(255,255,204));
                j.getHighlighter().addHighlight(startIndex, endIndex, painter);
            //    jTextArea1.geth
            } catch (BadLocationException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
