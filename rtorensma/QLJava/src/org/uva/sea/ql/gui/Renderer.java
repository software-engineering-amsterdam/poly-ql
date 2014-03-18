package org.uva.sea.ql.gui;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.Computed;
import org.uva.sea.ql.ast.stat.IfThen;
import org.uva.sea.ql.ast.stat.IfThenElse;
import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.checker.FormVisitor;
import org.uva.sea.ql.eval.ValueEnvironment;

public class Renderer implements FormVisitor<Void> {
	private final ValueEnvironment valueEnv;
	private final JPanel panel;
	
	public static JPanel render(Form form, ValueEnvironment env) {
		Renderer r = new Renderer(env);
		return r.panel;
	}
	
	private Renderer(ValueEnvironment env) {
		this.valueEnv = env;
		this.panel = new JPanel();
	}

	@Override
	public Void visit(Form ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Question ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Computed ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(IfThen ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(IfThenElse ast) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Block ast) {
		// TODO Auto-generated method stub
		return null;
	}

	public ValueEnvironment getValueEnv() {
		return valueEnv;
	}

	public JPanel getPanel() {
		return panel;
	}
}
