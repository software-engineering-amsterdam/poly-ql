package ql.main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class ErrorWindow {

	public static void displayMessage(String message) {
		Display display = new Display();		
		Shell shell = new Shell(display);
		MessageBox dialog = 
				new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK);
		dialog.setText("Error");
		dialog.setMessage(message);
		dialog.open(); 
	}

}
