package org.uva.sea.ql.render;

import static org.uva.sea.ql.ast.expr.UsedVars.usedVars;
import static org.uva.sea.ql.render.TypeToWidget.typeToWidget;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.Stack;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stat.Answerable;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.stat.Computed;
import org.uva.sea.ql.ast.stat.IfThen;
import org.uva.sea.ql.ast.stat.IfThenElse;
import org.uva.sea.ql.ast.stat.Question;
import org.uva.sea.ql.ast.stat.Stat;
import org.uva.sea.ql.ast.stat.Visitor;
import org.uva.sea.ql.eval.Bool;
import org.uva.sea.ql.eval.Eval;
import org.uva.sea.ql.eval.Value;

public class Renderer implements Visitor {
	private final JPanel panel;
	private final Map<Ident, Value> env;
	private final Stack<List<JComponent>> stack;
	private final Map<Ident, Observable> listeners;

	public static JPanel render(Form form, Map<Ident, Value> env) {
		Renderer r = new Renderer(env);
		form.getBody().accept(r);
		return r.getPanel();
	}
	
	private JPanel getPanel() {
		return panel;
	}
	
	
	private Renderer(Map<Ident, Value> env) {
		this.env = env;
		this.panel = new JPanel(new MigLayout("wrap 2"));
		this.listeners = new HashMap<Ident, Observable>();
		this.stack = new Stack<List<JComponent>>();
		stack.push(new ArrayList<JComponent>());
	}
	
	
	
	private void add(JComponent comp) {
		stack.peek().add(comp);
		panel.add(comp);
	}

	private List<JComponent> guardedComponents(Stat stat) {
		stack.push(new ArrayList<JComponent>());
		stat.accept(this); 
		return stack.pop();
	}
	
	private void registerDeps(Expr expr, Observer obs) {
		Set<Ident> vars = usedVars(expr);
		for (Ident x: vars) {
			listeners.get(x).addObserver(obs);
		}
	}
	
	private static void setVisible(Collection<JComponent> comps, boolean visible) {
		for (JComponent c: comps) {
			c.setVisible(visible);
		}
	}
	
	private void registerHandler(final Question stat, final Widget comp) {
		Handler handler = new Handler() {
			@Override
			public void handleEvent() {
				debug("Change of " + stat.getName());
				env.put(stat.getName(), comp.getValue());
				setChanged();
				notifyObservers();
			}

		};
		comp.setHandler(handler);
		listeners.put(stat.getName(), handler);	
	}
	
	protected void debug(String msg) {
		System.out.println(msg);
		System.out.println(env);
	}

	private void registerComputedDeps(final Computed stat, final Widget comp) {
		registerDeps(stat.getExpr(), new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				debug("Updating computed " + stat.getName());
				Value value = stat.getExpr().accept(new Eval(env));
				env.put(stat.getName(), value);
				listeners.get(stat.getName()).notifyObservers();
				comp.setValue(value);
			}
		});
	}

	
	@Override
	public void visit(final Computed stat) {
		add(new JLabel(stat.getLabel().getValue()));
		final Widget comp = typeToWidget(stat.getType(), false);
		registerComputedDeps(stat, comp);
		//registerHandler(stat, comp);
		listeners.put(stat.getName(), new Observable() {
			@Override
			public void notifyObservers() {
				setChanged();
				super.notifyObservers();
			}
		});
		add(comp.getComponent());
	}

	@Override
	public void visit(Answerable stat) {
		add(new JLabel(stat.getLabel().getValue()));
		Widget comp = typeToWidget(stat.getType(), true);
		registerHandler(stat, comp);
		add(comp.getComponent());
	}
	
	private void registerConditionDeps(final Expr cond, final List<JComponent> tru, final List<JComponent> fls) {
		registerDeps(cond, new Observer() {
			@Override
			public void update(Observable o, Object arg) {
				Value value = cond.accept(new Eval(env));
				boolean visible = value.isDefined() && ((Bool)value).getValue();
				setVisible(tru, visible);
				setVisible(fls, !visible);
			}
		});
	}
	

	@Override
	public void visit(final IfThen stat) {
		final List<JComponent> comps = guardedComponents(stat.getBody());
		registerConditionDeps(stat.getCond(), comps, Collections.<JComponent>emptyList());
		setVisible(comps, false);
	}

	@Override
	public void visit(final IfThenElse stat) {
		final List<JComponent> comps = guardedComponents(stat.getBody());
		final List<JComponent> elseComps = guardedComponents(stat.getElseBody());
		registerConditionDeps(stat.getCond(), comps, elseComps);
		setVisible(comps, false);
		setVisible(elseComps, false);
	}

	@Override
	public void visit(Block stat) {
		for (Stat s: stat.getStats()) {
			s.accept(this);
		}
	}

}
