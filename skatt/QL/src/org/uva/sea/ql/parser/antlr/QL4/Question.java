package org.uva.sea.ql.parser.antlr.QL4;


public class Question {
	private String label = "";
	private String type = "";
	private Value value = null;
	
	public Question(String label, String type, Value value) {
		setLabel(label);
		setType(type);
		setValue(value);
	}
	
	public Question(String label, String type) {
		setLabel(label);
		setType(type);
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Value getValue() {
		return value;
	}
	public void setValue(Value value) {
		this.value = value;
	}
	
	public String toString() {
		if (value != null)
			return "Label: " + label + " of type: "  + type + " with computed answer " + value;
		else 
			return "Label: " + label + " of type: "  + type + " with value "  + value;
	}
}

