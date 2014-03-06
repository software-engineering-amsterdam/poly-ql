package org.uva.sea.ql.gui;

public class Main {

	public static void main(String[] args){
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	StartScreenView startScreen = new StartScreenView();
                startScreen.renderView();
            }
        });
	}
}
