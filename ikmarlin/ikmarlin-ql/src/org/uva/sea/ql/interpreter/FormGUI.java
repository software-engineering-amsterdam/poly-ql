package org.uva.sea.ql.interpreter;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.stmt.AnswerableQuestion;
import org.uva.sea.ql.ast.stmt.Block;
import org.uva.sea.ql.ast.stmt.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.IfThenElseStatement;
import org.uva.sea.ql.ast.stmt.IfThenStatement;
import org.uva.sea.ql.ast.stmt.Question;
import org.uva.sea.ql.ast.stmt.Stmt;
import org.uva.sea.ql.checker.visitor.IStmtVisitor;
import org.uva.sea.ql.interpreter.value.Bool;
import org.uva.sea.ql.interpreter.value.Value;
import org.uva.sea.ql.interpreter.visitor.ExprEvaluator;
import org.uva.sea.ql.interpreter.widget.AnswerableQuestionWidget;
import org.uva.sea.ql.interpreter.widget.Label;
import org.uva.sea.ql.interpreter.widget.Widget;
import org.uva.sea.ql.vendor.SpringUtilities;

public class FormGUI extends JFrame implements FocusListener, ActionListener, IStmtVisitor {
	
	private static final long serialVersionUID = 1L;
	
	private Form form;
	private Controller controller;
	private Map<String, Widget> widgets;
	private Map<String, String> labels;
	private JPanel content;
	private JButton saveBtn;
	
	public FormGUI(Form form, Map<String, List<String>> map) {
		this.form = form;
		controller = new Controller(this, map);
		widgets = new LinkedHashMap<String, Widget>();	
		labels = new LinkedHashMap<String, String>();
		content = new JPanel();
		content.setBorder(new EmptyBorder(0, 0, 5, 0));
		saveBtn = new JButton("save");
		saveBtn.addActionListener(this);
		setContentPane(content);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	}
	
	public void build(){
		widgets.clear();
		content.removeAll();
		form.getBlock().accept(this);
		layoutWidgets();
		content.add(saveBtn);
		this.setTitle(form.getIdent().getName());
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void layoutWidgets() {
		JPanel questionPanel = new JPanel(new SpringLayout());
		for(Map.Entry<String, Widget> row : widgets.entrySet()){
	        JLabel label = new JLabel(labels.get(row.getKey()), JLabel.TRAILING);
	        questionPanel.add(label);
	        label.setLabelFor(row.getValue().getWidget());
	        questionPanel.add(row.getValue().getWidget());
        }
        SpringUtilities.makeCompactGrid(questionPanel, widgets.size(), 2, 5, 5, 5, 5);
        content.add(questionPanel);
	}

	private void addWidget(Question question, Widget widget){
		widgets.put(question.getIdent().getName(), widget);
		labels.put(question.getIdent().getName(), question.getLabel());
	}

	@Override
	public void visit(AnswerableQuestion stmt) {
		Map<String, Value<?>> values = controller.getValues();
		AnswerableQuestionWidget widget = null;
		if(values.containsKey(stmt.getIdent().getName())){
			widget = new AnswerableQuestionWidget(stmt, values.get(stmt.getIdent().getName()));
		}else{
			widget = new AnswerableQuestionWidget(stmt);
		}
		widget.getWidget().setActionListener(this);
		addWidget(stmt, widget.getWidget());
	}

	@Override
	public void visit(ComputedQuestion stmt) {
		Value<?> computed = stmt.getComputation().accept(new ExprEvaluator(controller.getValues()));
		if(computed.getValue() != null){
			Widget widget = new Label(stmt, computed);
			addWidget(stmt, widget);
		}
	}

	@Override
	public void visit(IfThenStatement stmt) {
		Value<?> condition = stmt.getCondition().accept(new ExprEvaluator(controller.getValues()));
		if(condition.getValue() != null){
			Bool boolValue = (Bool) condition;
			if(boolValue.getValue()){
				stmt.getBody().accept(this);
			}
		}
	}

	@Override
	public void visit(IfThenElseStatement stmt) {
		Value<?> condition = stmt.getCondition().accept(new ExprEvaluator(controller.getValues()));
		if(condition.getValue() != null){
			Bool boolValue = (Bool) condition;
			if(boolValue.getValue()){
				stmt.getBody().accept(this);
			}else{
				stmt.getElseBlock().accept(this);
			}
		}
	}

	@Override
	public void visit(Block stmt) {
		for(Stmt s : stmt.getStatements()){
			s.accept(this);
		}
	}
	
	private void exportResults(){
		Map<String, Value<?>> values = controller.fixResults(form);
		WriteXML results = new WriteXML(form, values);
		File file = results.writeFile();
		if(file != null){
			JOptionPane.showMessageDialog(this, String.format("Results saved to: %s.",file.getPath()));
			System.exit(0);
		}
	}

	private void eventFired(AWTEvent e){
		JComponent c = (JComponent) e.getSource();
		widgets.get(c.getName()).setWidget(c);
		controller.change(widgets.get(c.getName()));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(saveBtn)){
			exportResults();
		}else{
			eventFired(e);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(!e.isTemporary() && e.getOppositeComponent() != null){
			JComponent c = (JComponent) e.getSource();
			if(!c.getName().equals(e.getOppositeComponent().getName())){
				eventFired(e);
			}
		}
	}

}
