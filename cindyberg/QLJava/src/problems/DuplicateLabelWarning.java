package problems;

import org.uva.sea.ql.ast.literal.StringLiteral;

public class DuplicateLabelWarning extends Warning {
	
	public DuplicateLabelWarning(StringLiteral label){
		super("question [" + label.toString() + "] already exists");
	}

}
