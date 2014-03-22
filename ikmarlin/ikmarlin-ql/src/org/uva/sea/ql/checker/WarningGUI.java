package org.uva.sea.ql.checker;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.uva.sea.ql.checker.exception.QLException;

public class WarningGUI extends ExceptionGUI {

	public WarningGUI(List<QLException> warnings) {
		super(warnings);
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
			JOptionPane.showMessageDialog(new JFrame(), msg, "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}

}
