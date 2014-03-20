package org.uva.sea.ql;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.checker.ErrorGUI;
import org.uva.sea.ql.checker.SemanticChecker;
import org.uva.sea.ql.checker.WarningGUI;
import org.uva.sea.ql.checker.visitor.StmtVisitorDependencies;
import org.uva.sea.ql.interpreter.FormGUI;
import org.uva.sea.ql.parser.test.FormParser;
import org.uva.sea.ql.parser.test.ParseError;

public class QL {

	private static Form form = null;
	private static SemanticChecker checker = null;
	
	public static void main(String[] args) throws ParseError {
		final JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileNameExtensionFilter("*.ql", "ql"));
		fc.setAcceptAllFileFilterUsed(false);
		int returnVal = fc.showOpenDialog(new JFrame());
		if(returnVal == JFileChooser.APPROVE_OPTION){
			parse(fc.getSelectedFile());
			check();
			render();
		} else {
			System.exit(0);
		}
	}
	
	private static void parse(File file) throws ParseError{
		FormParser fp = new FormParser();
			form = fp.parse(file);
	}
	
	private static void check(){
		if(form!=null){
			checker = new SemanticChecker(form);
			checker.check();
			if(checker.hasWarnings()){
				new WarningGUI(checker.getWarnings()).show();
			}
			if(checker.hasErrors()){
				new ErrorGUI(checker.getErrors()).show();
			}
		}
	}
	
	private static void render(){
		new FormGUI(form, new StmtVisitorDependencies(form).getDependencyMap()).build();
	}

}
