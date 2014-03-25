package org.uva.sea.ql.gui;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.UsedVariables;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.Computed;
import org.uva.sea.ql.ast.stat.IfThen;
import org.uva.sea.ql.ast.stat.IfThenElse;
import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.ast.stat.Stat;
import org.uva.sea.ql.checker.FormVisitor;
import org.uva.sea.ql.eval.ValueEnvironment;
import org.uva.sea.ql.gui.inputs.Input;
import org.uva.sea.ql.gui.inputs.InputFactory;

public class Renderer implements FormVisitor<Void> {
	private final ValueEnvironment valueEnv;
	private final Map<Ident, Input> observables;
	private final JPanel panel;
	
	public static JPanel render(Stat stat, ValueEnvironment env) {
		Renderer r = new Renderer(env);
		stat.accept(r);
		return r.panel;
	}
	
	private Renderer(ValueEnvironment env) {
		this.valueEnv = env;
		this.panel = new JPanel(new MigLayout("wrap 2"));
		this.observables = new HashMap<Ident, Input>();
	}

	@Override
	public Void visit(Form ast) {
		ast.getBody().accept(this);
		return null;
	}

	@Override
	public Void visit(Question ast) {
		this.renderQuestion(ast, false);
		return null;
	}

	@Override
	public Void visit(Computed ast) {
		this.renderQuestion(ast, true);
		
		ComputedObserver observer = new ComputedObserver(ast, this.valueEnv, this.observables.get(ast.getName()));
		for (Ident ident : UsedVariables.usedVariables(ast.getExpr())) {
			this.observables.get(ident).addObserver(observer);
		}
		return null;
	}

	@Override
	public Void visit(IfThen ast) {
		JPanel trueQuestions = render(ast.getBody(), this.valueEnv);
		trueQuestions.setVisible(false);
		this.panel.add(trueQuestions, "span 2");
		
		ConditionalObserver observer = new ConditionalObserver(ast.getCond(), this.valueEnv, trueQuestions, new JPanel());
		for (Ident ident : UsedVariables.usedVariables(ast.getCond())) {
			this.observables.get(ident).addObserver(observer);
		}
		return null;
	}

	@Override
	public Void visit(IfThenElse ast) {
		JPanel trueQuestions = render(ast.getBody(), this.valueEnv);
		JPanel falseQuestions = render(ast.getElseBody(), this.valueEnv);
		
		trueQuestions.setVisible(false);
		falseQuestions.setVisible(false);
		
		this.panel.add(trueQuestions, "span 2");
		this.panel.add(falseQuestions, "span 2");
		
		ConditionalObserver observer = new ConditionalObserver(ast.getCond(), this.valueEnv, trueQuestions, falseQuestions);
		for (Ident ident : UsedVariables.usedVariables(ast.getCond())) {
			this.observables.get(ident).addObserver(observer);
		}
		return null;
	}

	@Override
	public Void visit(Block ast) {
		for (Stat s : ast.getStats()) {
			s.accept(this);
		}
		return null;
	}
	
	private void renderQuestion(Question question, boolean isComputed) {
		this.panel.add(new JLabel(question.getLabel()));
		Input input = InputFactory.inputForQuestion(question, isComputed, this.valueEnv);
		this.panel.add(input.getComponent());
		this.observables.put(question.getName(), input);
	}

	public ValueEnvironment getValueEnv() {
		return valueEnv;
	}

	public JPanel getPanel() {
		return panel;
	}

	public Map<Ident, Input> getObservables() {
		return observables;
	}
}
