package org.uva.sea.ql.checker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.checker.error.DuplicateQuestion;
import org.uva.sea.ql.checker.warning.DuplicateLabel;

public class CheckDuplicateQuestion {

	private Map<String, List<Type>> symbolTable;
	private List<String> errors;

	public CheckDuplicateQuestion(Map<String, List<Type>> symbolTable) {
		this.symbolTable = symbolTable;
		errors = new ArrayList<String>();
	}

	public List<String> getDuplicates() {
		for (Map.Entry<String, List<Type>> entry : symbolTable.entrySet()) {
			String ident = entry.getKey();
			if (entry.getValue().size() > 1) {
				Set<String> uniqueTypes = new HashSet<String>();
				for (Type t : entry.getValue()) {
					uniqueTypes.add(t.toString());
				}
				if (uniqueTypes.size() > 1) {
					addError(DuplicateQuestion.getMessage(ident));
				} else {
					addError(DuplicateLabel.getMessage(ident));
				}
			}
		}
		return errors;
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public List<String> getErrors() {
		return errors;
	}

	private void addError(String msg) {
		errors.add(msg);
	}

}
