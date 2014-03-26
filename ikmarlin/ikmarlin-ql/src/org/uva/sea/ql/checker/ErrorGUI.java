package org.uva.sea.ql.checker;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.uva.sea.ql.checker.exception.QLException;

public class ErrorGUI extends ExceptionGUI {

	public ErrorGUI(List<QLException> errors) {
		super(errors);
	}
	
	@Override
	public void show(){
		String msg = "";
		if(!exceptions.isEmpty()){
			for(Exception e : exceptions){
				msg = msg.concat(e.getMessage()).concat("\n");
			}
		}
		if(!msg.isEmpty()){
			JOptionPane.showMessageDialog(new JFrame(), msg, "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

}
