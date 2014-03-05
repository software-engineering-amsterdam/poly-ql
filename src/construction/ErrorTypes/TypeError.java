/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construction.ErrorTypes;

import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author svene_000
 */
public interface TypeError {

    public int getLine();
    
    public JLabel renderAsLabel();
    public void highLight(JTextArea j);

    public void print();

    @Override
    public String toString();

}
