package org.uva.sea.ql.interpreter;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.interpreter.value.Value;
import org.uva.sea.ql.interpreter.widget.Widget;

public class Controller {
	
	private Results results;
	private FormGUI formGUI;
	private Map<String, List<String>> dependencies;
	
	public Controller(FormGUI formGUI, Map<String, List<String>> map){
		this.results = new Results();
		this.formGUI = formGUI;
		this.dependencies = map;
	}
	
	public void change(Widget widget) {
		results.setValue(widget.getWidget().getName(), widget.getValue());
		if(dependencies.containsKey(widget.getWidget().getName())){
			System.out.println(dependencies);
			formGUI.build();
		}
	}
	
	public Map<String, Value<?>> getValues() {
		return results.getValues();
	}
	
	public Map<String, Value<?>> fixResults(Form form){
		results.fixResults(form);
		return results.getValues();
	}
	
}
