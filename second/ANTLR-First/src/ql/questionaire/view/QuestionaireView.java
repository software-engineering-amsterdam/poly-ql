package ql.questionaire.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

import ql.questionaire.controller.QuestionaireController;

public class QuestionaireView {
	private Shell shell;
	private Display display;
	private Group questionGroup;

	private QuestionaireController controller;

	public QuestionaireView(){
		display = new Display();		
		shell = new Shell(display);
		shell.setLayout(new GridLayout(2, true));
		shell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		shell.setSize(500,600);
		questionGroup = new Group(shell, SWT.NONE);
		questionGroup.setLayout(new RowLayout(SWT.VERTICAL | SWT.FILL));

	}

	public void setController(QuestionaireController controller) {
		this.controller = controller;
	}

	public void start() {
		shell.open();
		controller.refreshQuestionSet();

		while (!shell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
		display.dispose(); 
	}

	public void refreshLayout() {
		shell.layout();
	}

	public Composite getDisplayParent() {
		return questionGroup;
	}

}
