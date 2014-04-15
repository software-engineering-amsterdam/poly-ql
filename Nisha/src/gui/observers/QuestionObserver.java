package gui.observers;

import java.util.ArrayList;

import javax.swing.JCheckBox;

import ast.form.Form;
import ast.form.IfElse;
import ast.form.Ifstate;
import ast.form.Statement;
import expr.Ident;
import expr.relational.Eq;
import gui.component.Control;
import gui.render.Renderer;
import gui.render.State;

public class QuestionObserver extends ControlObserver {

	private final Ident question;
	protected Control questionPanel;
	private final State state;
	private final Form form;
	

	public QuestionObserver(Ident question, Control questionComp, State state, Form form) {
		super();
		this.question = question;
		this.questionPanel = questionComp;
		this.state = state;
		this.form=form;
	}

	@Override
	public void evaluate() {
		Renderer r=new Renderer(state, form);
		
			JCheckBox checkbox= (JCheckBox) questionPanel.getComponent();
			//state.getEnvValues().getk
			if((checkbox.isSelected())==true)
			{
				ArrayList<Statement> formStatement= form.getStatements().getList();
				for(int i=0;i<formStatement.size();i++)
				{
					if(formStatement.get(i).getClass()==IfElse.class)
					{
						IfElse IfElseNode=(IfElse) formStatement.get(i);
						Eq EqExpression =(Eq) IfElseNode.getExpr();
						Ident LHS=((Ident)EqExpression.getLhs());
						if(checkbox.getName().equals(LHS.id))
						{
						ArrayList<Statement> ifStatement=IfElseNode.getStatement1().getList();
						for(int j=0;j<ifStatement.size();j++)
						{
							Ifstate IfPart=(Ifstate) ifStatement.get(j);
							r.visit(IfPart);
						}
						}
					}
				}
			}

		//System.out.println(form);

		
	}

}
