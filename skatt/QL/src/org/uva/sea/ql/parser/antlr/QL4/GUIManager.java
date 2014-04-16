package org.uva.sea.ql.parser.antlr.QL4;

import java.util.List;

import org.uva.sea.ql.parser.antlr.QL4.AST.Form;
import org.uva.sea.ql.parser.antlr.QL4.GUI.ErrorGUI;
import org.uva.sea.ql.parser.antlr.QL4.GUI.GUI;
import org.uva.sea.ql.parser.antlr.QL4.GUI.QuestionairGUI;
import org.uva.sea.ql.parser.antlr.QL4.Messages.QLErrorMsg;

/**
 * Manages the GUI of Question language. Either runs error display or questionair display
 * @author Sammie Katt
 */
public class GUIManager {

	final private Form ast;
	final private List<QLErrorMsg> errors;
	private GUI gui;
	
	public GUIManager(Form ast, List<QLErrorMsg> errors) {
		this.ast = ast;
		this.errors = errors;
	}

	public void run() {
		
		// set correct gui
		if (errors.isEmpty()) {
			gui = new QuestionairGUI();
			gui.setForm(ast);
		} else {
			gui = new ErrorGUI();
			gui.setErrors(errors);
		}
		
		// run gui
		new Thread(gui).start();
	}

}
