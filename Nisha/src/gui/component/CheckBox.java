package gui.component;

import expr.Ident;
import expr.operation.Operation;
import gui.render.Renderer;
import gui.render.State;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

import ast.evaluate.Bool;
import ast.evaluate.Value;
import ast.form.Form;
import ast.form.IfElse;
import ast.form.Ifstate;
import ast.form.Statement;

public class CheckBox extends Control implements ItemListener {

	private JCheckBox checkBox;
	private Form form;
	private State state;
	private Ident id;
	Ident elseLHS;
	Ifstate ElseIfNode;

	public CheckBox(String description, Ident id, Form form, State state) {
		super();
		this.form = form;
		this.state = state;
		this.id = id;
		checkBox = new JCheckBox(description, false);
		checkBox.setName(id.id);
		checkBox.addItemListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {

		publishEventChange();
		JPanel frame1 = (JPanel)checkBox.getParent();
		Component[] components = frame1.getComponents();
		Component jcomponent = null;
		
		for (int j = 0; j < components.length; j++) {
			jcomponent = components[j];
			if (jcomponent instanceof JCheckBox) {
				
				if(!((JCheckBox) jcomponent).isSelected())
				{
					jcomponent.setEnabled(false);
				}
				
			}
			}
		
		

		Renderer r = new Renderer(state, form);
		ArrayList<Statement> formStatement = form.getStatements().getList();
		JComponent currPanel = null;
		JPanel frame = (JPanel) checkBox.getParent().getParent();
		Map<String, Value> env = state.getEnvValues();

		// System.out.println(((Bool)env.get(id.id)).getValue());

		frame.setLayout(new GridBagLayout());
		if (checkBox.isSelected() == true) {
			for (int i = 0; i < formStatement.size(); i++) {
				if (formStatement.get(i).getClass() == IfElse.class) {
					
					IfElse IfNode = (IfElse) formStatement.get(i);
					Operation EqExpression = (Operation) IfNode.getExpr();
					Ident ifLHS = ((Ident) EqExpression.getLhs());
					
					ArrayList<Statement> elseNode = IfNode.getStatement1()
							.getList();
					for (int j = 0; j < elseNode.size(); j++) {

						if (elseNode.get(j).getClass() == Ifstate.class) {
							ElseIfNode = (Ifstate) elseNode.get(j);
							Operation EqExpression1 = (Operation) ElseIfNode
									.getExpr();
							elseLHS = ((Ident) EqExpression1.getLhs());
						}
						
						if (checkBox.getName().equals(ifLHS.id)
								&& ((Bool) env.get(id.id)).getValue() == true) {
							ArrayList<Statement> ifStatement = IfNode
									.getStatements().getList();
							for (int k = 0; k < ifStatement.size(); k++) {
								GridBagConstraints c = new GridBagConstraints();
								c.gridx = 0;
								c.gridy = 1;
								currPanel = ifStatement.get(k).accept(r);
								frame.add(currPanel, c);
								frame.revalidate();
								frame.repaint();

							}

						} else if (checkBox.getName().equals(elseLHS.id)
								&& ((Bool) env.get(id.id)).getValue() == true) {
							ArrayList<Statement> elseStatement = ElseIfNode
									.getStatements().getList();
							for (int g = 0; g < elseStatement.size(); g++) {
								GridBagConstraints c = new GridBagConstraints();
								c.gridx = 0;
								c.gridy = 1;
								currPanel = elseStatement.get(g).accept(r);
								frame.add(currPanel, c);
								frame.revalidate();
								frame.repaint();

							}
						}
						// }
					}
				}
			}
		} else if (checkBox.isSelected() == false) {
			
			for (int j = 0; j < components.length; j++) {
				jcomponent = components[j];
				if (jcomponent instanceof JCheckBox) {
					
					if(!((JCheckBox) jcomponent).isSelected())
					{
						jcomponent.setEnabled(true);
					}
					
				}
				}
			
			
			Component[] comp = frame.getComponents();
			Component component = null;
			for (int j = 1; j < comp.length; j++) {
				component = comp[j];
				frame.remove(component);

			}
		}
		frame.revalidate();
		frame.repaint();

		// parentPanel.getComponent(n).setVisible(false);

	}

	@Override
	public JComponent getComponent() {
		return checkBox;
	}

	@Override
	public Value getValue() {
		return new Bool(checkBox.isSelected());
	}

}