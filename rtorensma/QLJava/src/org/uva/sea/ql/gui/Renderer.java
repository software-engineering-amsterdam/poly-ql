package org.uva.sea.ql.gui;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.Computed;
import org.uva.sea.ql.ast.stat.IfThen;
import org.uva.sea.ql.ast.stat.IfThenElse;
import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.ast.stat.Stat;
import org.uva.sea.ql.checker.FormVisitor;
import org.uva.sea.ql.eval.ValueEnvironment;

public class Renderer implements FormVisitor<Void> {
	private final ValueEnvironment valueEnv;
	private final JPanel panel;
	
	public static JPanel render(Form form, ValueEnvironment env) {
		Renderer r = new Renderer(env);
		form.accept(r);
		return r.panel;
	}
	
	private Renderer(ValueEnvironment env) {
		this.valueEnv = env;
		this.panel = new JPanel();
		this.panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		BoxLayout box = new BoxLayout(this.panel, BoxLayout.Y_AXIS);
		panel.setLayout(box);
	}

	@Override
	public Void visit(Form ast) {
		ast.getBody().accept(this);
		return null;
	}

	@Override
	public Void visit(Question ast) {
		this.panel.add(new JLabel(ast.getLabel()));
		InputField inputfield = InputFieldFactory.inputFieldForType(ast.getType(), true);
		this.panel.add(inputfield.getComponent());
		return null;
	}

	@Override
	public Void visit(Computed ast) {
		this.panel.add(new JLabel(ast.getLabel()));
		InputField inputfield = InputFieldFactory.inputFieldForType(ast.getType(), false);
		this.panel.add(inputfield.getComponent());
		return null;
	}

	@Override
	public Void visit(IfThen ast) {
		ast.getBody().accept(this);
		return null;
	}

	@Override
	public Void visit(IfThenElse ast) {
		ast.getBody().accept(this);
		ast.getElseBody().accept(this);
		return null;
	}

	@Override
	public Void visit(Block ast) {
		for (Stat s : ast.getStats()) {
			s.accept(this);
		}
		return null;
	}

	public ValueEnvironment getValueEnv() {
		return valueEnv;
	}

	public JPanel getPanel() {
		return panel;
	}
}
