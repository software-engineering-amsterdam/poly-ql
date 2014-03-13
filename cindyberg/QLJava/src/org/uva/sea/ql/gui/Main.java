package org.uva.sea.ql.gui;

import org.uva.sea.ql.gui.startIDE.StartScreen;

public class Main {

	public static void main(String[] args){
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	StartScreen startScreen = new StartScreen();
                startScreen.newScreen();
            }
        });
	}
}
